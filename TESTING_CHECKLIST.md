# Testing Checklist for New Features

## Pre-Testing Setup

- [ ] Ensure Python 3.x is installed
- [ ] Install required packages: `pip install reportlab openpyxl`
- [ ] Have a sample JTL/CSV file ready
- [ ] Prepare a company logo image (PNG/JPG)

---

## Feature Testing Checklist

### 1. Transaction Column Word Wrap in PDF ✅

**Test Steps:**
1. [ ] Use a JTL file with long transaction names (e.g., "POST /api/v1/users/authenticate/login/with/oauth")
2. [ ] Generate PDF report
3. [ ] Open PDF and check detailed results table
4. [ ] Verify transaction names wrap to multiple lines
5. [ ] Verify no text is cut off
6. [ ] Check error analysis table also has word wrap

**Expected Result:**
- Long transaction names should wrap within the cell
- All text should be visible
- Table should remain properly formatted

---

### 2. Company Logo in Reports ✅

**Test Steps:**
1. [ ] Launch GUI: `python prasanth_trepo_gui_standalone.py`
2. [ ] Click "Browse..." next to "Company Logo (Optional)"
3. [ ] Select a PNG or JPG logo file
4. [ ] Generate both PDF and Excel reports
5. [ ] Open PDF - verify logo appears at top-left of cover page
6. [ ] Open Excel - verify logo appears at top-left of Summary sheet
7. [ ] Test with missing logo (leave field empty) - should work without errors

**Expected Result:**
- Logo should appear in both reports
- Logo should be properly sized (not too large/small)
- Reports should generate successfully even without logo

**Test Cases:**
- [ ] Valid PNG logo
- [ ] Valid JPG logo
- [ ] No logo (empty field)
- [ ] Invalid file path
- [ ] Non-image file

---

### 3. Report Prepared By Field ✅

**Test Steps:**
1. [ ] Launch GUI
2. [ ] Fill in "Tested By" field (e.g., "John Doe")
3. [ ] Fill in "Report Prepared By" field (e.g., "Jane Smith")
4. [ ] Generate reports
5. [ ] Open PDF - check cover page shows both names
6. [ ] Open Excel - check Summary sheet shows both names
7. [ ] Test with empty "Prepared By" - should default to tester name

**Expected Result:**
- Both names should appear in reports
- Labels should be clear: "Tested By:" and "Report Prepared By:"
- If prepared by is empty, should use tester name

**Test Cases:**
- [ ] Both fields filled
- [ ] Prepared by empty (should default)
- [ ] Same name in both fields
- [ ] Different names

---

### 4. Transactions Per Second (TPS) Chart ✅

**Test Steps:**
1. [ ] Generate PDF report
2. [ ] Locate "Transactions Per Second (TPS)" section
3. [ ] Verify green bar chart appears
4. [ ] Check chart shows top 10 transactions
5. [ ] Verify Y-axis shows TPS values
6. [ ] Open Excel - check Charts & Analysis sheet
7. [ ] Verify TPS data table exists

**Expected Result:**
- Green bar chart in PDF
- Shows throughput for each transaction
- Data table in Excel with TPS values
- Values should match transaction throughput

---

### 5. Active Threads Over Time Chart ✅

**Test Steps:**
1. [ ] Generate PDF report
2. [ ] Locate "Active Threads Over Time" section
3. [ ] Verify blue line chart appears
4. [ ] Check chart shows thread activity
5. [ ] Verify chart is readable (not too crowded)

**Expected Result:**
- Blue line chart in PDF
- Shows thread count over time
- Data is sampled intelligently (not overcrowded)
- Chart should reflect test load pattern

**Note:** This requires JTL file with thread count data (allThreads column)

---

### 6. Error Codes in Error Analysis ✅

**Test Steps:**
1. [ ] Use a JTL file with errors (failed transactions)
2. [ ] Ensure JTL has responseCode column
3. [ ] Generate reports
4. [ ] Open PDF - check Error Analysis section
5. [ ] Verify "Error Codes" column exists
6. [ ] Check format: "500(5), 404(2)" showing code and count
7. [ ] Open Excel - check Charts & Analysis sheet
8. [ ] Verify Error Codes column in error table

**Expected Result:**
- Error codes displayed in format: CODE(count)
- Multiple codes separated by commas
- Shows "N/A" if no error codes available
- Word wrapping enabled for long lists

**Test Cases:**
- [ ] Single error code (e.g., "500(10)")
- [ ] Multiple error codes (e.g., "500(5), 503(3), 404(2)")
- [ ] No error codes in JTL (should show "N/A")
- [ ] Test with no errors (section should not appear)

---

### 7. Response Times in Seconds ✅

**Test Steps:**
1. [ ] Generate reports with any JTL file
2. [ ] Open PDF - check Detailed Transaction Results table
3. [ ] Verify column headers: "Avg(s)", "Min(s)", "Max(s)", "90%(s)"
4. [ ] Verify values are in seconds (e.g., 1.234 not 1234)
5. [ ] Check Executive Summary shows seconds
6. [ ] Open Excel - check Detailed Results sheet
7. [ ] Verify all response times are in seconds
8. [ ] Verify format: X.XXX (3 decimal places)

**Expected Result:**
- All response times in seconds
- Format: X.XXX (e.g., 1.234)
- Column headers updated to show "(s)"
- Values should be milliseconds ÷ 1000

