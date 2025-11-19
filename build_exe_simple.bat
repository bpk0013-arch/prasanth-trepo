@echo off
echo Building JMeter Report Generator Executable...
echo.

REM Change to root directory
cd /d "%~dp0"

REM Build the executable
pyinstaller --onefile ^
    --windowed ^
    --name "JMeter_Report_Generator" ^
    --hidden-import=reportlab ^
    --hidden-import=reportlab.pdfgen ^
    --hidden-import=reportlab.lib ^
    --hidden-import=reportlab.platypus ^
    --hidden-import=openpyxl ^
    --hidden-import=pandas ^
    --collect-all reportlab ^
    --collect-all openpyxl ^
    jmeter_report_generator_gui.py

if errorlevel 1 (
    echo.
    echo BUILD FAILED!
    pause
    exit /b 1
)

echo.
echo ========================================
echo BUILD SUCCESSFUL!
echo ========================================
echo.
echo Executable location: dist\JMeter_Report_Generator.exe
echo.
echo You can now copy this file to any Windows machine!
echo.
pause
