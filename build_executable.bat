@echo off
REM Build Standalone Executable for JMeter Report Generator
REM This creates a single .exe file that can run on any Windows machine

echo.
echo ========================================
echo   Building Standalone Executable
echo   JMeter Report Generator
echo ========================================
echo.

REM Check if PyInstaller is installed
python -c "import PyInstaller" 2>nul
if errorlevel 1 (
    echo PyInstaller not found. Installing...
    pip install pyinstaller
    if errorlevel 1 (
        echo ERROR: Failed to install PyInstaller
        pause
        exit /b 1
    )
)

echo.
echo Building executable...
echo This may take a few minutes...
echo.

REM Build the executable
pyinstaller --onefile ^
    --windowed ^
    --name "JMeter_Report_Generator" ^
    --icon=NONE ^
    --add-data "old-data-work/jmeter_report_generator.py;old-data-work" ^
    --hidden-import=reportlab ^
    --hidden-import=reportlab.pdfgen ^
    --hidden-import=reportlab.lib ^
    --hidden-import=reportlab.platypus ^
    --hidden-import=openpyxl ^
    --hidden-import=pandas ^
    --hidden-import=tkinter ^
    --collect-all reportlab ^
    --collect-all openpyxl ^
    jmeter_report_generator_gui.py

if errorlevel 1 (
    echo.
    echo ERROR: Build failed!
    echo.
    pause
    exit /b 1
)

echo.
echo ========================================
echo   BUILD SUCCESSFUL!
echo ========================================
echo.
echo Executable created: dist\JMeter_Report_Generator.exe
echo.
echo You can now copy this .exe file to any Windows machine
echo No Python or dependencies needed!
echo.
echo File size: 
dir dist\JMeter_Report_Generator.exe | find "JMeter_Report_Generator.exe"
echo.
pause
