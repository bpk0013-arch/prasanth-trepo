================================================================================
                    PRASANTH TREPO GUI v2.0
              JMeter Performance Test Report Generator
================================================================================

WHAT IS THIS?
-------------
A professional tool to generate beautiful PDF and Excel reports from JMeter 
test results. No technical knowledge required!

NEW IN VERSION 2.0:
-------------------
✓ Add your company logo to reports
✓ Response times shown in seconds (easier to read)
✓ Transaction names fully visible (word wrap)
✓ Transactions Per Second (TPS) chart
✓ Active Threads Over Time chart
✓ Error codes displayed (helps debugging)
✓ Separate "Tested By" and "Prepared By" fields

SYSTEM REQUIREMENTS:
--------------------
- Windows 10 or Windows 11
- 100 MB free disk space
- NO Python installation needed!
- NO additional software needed!

HOW TO USE:
-----------
1. Double-click: Prasanth_TRepo_GUI_v2.exe
2. Click "Browse..." next to "Input JTL/CSV File"
3. Select your JMeter results file (.jtl or .csv)
4. Fill in the project details:
   - Project Name
   - Environment (Test/QA/Production)
   - Tested By (your name)
   - Report Prepared By (optional)
5. (Optional) Add company logo:
   - Click "Browse..." next to "Company Logo"
   - Select your logo image (PNG or JPG)
6. Choose report formats:
   ☑ Generate PDF Report
   ☑ Generate Excel Report
7. Click "Generate Reports"
8. Wait for completion (check the log)
9. Click "Open Output Folder" to see your reports

OUTPUT:
-------
Reports are saved in: test_reports\
- Performance_Test_Report_YYYY-MM-DD_HHMMSS.pdf
- Performance_Test_Report_YYYY-MM-DD_HHMMSS.xlsx

REPORT FEATURES:
----------------
PDF Report includes:
- Professional cover page with logo
- Test information summary
- Executive summary with pass/fail status
- Response time analysis chart
- Transactions per second chart
- Active threads over time chart
- Detailed transaction results (all times in seconds)
- Performance analysis (best/worst performers)
- Error analysis with error codes
- Recommendations

Excel Report includes:
- Summary sheet with logo and key metrics
- Detailed results with color coding
- Charts and analysis sheet
- Error analysis with codes
- Professional formatting

TIPS:
-----
• Use PNG or JPG format for company logo
• Recommended logo size: 300x150 pixels
• All response times are shown in seconds (e.g., 1.234s)
• Red highlighting indicates errors
• Green charts show throughput (TPS)
• Blue charts show thread activity

TROUBLESHOOTING:
----------------
Problem: Application won't start
Solution: Right-click and "Run as Administrator"

Problem: Antivirus blocks the application
Solution: Add exception in your antivirus software
         (This is a false positive - the app is safe)

Problem: "File not found" error
Solution: Make sure your JTL file path has no special characters

Problem: Reports not generating
Solution: Check the log output for error messages
         Ensure you have write permissions to output folder

SAMPLE WORKFLOW:
----------------
1. Run your JMeter test
2. Save results as .jtl file
3. Open Prasanth TRepo GUI v2
4. Select the .jtl file
5. Add your company logo (optional but recommended)
6. Fill in project details
7. Generate reports
8. Share professional reports with stakeholders!

WHAT FILES DO I NEED?
----------------------
Just ONE file: Prasanth_TRepo_GUI_v2.exe

You can:
- Copy it to any folder
- Run it from USB drive
- Share it with colleagues
- No installation needed!

SUPPORT:
--------
For questions or issues, contact:
Prasanth Kumar Birupogu

VERSION INFORMATION:
--------------------
Version: 2.0
Release Date: November 2025
File Size: ~50-80 MB
Platform: Windows 10/11

FEATURES COMPARISON:
--------------------
                        v1.0    v2.0
