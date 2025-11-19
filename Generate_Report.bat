@echo off
REM JMeter Report Generator - Easy Launcher
REM Drag and drop your JTL file onto this batch file!

echo ================================================================================
echo  JMeter Report Generator - Standalone Version
echo ================================================================================
echo.

if "%~1"=="" (
    echo ERROR: No input file specified!
    echo.
    echo Usage: Drag and drop your JTL file onto this batch file
    echo    OR: Generate_Report.bat your_results.jtl
    echo.
    pause
    exit /b 1
)

echo Input file: %~1
echo.
echo Generating reports...
echo.

dist\JMeter_Report_Generator.exe "%~1" --project "Performance Test" --environment "Test" --tester "Tester"

echo.
echo ================================================================================
echo  Reports generated successfully!
echo  Check the 'test_reports' folder
echo ================================================================================
echo.
pause
