@echo off
echo ========================================
echo   Building Standalone Executable
echo   JMeter Report Generator
echo ========================================
echo.

REM Change to script directory
cd /d "%~dp0"

echo Building executable...
echo This may take 2-5 minutes...
echo.

pyinstaller --onefile ^
    --windowed ^
    --name "JMeter_Report_Generator" ^
    --hidden-import=reportlab.pdfgen ^
    --hidden-import=reportlab.lib ^
    --hidden-import=reportlab.platypus ^
    --hidden-import=openpyxl ^
    --collect-all reportlab ^
    --collect-all openpyxl ^
    jmeter_report_generator_standalone.py

if errorlevel 1 (
    echo.
    echo ========================================
    echo   BUILD FAILED!
    echo ========================================
    echo.
    pause
    exit /b 1
)

echo.
echo ========================================
echo   BUILD SUCCESSFUL!
echo ========================================
echo.
echo Executable location: dist\JMeter_Report_Generator.exe
echo.
echo File size:
dir dist\JMeter_Report_Generator.exe | find "JMeter_Report_Generator.exe"
echo.
echo You can now copy this .exe file to any Windows machine!
echo No Python or dependencies needed!
echo.
pause