**Verification:**
- [ ] Average response time in seconds
- [ ] Minimum response time in seconds
- [ ] Maximum response time in seconds
- [ ] 90th percentile in seconds
- [ ] Executive summary shows seconds
- [ ] All tables consistent

---

## Integration Testing

### Complete Workflow Test

**Test Steps:**
1. [ ] Launch GUI
2. [ ] Select JTL file with:
   - Multiple transactions
   - Some errors
   - Error codes
   - Thread data
3. [ ] Fill all fields:
   - Project name
   - Environment
   - Tested by
   - Prepared by
   - Company logo
4. [ ] Select both PDF and Excel
5. [ ] Click "Generate Reports"
6. [ ] Wait for completion
7. [ ] Check log for success messages
8. [ ] Open output folder
9. [ ] Verify both files created
10. [ ] Open PDF and verify all features
11. [ ] Open Excel and verify all features

**Expected Result:**
- Both reports generated successfully
- All 7 new features visible
- No errors in log
- Reports are professional and complete

---

## Edge Cases Testing

### Test Case 1: Minimal JTL File
- [ ] JTL with only 1 transaction
- [ ] No errors
- [ ] Minimal columns
- **Expected:** Reports generate, charts may be simple

### Test Case 2: Large JTL File
- [ ] JTL with 100+ transactions
- [ ] Thousands of samples
- **Expected:** Reports generate, top 10 shown in charts

### Test Case 3: All Errors
- [ ] JTL where all transactions failed
- [ ] Multiple error codes
- **Expected:** Error analysis prominent, red highlighting

### Test Case 4: No Errors
- [ ] JTL with 100% success rate
- **Expected:** No error analysis section, green status

### Test Case 5: Special Characters
- [ ] Transaction names with special chars: `/`, `?`, `&`, `=`
- **Expected:** Names display correctly, word wrap works

### Test Case 6: Very Long Transaction Names
- [ ] Names over 100 characters
- **Expected:** Word wrap handles gracefully

---

## Performance Testing

- [ ] Test with small JTL (100 samples)
- [ ] Test with medium JTL (10,000 samples)
- [ ] Test with large JTL (100,000+ samples)
- [ ] Verify generation time is reasonable
- [ ] Check memory usage

---

## Compatibility Testing

### Operating Systems:
- [ ] Windows 10/11
- [ ] macOS
- [ ] Linux (Ubuntu/CentOS)

### Python Versions:
- [ ] Python 3.8
- [ ] Python 3.9
- [ ] Python 3.10
- [ ] Python 3.11
- [ ] Python 3.12+

### Image Formats:
- [ ] PNG logo
- [ ] JPG logo
- [ ] JPEG logo
- [ ] GIF logo (if supported)

---

## Regression Testing

### Verify Old Features Still Work:
- [ ] Basic report generation
- [ ] Sky blue theme
- [ ] Error highlighting (red cells)
- [ ] Charts and graphs
- [ ] Excel formatting
- [ ] PDF formatting
- [ ] Multiple transactions
- [ ] Percentile calculations
- [ ] Throughput calculations

---

## User Acceptance Testing

### Usability:
- [ ] GUI is intuitive
- [ ] All fields have clear labels
- [ ] Browse buttons work correctly
- [ ] Log messages are helpful
- [ ] Error messages are clear
- [ ] Success messages are clear

### Report Quality:
- [ ] PDF is professional looking
- [ ] Excel is well formatted
- [ ] Colors are appropriate
- [ ] Text is readable
- [ ] Charts are clear
- [ ] Tables are aligned
- [ ] Logo looks good

---

## Command Line Testing

**Test Steps:**
1. [ ] Test basic command:
   ```bash
   python jmeter_report_generator_enhanced.py test.jtl
   ```

2. [ ] Test with all parameters:
   ```bash
   python jmeter_report_generator_enhanced.py test.jtl \
       --project "Test Project" \
       --environment "Production" \
       --tester "John Doe" \
       --prepared-by "Jane Smith" \
       --logo "logo.png" \
       --output-dir "reports"
   ```

3. [ ] Test with missing optional parameters
4. [ ] Test with invalid logo path
5. [ ] Test with non-existent JTL file

**Expected Result:**
- All commands work correctly
- Optional parameters are truly optional
- Error messages are helpful
- Reports generate successfully

---

## Documentation Testing

- [ ] README is accurate
- [ ] Quick guide is helpful
- [ ] Examples are correct
- [ ] Screenshots match current version
- [ ] Installation instructions work

---

## Final Checklist

Before marking as complete:
- [ ] All 7 features implemented
- [ ] All features tested
- [ ] No syntax errors
- [ ] No runtime errors
- [ ] Documentation updated
- [ ] Examples provided
- [ ] Edge cases handled
- [ ] Backward compatible
- [ ] Performance acceptable
- [ ] User feedback positive

---

## Bug Report Template

If issues found:

```
**Feature:** [Which feature]
**Issue:** [Description]
**Steps to Reproduce:**
1. 
2. 
3. 

**Expected:** [What should happen]
**Actual:** [What actually happened]
**JTL File:** [Characteristics of test file]
**Environment:** [OS, Python version]
**Screenshots:** [If applicable]
```

---

## Sign-Off

- [ ] Developer tested: _________________ Date: _______
- [ ] QA tested: _________________ Date: _______
- [ ] User tested: _________________ Date: _______
- [ ] Ready for production: ☐ Yes ☐ No

---

**All features are ready for testing!** 🚀

Start with the Complete Workflow Test, then test individual features.
