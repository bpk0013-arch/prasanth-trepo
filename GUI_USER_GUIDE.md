# JMeter Report Generator - GUI User Guide

## 🎯 Quick Start

### Launch the Application

**Option 1: Double-click the batch file**
```
Launch_Report_Generator.bat
```

**Option 2: Run from command line**
```bash
python jmeter_report_generator_gui.py
```

---

## 📋 User Interface Overview

The GUI application provides an easy-to-use interface for generating JMeter performance test reports.

### Main Sections

1. **Input File Selection**
   - Browse and select your JMeter JTL or CSV result file
   - Supported formats: .jtl, .csv

2. **Output Directory**
   - Choose where to save generated reports
   - Default: `test_reports` folder

3. **Report Details**
   - **Project Name**: Name of your project
   - **Environment**: Test environment (Dev, QA, Staging, Production)
   - **Tester Name**: Your name or team name

4. **Report Formats**
   - ☑️ Generate PDF Report
   - ☑️ Generate Excel Report
   - (You can select both)

5. **Action Buttons**
   - **Generate Reports**: Start report generation
   - **Clear Log**: Clear the log output
   - **Open Output Folder**: Open reports folder in file explorer
   - **Exit**: Close the application

6. **Log Output**
   - Real-time progress and status messages
   - Timestamped entries
   - Error messages (if any)

7. **Status Bar**
   - Current operation status at the bottom

---

## 🚀 Step-by-Step Usage

### Step 1: Select Input File
1. Click **Browse...** next to "Input JTL/CSV File"
2. Navigate to your JMeter results file
3. Select the file (e.g., `results.jtl` or `results.csv`)
4. Click **Open**

### Step 2: Choose Output Directory
1. Click **Browse...** next to "Output Directory"
2. Select or create a folder for reports
3. Click **Select Folder**

### Step 3: Enter Report Details
1. **Project Name**: Enter your project name
   - Example: "BIE Performance Test"
   
2. **Environment**: Select from dropdown or type
   - Options: Test Environment, Development, QA, Staging, Production
   
3. **Tester Name**: Enter your name
   - Example: "Prasanth Kumar Birupogu"

### Step 4: Select Report Formats
- Check **Generate PDF Report** for PDF output
- Check **Generate Excel Report** for Excel output
- You can select both formats

### Step 5: Generate Reports
1. Click **Generate Reports** button
2. Watch the log for progress
3. Wait for completion message
4. Reports will be saved with timestamp in filename

### Step 6: View Reports
1. Click **Open Output Folder** to view generated reports
2. Or navigate manually to the output directory
3. Files will be named: `Performance_Test_Report_YYYY-MM-DD_HHMMSS.pdf/xlsx`

---

## 📊 Report Contents

### PDF Report Includes:
- Test information (project, environment, tester, dates)
- Executive summary (samples, errors, response times)
- Detailed transaction results table
- Color-coded pass/fail status
- Response time percentiles (90th, 95th, 99th)

### Excel Report Includes:
- **Summary Sheet**: Test info and executive summary
- **Detailed Results Sheet**: Complete metrics per transaction
- Professional formatting with colors
- Easy to analyze and share

---

## 💡 Tips & Best Practices

### Input Files
- ✅ Use JMeter's standard JTL format
- ✅ Ensure file contains all required columns
- ✅ File should not be empty
- ✅ Test with sample data first

### Report Details
- 📝 Use descriptive project names
- 📝 Specify correct environment
- 📝 Include your full name for accountability

### Output Organization
- 📁 Create separate folders for different test runs
- 📁 Use descriptive folder names (e.g., "LoadTest_2025-11-19")
- 📁 Archive old reports regularly

### Performance
- ⚡ Large JTL files (>100MB) may take longer to process
- ⚡ Application remains responsive during generation
- ⚡ Check log for progress updates

---

## 🐛 Troubleshooting

### Problem: "Please select an input JTL/CSV file"
**Solution**: Click Browse and select a valid JTL or CSV file

### Problem: "Input file does not exist"
**Solution**: Ensure the file path is correct and file exists

### Problem: "Please select at least one report format"
**Solution**: Check either PDF or Excel checkbox (or both)

### Problem: Reports not generating
**Solutions**:
1. Check log output for error messages
2. Verify input file is valid JMeter format
3. Ensure output directory is writable
4. Check Python dependencies are installed

### Problem: "Error parsing JTL file"
**Solutions**:
1. Verify file is not corrupted
2. Check file format (should be CSV or XML)
3. Ensure file has proper headers
4. Try with sample data first

