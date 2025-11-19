# Prasanth TRepo - JMeter Report Generator

## 📦 Standalone Performance Test Report Generator

**Version:** 2.2  
**Author:** Prasanth Kumar Birupogu  
**Build Date:** November 19, 2025  
**Platform:** Windows 64-bit

---

## ✨ Features

- 🎨 **Sky Blue Professional Theme** - Modern, enterprise-ready reports
- 🔴 **Smart Error Highlighting** - Only error cells highlighted in red
- 📊 **Interactive Charts** - Bar charts in Excel
- 📐 **Perfect Alignment** - Transaction column properly sized with text wrapping
- 📊 **Multi-Sheet Excel** - Summary, Detailed Results, and Charts & Analysis
- 💼 **Portable** - Single .exe file, no installation needed
- ⚡ **No Dependencies** - Python and all libraries built-in

---

## 🚀 Quick Start

### Step 1: Copy the File
Copy `Prasanth_TRepo.exe` to any Windows machine.

### Step 2: Run It
```cmd
Prasanth_TRepo.exe your_results.jtl
```

### Step 3: Get Reports
Reports will be generated in the `test_reports` folder:
- PDF report with charts and sky blue theme
- Excel report with 3 sheets and interactive charts

---

## 💻 Usage Examples

### Basic Usage:
```cmd
Prasanth_TRepo.exe results.jtl
```

### With Custom Details:
```cmd
Prasanth_TRepo.exe results.jtl --project "My Project" --environment "Production" --tester "Your Name"
```

### Specify Output Directory:
```cmd
Prasanth_TRepo.exe results.jtl --output-dir "C:\Reports"
```

### Full Example:
```cmd
Prasanth_TRepo.exe C:\JMeter\results.jtl --project "BIE Performance Test" --environment "Production" --tester "Prasanth Kumar" --output-dir "C:\Reports\2025-11-19"
```

---

## 📋 Command Line Options

```
Prasanth_TRepo.exe [-h] [--project PROJECT] 
                   [--environment ENVIRONMENT] 
                   [--tester TESTER]
                   [--output-dir OUTPUT_DIR]
                   input_file

Required:
  input_file              Path to JMeter JTL/CSV results file

Optional:
  --project PROJECT       Project name (default: "Performance Test")
  --environment ENV       Test environment (default: "Test Environment")
  --tester TESTER        Tester name (default: "Performance Tester")
  --output-dir DIR       Output directory (default: "test_reports")
  -h, --help             Show help message
```

---

## 📊 Generated Reports

### PDF Report Includes:
- ✅ Cover page with project information
- ✅ Test information and executive summary
- ✅ Response time bar chart
- ✅ Detailed transaction results with:
  - Transaction column: Dark blue header, bold names
  - Error cells: Red background with white bold text
  - Alternating row colors for readability
- ✅ Performance analysis (best/worst performers)
- ✅ Error analysis (if errors exist)
- ✅ Automated recommendations

### Excel Report (3 Sheets):
1. **Summary**
   - Project information with sky blue theme
   - Executive summary with error highlighting

2. **Detailed Results**
   - Transaction column: Dark blue header, bold names, 40 chars wide
   - Error cells: Red background with white bold text
   - Text wrapping enabled (no overflow)
   - Alternating row colors
   - Perfect alignment

3. **Charts & Analysis**
   - Interactive bar chart (response times)
   - Error analysis table
   - Visual performance insights

---

## 🎨 Report Styling

### Transaction Column:
- **Header:** Dark blue background (more prominent)
- **Names:** Bold font, 40 characters wide
- **Wrapping:** Enabled (long names wrap properly)
- **No Overlap:** Text stays within column boundaries

### Error Highlighting:
- **Only error cells** highlighted (not entire row)
- **Columns:** Errors and Error % only
- **Style:** Red background + white bold text
- **Visibility:** Immediately obvious