Company Logo            ✗       ✓
Response Times (sec)    ✗       ✓
Word Wrap Names         ✗       ✓
TPS Chart               ✗       ✓
Threads Chart           ✗       ✓
Error Codes             ✗       ✓
Prepared By Field       ✗       ✓
PDF Reports             ✓       ✓
Excel Reports           ✓       ✓
Sky Blue Theme          ✓       ✓
Error Highlighting      ✓       ✓

QUICK START EXAMPLE:
--------------------
1. Launch: Prasanth_TRepo_GUI_v2.exe
2. Input File: C:\Tests\my_test_results.jtl
3. Project: "E-commerce Load Test"
4. Environment: "Production"
5. Tested By: "John Doe"
6. Prepared By: "Jane Smith"
7. Logo: C:\Company\logo.png
8. Click "Generate Reports"
9. Done! Check test_reports folder

KEYBOARD SHORTCUTS:
-------------------
Tab         - Move to next field
Shift+Tab   - Move to previous field
Enter       - (in text fields) Move to next field
Alt+F4      - Close application

FILE FORMATS SUPPORTED:
-----------------------
Input:
- .jtl (JMeter Test Log)
- .csv (Comma Separated Values)

Output:
- .pdf (Portable Document Format)
- .xlsx (Excel Workbook)

Logo:
- .png (Recommended)
- .jpg / .jpeg
- .gif
- .bmp

REPORT SECTIONS EXPLAINED:
--------------------------
1. Cover Page
   - Your company logo
   - Project information
   - Test details

2. Test Information
   - When test ran
   - How long it took
   - Total samples processed

3. Executive Summary
   - Pass/fail status
   - Key metrics at a glance
   - Error rate

4. Charts
   - Response times (bar chart)
   - TPS - Transactions per second (green bars)
   - Active threads over time (blue line)

5. Detailed Results
   - Every transaction analyzed
   - Times in seconds (easy to read)
   - Error highlighting (red = problem)

6. Error Analysis
   - Which transactions failed
   - Error codes (500, 404, etc.)
   - Helps identify issues

7. Recommendations
   - What to fix
   - What to optimize
   - Action items

UNDERSTANDING METRICS:
----------------------
Avg (s)     - Average response time in seconds
Min (s)     - Fastest response time
Max (s)     - Slowest response time
90% (s)     - 90% of requests were faster than this
TPS         - Transactions per second (throughput)
Error %     - Percentage of failed requests
Error Codes - HTTP response codes (500=server error, etc.)

BEST PRACTICES:
---------------
✓ Always add a company logo for professional reports
✓ Use descriptive project names
✓ Specify the correct environment
✓ Fill in both "Tested By" and "Prepared By"
✓ Generate both PDF and Excel for flexibility
✓ Review the log output for any warnings
✓ Keep your JTL files organized by date/project

COMMON ERROR CODES:
-------------------
200 - OK (Success)
400 - Bad Request
401 - Unauthorized
403 - Forbidden
404 - Not Found
500 - Internal Server Error
502 - Bad Gateway
503 - Service Unavailable
504 - Gateway Timeout

PERFORMANCE TIPS:
-----------------
• Large JTL files (>100MB) may take a few minutes
• Close other applications for faster processing
• Use SSD for better performance
• Don't interrupt the generation process

SECURITY & PRIVACY:
-------------------
• Application runs locally on your computer
• No data is sent to internet
• No telemetry or tracking
• Your test data stays private
• Safe to use with confidential data

LICENSE:
--------
This software is provided as-is for performance testing purposes.
All dependencies are properly licensed.

CREDITS:
--------
Developed by: Prasanth Kumar Birupogu
Libraries: ReportLab, OpenPyXL, Pillow
Built with: Python, PyInstaller

================================================================================
                    THANK YOU FOR USING PRASANTH TREPO!
                  Professional Reports Made Simple
================================================================================

Need help? Check the log output in the application for detailed messages.
Happy Testing! 🚀