### Problem: Application won't start
**Solutions**:
1. Verify Python is installed: `python --version`
2. Install dependencies: `pip install -r requirements.txt`
3. Check for error messages in console
4. Try running from command line for detailed errors

---

## 📝 Example Workflow

### Scenario: Generate reports after load test

1. **Run JMeter Test**
   ```bash
   jmeter -n -t test_plan.jmx -l results.jtl
   ```

2. **Launch GUI**
   - Double-click `Launch_Report_Generator.bat`

3. **Configure**
   - Input File: `results.jtl`
   - Output: `reports/LoadTest_2025-11-19`
   - Project: "E-Commerce Load Test"
   - Environment: "Production"
   - Tester: "Prasanth Kumar"

4. **Generate**
   - Select both PDF and Excel
   - Click "Generate Reports"
   - Wait for completion

5. **Review**
   - Click "Open Output Folder"
   - Open PDF for executive summary
   - Open Excel for detailed analysis

6. **Share**
   - Email PDF to stakeholders
   - Share Excel with team for analysis

---

## ⌨️ Keyboard Shortcuts

- **Tab**: Navigate between fields
- **Enter**: Activate focused button
- **Escape**: Close dialogs
- **Ctrl+A**: Select all in text fields

---

## 🎨 Customization

### Default Values
Edit the GUI script to change defaults:

```python
self.project_name = tk.StringVar(value="Your Project Name")
self.environment = tk.StringVar(value="Your Environment")
self.tester_name = tk.StringVar(value="Your Name")
```

### Window Size
Adjust in the script:
```python
self.root.geometry("900x700")  # Width x Height
```

### Report Formats
Enable/disable by default:
```python
self.generate_pdf_var = tk.BooleanVar(value=True)
self.generate_excel_var = tk.BooleanVar(value=True)
```

---

## 📊 Sample Data

### Test with Sample Data

1. Use the provided sample file:
   ```
   test_data/sample_results.jtl
   ```

2. Expected output:
   - 25 samples
   - 5 transactions
   - 2 errors (8% error rate)

3. Generated reports will show:
   - Home Page, Login, Search, Add to Cart, Checkout
   - Response times and percentiles
   - Pass/Fail status

---

## 🔄 Batch Processing

### Generate Multiple Reports

1. Process first file
2. Click "Clear Log"
3. Select next file
4. Generate again
5. Repeat as needed

### Tip: Use different output folders for each test run

---

## 📞 Support

### Getting Help

1. **Check Log Output**: Look for error messages
2. **Review Documentation**: See README.md
3. **Sample Data**: Test with provided samples
4. **Command Line**: Try CLI version for debugging

### Common Issues

| Issue | Solution |
|-------|----------|
| Missing dependencies | `pip install -r requirements.txt` |
| File not found | Check file path and permissions |
| Parse errors | Verify JTL format is correct |
| No output | Check output directory permissions |

---

## 🎯 Advanced Features

### Command Line Equivalent

The GUI is equivalent to running:
```bash
python old-data-work/jmeter_report_generator.py \
  input_file.jtl \
  --project "Project Name" \
  --environment "Environment" \
  --tester "Tester Name" \
  --output-dir "output_directory"
```

### Integration with CI/CD

For automated pipelines, use the CLI version:
```bash
# In Jenkins/GitLab CI
jmeter -n -t test.jmx -l results.jtl
python jmeter_report_generator.py results.jtl
```

---

## 📈 Report Analysis Tips

### PDF Reports
- Share with management and stakeholders
- Include in test summary documents
- Archive for compliance

### Excel Reports
- Detailed analysis and trending
- Create charts and graphs
- Compare multiple test runs
- Filter and sort data

---

## ✅ Checklist

Before generating reports:
- [ ] JMeter test completed successfully
- [ ] JTL file exists and is not empty
- [ ] Output directory is writable
- [ ] Project details are correct
- [ ] Report formats selected

After generating reports:
- [ ] Check log for success message
- [ ] Verify reports exist in output folder
- [ ] Open and review PDF report
- [ ] Open and review Excel report
- [ ] Share with team/stakeholders

---

## 🎉 Success!

You're now ready to generate professional JMeter performance test reports with ease!

**Quick Launch**: Just double-click `Launch_Report_Generator.bat`

---

**Created by**: Prasanth Kumar Birupogu
**Version**: 1.0.0
**Date**: November 19, 2025
