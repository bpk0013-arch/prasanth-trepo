# Prasanth TRepo GUI - User Guide

## 🖥️ Standalone GUI Application

**Version:** 2.2  
**Author:** Prasanth Kumar Birupogu  
**Platform:** Windows 64-bit  
**No Dependencies Required!**

---

## 🚀 Quick Start

### Step 1: Launch the Application
Double-click `Prasanth_TRepo_GUI.exe`

### Step 2: Select Input File
1. Click the **"Browse..."** button next to "Input JTL/CSV File"
2. Navigate to your JMeter results file (.jtl or .csv)
3. Select the file and click "Open"

### Step 3: Configure Report Details (Optional)
- **Project Name:** Enter your project name
- **Environment:** Select from dropdown (Test, QA, Staging, Production)
- **Tester Name:** Enter your name
- **Output Directory:** Choose where to save reports (default: test_reports)

### Step 4: Select Report Formats
- ✅ **Generate PDF Report** - Professional PDF with charts
- ✅ **Generate Excel Report** - Multi-sheet Excel with interactive charts

### Step 5: Generate Reports
Click the **"Generate Reports"** button

### Step 6: View Reports
- Watch the log output for progress
- When complete, click **"Open Output Folder"** to view reports
- Or navigate to the test_reports folder manually

---

## 🖼️ GUI Layout

```
┌─────────────────────────────────────────────────────────────────┐
│  Prasanth TRepo - JMeter Report Generator                      │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  Input JTL/CSV File:  [________________________] [Browse...]    │
│                                                                 │
│  Output Directory:    [________________________] [Browse...]    │
│                                                                 │
│  ─────────────────────────────────────────────────────────────  │
│                                                                 │
│  Report Details                                                 │
│                                                                 │
│  Project Name:        [________________________]                │
│                                                                 │
│  Environment:         [Test Environment ▼]                      │
│                                                                 │
│  Tester Name:         [________________________]                │
│                                                                 │
│  Report Formats:      ☑ Generate PDF Report                    │
│                       ☑ Generate Excel Report                  │
│                                                                 │
│  ─────────────────────────────────────────────────────────────  │
│                                                                 │
│  [Generate Reports] [Clear Log] [Open Output Folder] [Exit]    │
│                                                                 │
│  ─────────────────────────────────────────────────────────────  │
│                                                                 │
│  Log Output:                                                    │
│  ┌───────────────────────────────────────────────────────────┐ │
│  │ [15:08:28] Welcome to Prasanth TRepo!                     │ │
│  │ [15:08:30] Selected input file: results.jtl               │ │
│  │ [15:08:35] Generating reports...                          │ │
│  │ [15:08:40] ✅ PDF report generated successfully!          │ │
│  │ [15:08:42] ✅ Excel report generated successfully!        │ │
│  │ [15:08:42] 🎉 Report generation complete!                 │ │
│  └───────────────────────────────────────────────────────────┘ │
│                                                                 │
│  Status: Reports generated successfully!                        │
└─────────────────────────────────────────────────────────────────┘
```

---

## 🎯 Features

### User-Friendly Interface:
- ✅ **Browse buttons** for easy file selection
- ✅ **Dropdown menus** for environment selection
- ✅ **Checkboxes** for report format selection
- ✅ **Real-time log** showing progress
- ✅ **Status bar** showing current state
- ✅ **One-click** report generation

### Report Features:
- ✅ **Sky blue professional theme**
- ✅ **Error highlighting** (only error cells)
- ✅ **Interactive charts** in Excel
- ✅ **Transaction column** - Dark blue header, bold names
- ✅ **Perfect alignment** - No overlapping
- ✅ **Multi-sheet Excel** - 3 comprehensive sheets

---

## 📋 Button Functions

### Generate Reports
- Validates all inputs
- Parses JMeter results
- Generates PDF and/or Excel reports
- Shows progress in log
- Displays success message when complete

