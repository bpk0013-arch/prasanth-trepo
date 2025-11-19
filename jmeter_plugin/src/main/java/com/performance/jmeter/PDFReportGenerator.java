package com.performance.jmeter;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

/**
 * Generates PDF performance test reports with sky blue theme and error highlighting
 */
public class PDFReportGenerator {
    
    // Sky blue color scheme
    private static final BaseColor SKY_BLUE = new BaseColor(135, 206, 235);  // #87CEEB
    private static final BaseColor LIGHT_SKY_BLUE = new BaseColor(176, 224, 230);  // #B0E0E6
    private static final BaseColor DARK_BLUE = new BaseColor(70, 130, 180);  // #4682B4
    private static final BaseColor ERROR_RED = new BaseColor(220, 20, 60);  // #DC143C
    private static final BaseColor WHITE = BaseColor.WHITE;
    private static final BaseColor DARK_TEXT = new BaseColor(44, 62, 80);  // #2C3E50
    
    private static final Font TITLE_FONT = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, DARK_BLUE);
    private static final Font HEADING_FONT = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, DARK_BLUE);
    private static final Font NORMAL_FONT = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, DARK_TEXT);
    private static final Font BOLD_FONT = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, DARK_TEXT);
    private static final Font WHITE_BOLD_FONT = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, WHITE);
    private static final Font ERROR_FONT = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, WHITE);
    
    public static void generateReport(TestReportData data, String outputPath) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(outputPath));
        
        document.open();
        
        // Title
        Paragraph title = new Paragraph("Performance Test Report", TITLE_FONT);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);
        
        // Test Information
        document.add(createInfoSection(data));
        document.add(Chunk.NEWLINE);
        
        // Executive Summary
        document.add(createSummarySection(data));
        document.add(Chunk.NEWLINE);
        
        // Detailed Results
        document.add(createDetailedResultsTable(data));
        
        document.close();
    }
    
    private static PdfPTable createInfoSection(TestReportData data) throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);
        table.setSpacingAfter(10);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        addInfoRow(table, "Project Name:", data.getProjectName());
        addInfoRow(table, "Test Environment:", data.getTestEnvironment());
        addInfoRow(table, "Tester Name:", data.getTesterName());
        addInfoRow(table, "Test Start Time:", sdf.format(data.getTestStartTime()));
        addInfoRow(table, "Test End Time:", sdf.format(data.getTestEndTime()));
        addInfoRow(table, "Test Duration:", formatDuration(data.getTestDuration()));
        
        return table;
    }
    
    private static void addInfoRow(PdfPTable table, String label, String value) {
        PdfPCell labelCell = new PdfPCell(new Phrase(label, WHITE_BOLD_FONT));
        labelCell.setBackgroundColor(SKY_BLUE);
        labelCell.setPadding(8);
        labelCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        labelCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        labelCell.setBorder(Rectangle.BOX);
        labelCell.setBorderColor(WHITE);
        table.addCell(labelCell);
        
        PdfPCell valueCell = new PdfPCell(new Phrase(value, NORMAL_FONT));
        valueCell.setBackgroundColor(LIGHT_SKY_BLUE);
        valueCell.setPadding(8);
        valueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        valueCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        valueCell.setBorder(Rectangle.BOX);
        valueCell.setBorderColor(WHITE);
        table.addCell(valueCell);
    }
    
    private static Element createSummarySection(TestReportData data) throws DocumentException {
        Paragraph heading = new Paragraph("Executive Summary", HEADING_FONT);
        heading.setSpacingBefore(10);
        heading.setSpacingAfter(10);
        
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{2f, 2.5f, 1.5f});
        
        // Header row
        addSummaryHeaderCell(table, "Metric");
        addSummaryHeaderCell(table, "Value");
        addSummaryHeaderCell(table, "Status");
        
        // Data rows with conditional error highlighting
        addSummaryDataRow(table, "Total Samples", String.valueOf(data.getTotalSamples()), "INFO", false);
        addSummaryDataRow(table, "Total Errors", String.valueOf(data.getTotalErrors()), 
                         data.getTotalErrors() > 0 ? "FAIL" : "PASS", data.getTotalErrors() > 0);
        addSummaryDataRow(table, "Error Rate", String.format("%.2f%%", data.getOverallErrorPercentage()), 
                         data.getOverallErrorPercentage() > 1.0 ? "FAIL" : "PASS", 
                         data.getOverallErrorPercentage() > 1.0);
        addSummaryDataRow(table, "Avg Response Time", String.format("%.2f ms", data.getAverageResponseTime()), 
                         data.getAverageResponseTime() > 1000 ? "WARN" : "PASS", false);
        
        Paragraph section = new Paragraph();
        section.add(heading);
        section.add(table);
        
        return section;
    }
    
    private static void addSummaryHeaderCell(PdfPTable table, String text) {
        PdfPCell cell = new PdfPCell(new Phrase(text, WHITE_BOLD_FONT));
        cell.setBackgroundColor(SKY_BLUE);
        cell.setPadding(8);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorder(Rectangle.BOX);
        cell.setBorderColor(BaseColor.GRAY);
        table.addCell(cell);
    }
    
    private static void addSummaryDataRow(PdfPTable table, String label, String value, String status, boolean isError) {
        // Label cell
        PdfPCell labelCell = new PdfPCell(new Phrase(label, isError ? ERROR_FONT : NORMAL_FONT));
        labelCell.setBackgroundColor(isError ? ERROR_RED : LIGHT_SKY_BLUE);
        labelCell.setPadding(6);
        labelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        labelCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        labelCell.setBorder(Rectangle.BOX);
        labelCell.setBorderColor(BaseColor.GRAY);
        table.addCell(labelCell);
        
        // Value cell
        PdfPCell valueCell = new PdfPCell(new Phrase(value, isError ? ERROR_FONT : NORMAL_FONT));
        valueCell.setBackgroundColor(isError ? ERROR_RED : WHITE);
        valueCell.setPadding(6);
        valueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        valueCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        valueCell.setBorder(Rectangle.BOX);
        valueCell.setBorderColor(BaseColor.GRAY);
        table.addCell(valueCell);
        
        // Status cell
        PdfPCell statusCell = new PdfPCell(new Phrase(status, isError ? ERROR_FONT : NORMAL_FONT));
        statusCell.setBackgroundColor(isError ? ERROR_RED : WHITE);
        statusCell.setPadding(6);
        statusCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        statusCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        statusCell.setBorder(Rectangle.BOX);
        statusCell.setBorderColor(BaseColor.GRAY);
        table.addCell(statusCell);
    }
    
    private static Element createDetailedResultsTable(TestReportData data) throws DocumentException {
        Paragraph heading = new Paragraph("Detailed Transaction Results", HEADING_FONT);
        heading.setSpacingBefore(10);
        heading.setSpacingAfter(10);
        
        PdfPTable table = new PdfPTable(10);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{3, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f});
        
        // Header with sky blue background
        String[] headers = {"Transaction", "Samples", "Errors", "Error%", "Avg(ms)", 
                           "Min(ms)", "Max(ms)", "90%(ms)", "95%(ms)", "99%(ms)"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, WHITE_BOLD_FONT));
            cell.setBackgroundColor(SKY_BLUE);
            cell.setPadding(6);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setBorder(Rectangle.BOX);
            cell.setBorderColor(BaseColor.GRAY);
            table.addCell(cell);
        }
        
        // Data rows with alternating colors and error highlighting ONLY on error cells
        int rowIndex = 0;
        for (TransactionMetrics tm : data.getTransactions()) {
            boolean hasErrors = tm.getErrorCount() > 0;
            BaseColor normalBgColor = (rowIndex % 2 == 0 ? WHITE : LIGHT_SKY_BLUE);
            
            // Transaction name - normal styling
            addStyledDataCell(table, tm.getTransactionName(), Element.ALIGN_LEFT, normalBgColor, NORMAL_FONT);
            
            // Samples - normal styling
            addStyledDataCell(table, String.valueOf(tm.getSampleCount()), Element.ALIGN_RIGHT, normalBgColor, NORMAL_FONT);
            
            // Errors - RED if has errors, normal otherwise
            BaseColor errorBgColor = hasErrors ? ERROR_RED : normalBgColor;
            Font errorFont = hasErrors ? ERROR_FONT : NORMAL_FONT;
            addStyledDataCell(table, String.valueOf(tm.getErrorCount()), Element.ALIGN_RIGHT, errorBgColor, errorFont);
            
            // Error% - RED if has errors, normal otherwise
            addStyledDataCell(table, String.format("%.2f", tm.getErrorPercentage()), Element.ALIGN_RIGHT, errorBgColor, errorFont);
            
            // All other columns - normal styling
            addStyledDataCell(table, String.format("%.2f", tm.getAverageResponseTime()), Element.ALIGN_RIGHT, normalBgColor, NORMAL_FONT);
            addStyledDataCell(table, String.valueOf(tm.getMinResponseTime()), Element.ALIGN_RIGHT, normalBgColor, NORMAL_FONT);
            addStyledDataCell(table, String.valueOf(tm.getMaxResponseTime()), Element.ALIGN_RIGHT, normalBgColor, NORMAL_FONT);
            addStyledDataCell(table, String.format("%.2f", tm.getPercentile90()), Element.ALIGN_RIGHT, normalBgColor, NORMAL_FONT);
            addStyledDataCell(table, String.format("%.2f", tm.getPercentile95()), Element.ALIGN_RIGHT, normalBgColor, NORMAL_FONT);
            addStyledDataCell(table, String.format("%.2f", tm.getPercentile99()), Element.ALIGN_RIGHT, normalBgColor, NORMAL_FONT);
            
            rowIndex++;
        }
        
        Paragraph section = new Paragraph();
        section.add(heading);
        section.add(table);
        
        return section;
    }
    
    private static void addStyledDataCell(PdfPTable table, String text, int alignment, BaseColor bgColor, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(bgColor);
        cell.setPadding(5);
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorder(Rectangle.BOX);
        cell.setBorderColor(BaseColor.GRAY);
        table.addCell(cell);
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
