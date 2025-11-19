package com.performance.jmeter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

/**
 * Generates Excel performance test reports with sky blue theme and error highlighting
 */
public class ExcelReportGenerator {
    
    // Sky blue color scheme (RGB values)
    private static final byte[] SKY_BLUE = new byte[]{(byte)135, (byte)206, (byte)235};  // #87CEEB
    private static final byte[] LIGHT_SKY_BLUE = new byte[]{(byte)176, (byte)224, (byte)230};  // #B0E0E6
    private static final byte[] DARK_BLUE = new byte[]{(byte)70, (byte)130, (byte)180};  // #4682B4
    private static final byte[] ERROR_RED = new byte[]{(byte)220, (byte)20, (byte)60};  // #DC143C
    
    public static void generateReport(TestReportData data, String outputPath) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        
        // Create sheets
        createSummarySheet(workbook, data);
        createDetailedResultsSheet(workbook, data);
        createTransactionAnalysisSheet(workbook, data);
        
        // Write to file
        try (FileOutputStream fileOut = new FileOutputStream(outputPath)) {
            workbook.write(fileOut);
        }
        
        workbook.close();
    }
    
    private static void createSummarySheet(Workbook workbook, TestReportData data) {
        Sheet sheet = workbook.createSheet("Summary");
        
        CellStyle skyBlueHeaderStyle = createSkyBlueHeaderStyle(workbook);
        CellStyle lightBlueStyle = createLightBlueStyle(workbook);
        CellStyle errorStyle = createErrorStyle(workbook);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        int rowNum = 0;
        
        // Title with sky blue background
        Row titleRow = sheet.createRow(rowNum++);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Performance Test Report");
        CellStyle titleStyle = createTitleStyle(workbook);
        titleCell.setCellStyle(titleStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        titleRow.setHeightInPoints(30);
        
        rowNum++; // Empty row
        
        // Project Information Section Header
        Row infoHeaderRow = sheet.createRow(rowNum++);
        Cell infoHeaderCell = infoHeaderRow.createCell(0);
        infoHeaderCell.setCellValue("Project Information");
        infoHeaderCell.setCellStyle(createTitleStyle(workbook));
        sheet.addMergedRegion(new CellRangeAddress(rowNum-1, rowNum-1, 0, 5));
        
        // Test Information with sky blue theme
        addStyledRow(sheet, rowNum++, "Project Name:", data.getProjectName(), skyBlueHeaderStyle, lightBlueStyle);
        addStyledRow(sheet, rowNum++, "Test Environment:", data.getTestEnvironment(), skyBlueHeaderStyle, lightBlueStyle);
        addStyledRow(sheet, rowNum++, "Tester Name:", data.getTesterName(), skyBlueHeaderStyle, lightBlueStyle);
        addStyledRow(sheet, rowNum++, "Test Start Time:", sdf.format(data.getTestStartTime()), skyBlueHeaderStyle, lightBlueStyle);
        addStyledRow(sheet, rowNum++, "Test End Time:", sdf.format(data.getTestEndTime()), skyBlueHeaderStyle, lightBlueStyle);
        addStyledRow(sheet, rowNum++, "Test Duration:", formatDuration(data.getTestDuration()), skyBlueHeaderStyle, lightBlueStyle);
        
        rowNum++; // Empty row
        
        // Executive Summary Section Header
        Row summaryHeaderRow = sheet.createRow(rowNum++);
        Cell summaryHeaderCell = summaryHeaderRow.createCell(0);
        summaryHeaderCell.setCellValue("Executive Summary");
        summaryHeaderCell.setCellStyle(createTitleStyle(workbook));
        sheet.addMergedRegion(new CellRangeAddress(rowNum-1, rowNum-1, 0, 5));
        
        // Summary Statistics with error highlighting
        boolean hasErrors = data.getTotalErrors() > 0;
        addStyledRow(sheet, rowNum++, "Total Samples:", String.valueOf(data.getTotalSamples()), 
                    skyBlueHeaderStyle, lightBlueStyle);
        addStyledRow(sheet, rowNum++, "Total Errors:", String.valueOf(data.getTotalErrors()), 
                    skyBlueHeaderStyle, hasErrors ? errorStyle : lightBlueStyle);
        
        boolean highErrorRate = data.getOverallErrorPercentage() > 1.0;
        addStyledRow(sheet, rowNum++, "Error Rate:", String.format("%.2f%%", data.getOverallErrorPercentage()), 
                    skyBlueHeaderStyle, highErrorRate ? errorStyle : lightBlueStyle);
        
        addStyledRow(sheet, rowNum++, "Average Response Time:", String.format("%.2f ms", data.getAverageResponseTime()), 
                    skyBlueHeaderStyle, lightBlueStyle);
        
        // Test Status
        String status = data.getOverallErrorPercentage() < 1.0 ? "PASSED" : "FAILED";
        Row statusRow = sheet.createRow(rowNum++);
        Cell statusLabelCell = statusRow.createCell(0);
        statusLabelCell.setCellValue("Test Status:");
        statusLabelCell.setCellStyle(skyBlueHeaderStyle);
        
        Cell statusValueCell = statusRow.createCell(1);
        statusValueCell.setCellValue(status);
        statusValueCell.setCellStyle(status.equals("PASSED") ? lightBlueStyle : errorStyle);
        
        // Set column widths for perfect alignment
        sheet.setColumnWidth(0, 25 * 256);
        sheet.setColumnWidth(1, 30 * 256);
    }
    
    private static void addStyledRow(Sheet sheet, int rowNum, String label, String value, 
                                    CellStyle labelStyle, CellStyle valueStyle) {
        Row row = sheet.createRow(rowNum);
        
        Cell labelCell = row.createCell(0);
        labelCell.setCellValue(label);
        labelCell.setCellStyle(labelStyle);
        
        Cell valueCell = row.createCell(1);
        valueCell.setCellValue(value);
        valueCell.setCellStyle(valueStyle);
    }
    
    private static void createDetailedResultsSheet(Workbook workbook, TestReportData data) {
        Sheet sheet = workbook.createSheet("Detailed Results");
        
        CellStyle skyBlueHeaderStyle = createSkyBlueHeaderStyle(workbook);
        CellStyle normalStyle = createNormalStyle(workbook);
        CellStyle lightBlueStyle = createLightBlueStyle(workbook);
        CellStyle errorStyle = createErrorStyle(workbook);
        
        int rowNum = 0;
        
        // Title row
        Row titleRow = sheet.createRow(rowNum++);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Detailed Transaction Results");
        CellStyle titleStyle = createTitleStyle(workbook);
        titleCell.setCellStyle(titleStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 10));
        titleRow.setHeightInPoints(25);
        
        // Header row
        Row headerRow = sheet.createRow(rowNum++);
        String[] headers = {"Transaction Name", "Samples", "Errors", "Error %", "Avg Response Time (ms)",
                           "Min (ms)", "Max (ms)", "90th Percentile (ms)", "95th Percentile (ms)", 
                           "99th Percentile (ms)", "Throughput (req/sec)"};
        
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(skyBlueHeaderStyle);
        }
        
        // Data rows with alternating colors and error highlighting ONLY on error cells
        int dataRowIndex = 0;
        for (TransactionMetrics tm : data.getTransactions()) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            
            boolean hasErrors = tm.getErrorCount() > 0;
            CellStyle normalRowStyle = (dataRowIndex % 2 == 0 ? lightBlueStyle : normalStyle);
            
            // Transaction name - normal styling
            createStyledCell(row, colNum++, tm.getTransactionName(), normalRowStyle);
            
            // Samples - normal styling
            createStyledCell(row, colNum++, tm.getSampleCount(), normalRowStyle);
            
            // Errors - RED if has errors, normal otherwise
            CellStyle errorCellStyle = hasErrors ? errorStyle : normalRowStyle;
            createStyledCell(row, colNum++, tm.getErrorCount(), errorCellStyle);
            
            // Error% - RED if has errors, normal otherwise
            createStyledCell(row, colNum++, String.format("%.2f", tm.getErrorPercentage()), errorCellStyle);
            
            // All other columns - normal styling
            createStyledCell(row, colNum++, String.format("%.2f", tm.getAverageResponseTime()), normalRowStyle);
            createStyledCell(row, colNum++, tm.getMinResponseTime(), normalRowStyle);
            createStyledCell(row, colNum++, tm.getMaxResponseTime(), normalRowStyle);
            createStyledCell(row, colNum++, String.format("%.2f", tm.getPercentile90()), normalRowStyle);
            createStyledCell(row, colNum++, String.format("%.2f", tm.getPercentile95()), normalRowStyle);
            createStyledCell(row, colNum++, String.format("%.2f", tm.getPercentile99()), normalRowStyle);
            createStyledCell(row, colNum++, String.format("%.2f", tm.getThroughput()), normalRowStyle);
            
            dataRowIndex++;
        }
        
        // Set column widths for perfect alignment
        sheet.setColumnWidth(0, 35 * 256);  // Transaction name
        for (int i = 1; i < headers.length; i++) {
            sheet.setColumnWidth(i, 15 * 256);
        }
    }
    
    private static void createTransactionAnalysisSheet(Workbook workbook, TestReportData data) {
        Sheet sheet = workbook.createSheet("Transaction Analysis");
        
        CellStyle headerStyle = createHeaderStyle(workbook);
        CellStyle normalStyle = createNormalStyle(workbook);
        
        int rowNum = 0;
        
        // Header
        Row headerRow = sheet.createRow(rowNum++);
        String[] headers = {"Transaction Name", "Success Rate %", "Avg Response Time (ms)", "Throughput (req/sec)", "Status"};
        
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
        
        // Data rows with analysis
        for (TransactionMetrics tm : data.getTransactions()) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            
            double successRate = 100.0 - tm.getErrorPercentage();
            String status = tm.getErrorPercentage() < 1.0 ? "PASS" : "FAIL";
            
            createCell(row, colNum++, tm.getTransactionName(), normalStyle);
            createCell(row, colNum++, String.format("%.2f", successRate), normalStyle);
            createCell(row, colNum++, String.format("%.2f", tm.getAverageResponseTime()), normalStyle);
            createCell(row, colNum++, String.format("%.2f", tm.getThroughput()), normalStyle);
            
            Cell statusCell = row.createCell(colNum++);
            statusCell.setCellValue(status);
            CellStyle statusStyle = workbook.createCellStyle();
            Font statusFont = workbook.createFont();
            statusFont.setBold(true);
            statusFont.setColor(status.equals("PASS") ? IndexedColors.GREEN.getIndex() : IndexedColors.RED.getIndex());
            statusStyle.setFont(statusFont);
            statusCell.setCellStyle(statusStyle);
        }
        
        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }
    
    private static void addRow(Sheet sheet, int rowNum, String label, String value, 
                               CellStyle labelStyle, CellStyle valueStyle) {
        Row row = sheet.createRow(rowNum);
        
        Cell labelCell = row.createCell(0);
        labelCell.setCellValue(label);
        labelCell.setCellStyle(labelStyle);
        
        Cell valueCell = row.createCell(1);
        valueCell.setCellValue(value);
        valueCell.setCellStyle(valueStyle);
    }
    
    private static void createCell(Row row, int column, String value, CellStyle style) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }
    
    private static void createCell(Row row, int column, long value, CellStyle style) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }
    
    private static CellStyle createTitleStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        
        XSSFCellStyle xssfStyle = (XSSFCellStyle) style;
        XSSFColor darkBlue = new XSSFColor(DARK_BLUE, null);
        xssfStyle.setFillForegroundColor(darkBlue);
        xssfStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }
    
    private static CellStyle createSkyBlueHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 10);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        
        XSSFCellStyle xssfStyle = (XSSFCellStyle) style;
        XSSFColor skyBlue = new XSSFColor(SKY_BLUE, null);
        xssfStyle.setFillForegroundColor(skyBlue);
        xssfStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }
    
    private static CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 11);
        style.setFont(font);
        
        XSSFCellStyle xssfStyle = (XSSFCellStyle) style;
        XSSFColor skyBlue = new XSSFColor(SKY_BLUE, null);
        xssfStyle.setFillForegroundColor(skyBlue);
        xssfStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }
    
    private static CellStyle createNormalStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }
    
    private static CellStyle createLightBlueStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        
        XSSFCellStyle xssfStyle = (XSSFCellStyle) style;
        XSSFColor lightBlue = new XSSFColor(LIGHT_SKY_BLUE, null);
        xssfStyle.setFillForegroundColor(lightBlue);
        xssfStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }
    
    private static CellStyle createErrorStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        
        XSSFCellStyle xssfStyle = (XSSFCellStyle) style;
        XSSFColor errorRed = new XSSFColor(ERROR_RED, null);
        xssfStyle.setFillForegroundColor(errorRed);
        xssfStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }
    
    private static void createStyledCell(Row row, int column, String value, CellStyle style) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }
    
    private static void createStyledCell(Row row, int column, long value, CellStyle style) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }
    
    private static String formatDuration(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        
        seconds = seconds % 60;
        minutes = minutes % 60;
        
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