### Clear Log
- Clears the log output window
- Useful for starting fresh

### Open Output Folder
- Opens the output directory in Windows Explorer
- Quick access to generated reports

### Exit
- Closes the application
- Safe to use anytime

---

## 💡 Tips & Tricks

### Tip 1: Drag & Drop (Future Enhancement)
Currently, use the Browse button. Drag & drop can be added in future versions.

### Tip 2: Default Values
The application remembers your last used values:
- Project Name
- Environment
- Tester Name
- Output Directory

### Tip 3: Batch Processing
To process multiple files:
1. Generate reports for first file
2. Click "Browse" to select next file
3. Click "Generate Reports" again
4. Repeat as needed

### Tip 4: Custom Output Location
Change the output directory to organize reports by:
- Date: `C:\Reports\2025-11-19`
- Project: `C:\Reports\ProjectA`
- Environment: `C:\Reports\Production`

---

## 🔧 Troubleshooting

### Issue: "Please select an input JTL/CSV file"
**Solution:** Click the Browse button next to "Input JTL/CSV File" and select your file.

### Issue: "Input file does not exist"
**Solution:** The file path is incorrect. Browse again and select the correct file.

### Issue: "Please select at least one report format"
**Solution:** Check at least one checkbox (PDF or Excel or both).

### Issue: GUI doesn't open
**Solution:**
- Check if Windows Defender blocked it
- Right-click → Properties → Unblock
- Run as Administrator

### Issue: Reports not generating
**Solution:**
- Check the log output for error messages
- Verify the JTL file is valid
- Ensure you have write permissions to output directory

---

## 📊 Generated Reports

### PDF Report:
- Cover page with project information
- Test information and executive summary
- Response time bar chart
- Detailed transaction results
  - Transaction column: Dark blue header, bold names
  - Error cells: Red background with white bold text
- Performance analysis
- Error analysis (if errors exist)
- Automated recommendations

### Excel Report (3 Sheets):
1. **Summary**
   - Project information
   - Executive summary
   - Sky blue theme

2. **Detailed Results**
   - Transaction column: Dark blue header, bold names, 40 chars wide
   - Error cells: Red background with white bold text
   - Alternating row colors
   - Perfect alignment

3. **Charts & Analysis**
   - Interactive bar chart (response times)
   - Error analysis table
   - Visual insights

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

```
Your_Folder/
├── Prasanth_TRepo_GUI.exe         (The application)
├── results.jtl                    (Your JMeter results)
└── test_reports/                  (Generated reports)
    ├── Performance_Test_Report_2025-11-19_154453.pdf
    └── Performance_Test_Report_2025-11-19_154453.xlsx
```

---

## 🎨 Report Styling

### Sky Blue Theme:
- Professional color scheme
- Sky blue headers with white text
- Light blue alternating rows
- Dark blue for Transaction column header

### Error Highlighting:
- Only error cells highlighted (not entire row)
- Red background (#DC143C)
- White bold text
- Applied to Errors and Error % columns only

### Transaction Column:
- Dark blue header (more prominent)
- Bold transaction names
- 40 characters wide
- Text wrapping enabled
- No overlapping

---

## 📞 Support

### For Issues:
1. Check the log output in the GUI
2. Review this user guide
3. Verify your JTL file format
4. Contact: Prasanth Kumar Birupogu

### Common Solutions:
- **File not found:** Use Browse button to select file
- **Permission denied:** Run as Administrator
- **Slow performance:** First run may be slow (extracting files)

---

## 🎉 Enjoy!

**Prasanth TRepo GUI makes report generation easy!**

- No command line needed
- No Python installation needed
- No dependencies needed
- Just click and generate!

**Happy Testing!** ✨

---

**Version:** 2.2  
**Build Date:** November 19, 2025  
**Author:** Prasanth Kumar Birupogu  
**Role:** Performance Test Engineer
