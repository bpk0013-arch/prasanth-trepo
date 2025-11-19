@echo off
title Prasanth TRepo GUI v2 - JMeter Report Generator
echo ========================================
echo Prasanth TRepo GUI v2
echo JMeter Report Generator
echo ========================================
echo.
echo Starting application...
echo.

REM Check if executable exists
if exist "dist\Prasanth_TRepo_GUI_v2.exe" (
    echo Running from dist folder...
    start "" "dist\Prasanth_TRepo_GUI_v2.exe"
) else if exist "Prasanth_TRepo_GUI_v2.exe" (
    echo Running from current folder...
    start "" "Prasanth_TRepo_GUI_v2.exe"
) else (
    echo ERROR: Executable not found!
    echo.
    echo Please build the executable first by running:
    echo   build_exe_v2.bat
    echo.
    pause
    exit /b 1
)

echo.
echo Application launched!
echo You can close this window.
echo.
timeout /t 3 >nul