### Color Scheme:
- **Sky Blue (#87CEEB):** Headers and key sections
- **Light Sky Blue (#B0E0E6):** Alternating rows
- **Dark Blue (#4682B4):** Transaction header, titles
- **Error Red (#DC143C):** Error cell highlighting
- **White (#FFFFFF):** Text on colored backgrounds

---

## 💾 System Requirements

### Minimum:
- **OS:** Windows 7 or later (64-bit)
- **RAM:** 512 MB
- **Disk:** 50 MB free space
- **No Python required!**
- **No dependencies required!**

### Recommended:
- **OS:** Windows 10/11
- **RAM:** 1 GB
- **Disk:** 100 MB free space

---

## 📁 File Structure

### When You Run It:
```
Your_Folder/
├── Prasanth_TRepo.exe             (The executable - 25 MB)
├── results.jtl                    (Your JMeter results)
└── test_reports/                  (Generated reports)
    ├── Performance_Test_Report_2025-11-19_162141.pdf
    └── Performance_Test_Report_2025-11-19_162141.xlsx
```

---

## 🔧 Troubleshooting

### Issue: "Windows protected your PC"
**Solution:**
1. Click "More info"
2. Click "Run anyway"
3. This is normal for unsigned executables

### Issue: "File not found"
**Solution:**
- Check the path to your JTL file
- Use quotes for paths with spaces:
  ```cmd
  Prasanth_TRepo.exe "C:\My Folder\results.jtl"
  ```

### Issue: "Permission denied"
**Solution:**
- Run as Administrator
- Or move to a folder where you have write permissions

### Issue: Slow startup
**Solution:**
- First run may be slow (extracting files)
- Subsequent runs will be faster
- This is normal for PyInstaller executables

### Issue: Transaction names overlap
**Solution:**
- This has been fixed in version 2.2
- Transaction column is now 40 characters wide
- Text wrapping is enabled
- If still seeing issues, update to latest version

---

## 📤 Sharing with Others

### Option 1: Direct Copy
1. Copy `Prasanth_TRepo.exe` to a USB drive
2. Give it to colleagues
3. They can run it immediately - no installation!

### Option 2: Network Share
1. Place on a shared network drive
2. Everyone can access it
3. No need to copy to each machine

### Option 3: Email/Cloud
1. Upload to OneDrive/Google Drive/Dropbox
2. Share the link
3. Download and run

---

## 🎯 Use Cases

### 1. Quick Reports on Any Machine
```cmd
# Just copy the .exe and run
Prasanth_TRepo.exe results.jtl
```

### 2. CI/CD Integration
```cmd
# Add to your build script
Prasanth_TRepo.exe %WORKSPACE%\results.jtl --output-dir %WORKSPACE%\reports
```

### 3. Batch Processing
```cmd
# Process multiple files
for %%f in (*.jtl) do (
    Prasanth_TRepo.exe "%%f" --project "Batch Test"
)
```

### 4. Scheduled Tasks
```cmd
# Windows Task Scheduler
Prasanth_TRepo.exe C:\JMeter\daily_results.jtl --output-dir C:\Reports\Daily
```

---

## 📊 What's New in Version 2.2

### Transaction Column Improvements:
- ✅ Dark blue header (more prominent than other columns)
- ✅ Bold transaction names in data rows
- ✅ Increased column width (40 characters in Excel, 2.2" in PDF)
- ✅ Text wrapping enabled (no overflow)
- ✅ Row height increased to 30px (accommodates wrapped text)
- ✅ No overlapping with other cells

### Error Highlighting:
- ✅ Only error cells highlighted (not entire row)
- ✅ Applied to Errors and Error % columns only
- ✅ Red background with white bold text
- ✅ Other columns maintain normal colors

### Overall:
- ✅ Sky blue professional theme
- ✅ Interactive charts in Excel
- ✅ Perfect alignment throughout
- ✅ Professional, enterprise-ready output

---

## 📝 Example Output

### Console Output:
```
================================================================================
📊 JMeter Enhanced Report Generator v2.0
================================================================================
Input file: results.jtl
Project: BIE Performance Test
Environment: Production
Tester: Prasanth Kumar Birupogu

📖 Parsing JMeter results...
✅ Parsed 1000 samples from 10 transactions

📄 Generating PDF report: test_reports\Performance_Test_Report_2025-11-19_162141.pdf
✅ PDF report generated successfully!

📊 Generating Excel report: test_reports\Performance_Test_Report_2025-11-19_162141.xlsx
✅ Excel report generated successfully!

🎉 Report generation complete!
📁 Reports saved to: test_reports
================================================================================

Features included:
  🎨 Sky blue professional theme
  🔴 Error highlighting (red background + white bold text)
  📊 Interactive charts in Excel
  📐 Perfect alignment and borders
  📊 Multi-sheet Excel workbook

Open the reports to see the enhanced features!
================================================================================
```

---

## 🔐 Security Notes

### What's Inside:
- Python 3.14 runtime (embedded)
- reportlab library (PDF generation)
- openpyxl library (Excel generation)
- Your report generation code
- All dependencies bundled

### Safe to Use:
- ✅ No network access required
- ✅ No data sent anywhere
- ✅ Processes files locally only
- ✅ No installation or registry changes
- ✅ Can be run from USB drive

---

## 📞 Support & Contact

**Author:** Prasanth Kumar Birupogu  
**Role:** Performance Test Engineer  
**Version:** 2.2  
**Build Date:** November 19, 2025

### For Issues or Questions:
- Check this README
- Review the generated reports
- Verify input file format (JTL/CSV)

---

## 🎉 Ready to Use!

### Quick Start:
1. Copy `Prasanth_TRepo.exe` to your machine
2. Run: `Prasanth_TRepo.exe your_results.jtl`
3. Open the generated reports in `test_reports` folder

**No installation, no dependencies, just works!** ✨

---

## 📦 File Information

**Filename:** Prasanth_TRepo.exe  
**Size:** ~25 MB  
**Platform:** Windows 64-bit  
**Python Version:** 3.14.0  
**Build Tool:** PyInstaller 6.16.0  
**Build Date:** November 19, 2025

---

## ✅ Features Checklist

- [x] Sky blue professional theme
- [x] Error highlighting (cells only)
- [x] Interactive charts in Excel
- [x] Transaction column properly sized
- [x] Text wrapping enabled
- [x] No overlapping cells
- [x] Perfect alignment
- [x] Multi-sheet Excel
- [x] Automated recommendations
- [x] No dependencies required
- [x] Portable executable

---

**Thank you for using Prasanth TRepo!** 🎉

**Generate professional performance test reports with ease!**
