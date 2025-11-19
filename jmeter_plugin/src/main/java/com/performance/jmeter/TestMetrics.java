package com.performance.jmeter;

import org.apache.jmeter.samplers.SampleResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Stores and calculates metrics for a specific transaction/sampler
 */
public class TestMetrics {
    private long sampleCount = 0;
    private long errorCount = 0;
    private long totalResponseTime = 0;
    private long minResponseTime = Long.MAX_VALUE;
    private long maxResponseTime = 0;
    private List<Long> responseTimes = new ArrayList<>();
    private long startTime = Long.MAX_VALUE;
    private long endTime = 0;
    
    public synchronized void addSample(SampleResult result) {
        sampleCount++;
        long responseTime = result.getTime();
        
        if (!result.isSuccessful()) {
            errorCount++;
        }
        
        totalResponseTime += responseTime;
        responseTimes.add(responseTime);
        
        if (responseTime < minResponseTime) {
            minResponseTime = responseTime;
        }
        if (responseTime > maxResponseTime) {
            maxResponseTime = responseTime;
        }
        
        long sampleStart = result.getStartTime();
        long sampleEnd = result.getEndTime();
        
        if (sampleStart < startTime) {
            startTime = sampleStart;
        }
        if (sampleEnd > endTime) {
            endTime = sampleEnd;
        }
    }
    
    public long getSampleCount() {
        return sampleCount;
    }
    
    public long getErrorCount() {
        return errorCount;
    }
    
    public double getErrorPercentage() {
        return sampleCount > 0 ? (errorCount * 100.0 / sampleCount) : 0;
    }
    
    public double getAverageResponseTime() {
        return sampleCount > 0 ? (totalResponseTime / (double) sampleCount) : 0;
    }
    
    public long getMinResponseTime() {
        return minResponseTime == Long.MAX_VALUE ? 0 : minResponseTime;
    }
    
    public long getMaxResponseTime() {
        return maxResponseTime;
    }
    
    public double getPercentile90() {
        return calculatePercentile(90);
    }
    
    public double getPercentile95() {
        return calculatePercentile(95);
    }
    
    public double getPercentile99() {
        return calculatePercentile(99);
    }
    
    public double getThroughput() {
        long duration = endTime - startTime;
        if (duration > 0) {
            return (sampleCount * 1000.0) / duration;
        }
        return 0;
    }
    
    private double calculatePercentile(int percentile) {
        if (responseTimes.isEmpty()) {
            return 0;
        }
        
        List<Long> sorted = new ArrayList<>(responseTimes);
        Collections.sort(sorted);
        
        int index = (int) Math.ceil((percentile / 100.0) * sorted.size()) - 1;
        if (index < 0) index = 0;
        if (index >= sorted.size()) index = sorted.size() - 1;
        
        return sorted.get(index);
    }
}
