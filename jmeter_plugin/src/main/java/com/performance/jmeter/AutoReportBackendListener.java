package com.performance.jmeter;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.visualizers.backend.AbstractBackendListenerClient;
import org.apache.jmeter.visualizers.backend.BackendListenerContext;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * JMeter Backend Listener for automatic report generation
 * Collects test results and generates PDF/Excel reports on test completion
 */
public class AutoReportBackendListener extends AbstractBackendListenerClient {
    
    private static final String OUTPUT_DIR = "outputDirectory";
    private static final String REPORT_NAME = "reportName";
    private static final String GENERATE_PDF = "generatePDF";
    private static final String GENERATE_EXCEL = "generateExcel";
    private static final String PROJECT_NAME = "projectName";
    private static final String TEST_ENVIRONMENT = "testEnvironment";
    private static final String TESTER_NAME = "testerName";
    
    private String outputDirectory;
    private String reportName;
    private boolean generatePDF;
    private boolean generateExcel;
    private String projectName;
    private String testEnvironment;
    private String testerName;
    
    private Map<String, TestMetrics> metricsMap = new ConcurrentHashMap<>();
    private long testStartTime;
    private long testEndTime;
    
    @Override
    public Arguments getDefaultParameters() {
        Arguments arguments = new Arguments();
        arguments.addArgument(OUTPUT_DIR, "${__P(user.dir)}/reports");
        arguments.addArgument(REPORT_NAME, "Performance_Test_Report");
        arguments.addArgument(GENERATE_PDF, "true");
        arguments.addArgument(GENERATE_EXCEL, "true");
        arguments.addArgument(PROJECT_NAME, "BIE Performance Test");
        arguments.addArgument(TEST_ENVIRONMENT, "Test Environment");
        arguments.addArgument(TESTER_NAME, "Prasanth Kumar Birupogu");
        return arguments;
    }

    @Override
    public void setupTest(BackendListenerContext context) throws Exception {
        outputDirectory = context.getParameter(OUTPUT_DIR);
        reportName = context.getParameter(REPORT_NAME);
        generatePDF = Boolean.parseBoolean(context.getParameter(GENERATE_PDF));
        generateExcel = Boolean.parseBoolean(context.getParameter(GENERATE_EXCEL));
        projectName = context.getParameter(PROJECT_NAME);
        testEnvironment = context.getParameter(TEST_ENVIRONMENT);
        testerName = context.getParameter(TESTER_NAME);
        
        testStartTime = System.currentTimeMillis();
        
        // Create output directory if it doesn't exist
        File dir = new File(outputDirectory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        getLogger().info("Auto Report Plugin initialized. Reports will be saved to: " + outputDirectory);
    }

    @Override
    public void handleSampleResults(List<SampleResult> sampleResults, BackendListenerContext context) {
        for (SampleResult result : sampleResults) {
            String label = result.getSampleLabel();
            
            TestMetrics metrics = metricsMap.computeIfAbsent(label, k -> new TestMetrics());
            metrics.addSample(result);
        }
    }

    @Override
    public void teardownTest(BackendListenerContext context) throws Exception {
        testEndTime = System.currentTimeMillis();
        
        getLogger().info("Test completed. Generating reports...");
        
        try {
            TestReportData reportData = prepareReportData();
            
            String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
            String baseFileName = reportName + "_" + timestamp;
            
            if (generatePDF) {
                String pdfPath = outputDirectory + File.separator + baseFileName + ".pdf";
                PDFReportGenerator.generateReport(reportData, pdfPath);
                getLogger().info("PDF report generated: " + pdfPath);
            }
            
            if (generateExcel) {
                String excelPath = outputDirectory + File.separator + baseFileName + ".xlsx";
                ExcelReportGenerator.generateReport(reportData, excelPath);
                getLogger().info("Excel report generated: " + excelPath);
            }
            
            getLogger().info("Report generation completed successfully!");
            
        } catch (Exception e) {
            getLogger().error("Error generating reports", e);
        }
    }
    
    private TestReportData prepareReportData() {
        TestReportData data = new TestReportData();
        data.setProjectName(projectName);
        data.setTestEnvironment(testEnvironment);
        data.setTesterName(testerName);
        data.setTestStartTime(new Date(testStartTime));
        data.setTestEndTime(new Date(testEndTime));
        data.setTestDuration(testEndTime - testStartTime);
        
        List<TransactionMetrics> transactions = new ArrayList<>();
        long totalSamples = 0;
        long totalErrors = 0;
        double totalResponseTime = 0;
        
        for (Map.Entry<String, TestMetrics> entry : metricsMap.entrySet()) {
            TestMetrics metrics = entry.getValue();
            TransactionMetrics tm = new TransactionMetrics();
            tm.setTransactionName(entry.getKey());
            tm.setSampleCount(metrics.getSampleCount());
            tm.setErrorCount(metrics.getErrorCount());
            tm.setErrorPercentage(metrics.getErrorPercentage());
            tm.setAverageResponseTime(metrics.getAverageResponseTime());
            tm.setMinResponseTime(metrics.getMinResponseTime());
            tm.setMaxResponseTime(metrics.getMaxResponseTime());
            tm.setPercentile90(metrics.getPercentile90());
            tm.setPercentile95(metrics.getPercentile95());
            tm.setPercentile99(metrics.getPercentile99());
            tm.setThroughput(metrics.getThroughput());
            
            transactions.add(tm);
            
            totalSamples += metrics.getSampleCount();
            totalErrors += metrics.getErrorCount();
            totalResponseTime += metrics.getAverageResponseTime() * metrics.getSampleCount();
        }
        
        data.setTransactions(transactions);
        data.setTotalSamples(totalSamples);
        data.setTotalErrors(totalErrors);
        data.setOverallErrorPercentage(totalSamples > 0 ? (totalErrors * 100.0 / totalSamples) : 0);
        data.setAverageResponseTime(totalSamples > 0 ? (totalResponseTime / totalSamples) : 0);
        
        return data;
    }
}
