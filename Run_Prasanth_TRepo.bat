@echo off
REM Prasanth TRepo - JMeter Report Generator
REM Easy Launcher - Drag and drop your JTL file onto this batch file!

echo ================================================================================
echo  Prasanth TRepo - JMeter Report Generator v2.2
echo  By Prasanth Kumar Birupogu
echo ================================================================================
echo.

if "%~1"=="" (
    echo ERROR: No input file specified!
    echo.
    echo Usage: Drag and drop your JTL file onto this batch file
    echo    OR: Run_Prasanth_TRepo.bat your_results.jtl
    echo.
    pause
    exit /b 1
)

echo Input file: %~1
echo.
echo Generating reports...
echo.

dist\Prasanth_TRepo.exe "%~1" --project "Performance Test" --environment "Test" --tester "Prasanth Kumar"

echo.
echo ================================================================================
echo  Reports generated successfully!
echo  Check the 'test_reports' folder
echo ================================================================================
echo.
pause
