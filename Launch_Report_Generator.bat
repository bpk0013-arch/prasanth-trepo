@echo off
REM JMeter Report Generator - Quick Launch
REM Double-click this file to start the GUI application

echo.
echo ========================================
echo   JMeter Report Generator
echo   by Prasanth Kumar Birupogu
echo ========================================
echo.
echo Starting GUI application...
echo.

python jmeter_report_generator_gui.py

if errorlevel 1 (
    echo.
    echo ERROR: Failed to start the application.
    echo.
    echo Please ensure Python is installed and in your PATH.
    echo.
    pause
)
