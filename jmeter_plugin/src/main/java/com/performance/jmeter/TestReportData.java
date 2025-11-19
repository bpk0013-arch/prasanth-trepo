package com.performance.jmeter;

import java.util.Date;
import java.util.List;

/**
 * Data model for test report
 */
public class TestReportData {
    private String projectName;
    private String testEnvironment;
    private String testerName;
    private Date testStartTime;
    private Date testEndTime;
    private long testDuration;
    private long totalSamples;
    private long totalErrors;
    private double overallErrorPercentage;
    private double averageResponseTime;
    private List<TransactionMetrics> transactions;
    
    // Getters and Setters
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    
    public String getTestEnvironment() { return testEnvironment; }
    public void setTestEnvironment(String testEnvironment) { this.testEnvironment = testEnvironment; }
    
    public String getTesterName() { return testerName; }
    public void setTesterName(String testerName) { this.testerName = testerName; }
    
    public Date getTestStartTime() { return testStartTime; }
    public void setTestStartTime(Date testStartTime) { this.testStartTime = testStartTime; }
    
    public Date getTestEndTime() { return testEndTime; }
    public void setTestEndTime(Date testEndTime) { this.testEndTime = testEndTime; }
    
    public long getTestDuration() { return testDuration; }
    public void setTestDuration(long testDuration) { this.testDuration = testDuration; }
    
    public long getTotalSamples() { return totalSamples; }
    public void setTotalSamples(long totalSamples) { this.totalSamples = totalSamples; }
    
    public long getTotalErrors() { return totalErrors; }
    public void setTotalErrors(long totalErrors) { this.totalErrors = totalErrors; }
    
    public double getOverallErrorPercentage() { return overallErrorPercentage; }
    public void setOverallErrorPercentage(double overallErrorPercentage) { 
        this.overallErrorPercentage = overallErrorPercentage; 
    }
    
    public double getAverageResponseTime() { return averageResponseTime; }
    public void setAverageResponseTime(double averageResponseTime) { 
        this.averageResponseTime = averageResponseTime; 
    }
    
    public List<TransactionMetrics> getTransactions() { return transactions; }
    public void setTransactions(List<TransactionMetrics> transactions) { 
        this.transactions = transactions; 
    }
}

/**
 * Metrics for individual transaction
 */
class TransactionMetrics {
    private String transactionName;
    private long sampleCount;
    private long errorCount;
    private double errorPercentage;
    private double averageResponseTime;
    private long minResponseTime;
    private long maxResponseTime;
    private double percentile90;
    private double percentile95;
    private double percentile99;
    private double throughput;
    
    // Getters and Setters
    public String getTransactionName() { return transactionName; }
    public void setTransactionName(String transactionName) { this.transactionName = transactionName; }
    
    public long getSampleCount() { return sampleCount; }
    public void setSampleCount(long sampleCount) { this.sampleCount = sampleCount; }
    
    public long getErrorCount() { return errorCount; }
    public void setErrorCount(long errorCount) { this.errorCount = errorCount; }
    
    public double getErrorPercentage() { return errorPercentage; }
    public void setErrorPercentage(double errorPercentage) { this.errorPercentage = errorPercentage; }
    
    public double getAverageResponseTime() { return averageResponseTime; }
    public void setAverageResponseTime(double averageResponseTime) { 
        this.averageResponseTime = averageResponseTime; 
    }
    
    public long getMinResponseTime() { return minResponseTime; }
    public void setMinResponseTime(long minResponseTime) { this.minResponseTime = minResponseTime; }
    
    public long getMaxResponseTime() { return maxResponseTime; }
    public void setMaxResponseTime(long maxResponseTime) { this.maxResponseTime = maxResponseTime; }
    
    public double getPercentile90() { return percentile90; }
    public void setPercentile90(double percentile90) { this.percentile90 = percentile90; }
    
    public double getPercentile95() { return percentile95; }
    public void setPercentile95(double percentile95) { this.percentile95 = percentile95; }
    
    public double getPercentile99() { return percentile99; }
    public void setPercentile99(double percentile99) { this.percentile99 = percentile99; }
    
    public double getThroughput() { return throughput; }
    public void setThroughput(double throughput) { this.throughput = throughput; }
}
