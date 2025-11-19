@echo off
echo ========================================
echo Prasanth TRepo GUI v2 - EXE Builder
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

REM Check if required packages are installed
echo Checking dependencies...
python -c "import reportlab" 2>nul
if errorlevel 1 (
    echo Installing reportlab...
    pip install reportlab
)

python -c "import openpyxl" 2>nul
if errorlevel 1 (
    echo Installing openpyxl...
    pip install openpyxl
)

python -c "import PIL" 2>nul
if errorlevel 1 (
    echo Installing Pillow...
    pip install Pillow
)

echo.
echo ========================================
echo Building executable...
echo ========================================
echo.

REM Clean previous builds
if exist build rmdir /s /q build
if exist dist rmdir /s /q dist

REM Build the executable
pyinstaller --clean build_prasanth_trepo_v2.spec

if errorlevel 1 (
    echo.
    echo ========================================
    echo ERROR: Build failed!
    echo ========================================
    pause
    exit /b 1
)

echo.
echo ========================================
echo Build completed successfully!
echo ========================================
echo.
echo Executable location: dist\Prasanth_TRepo_GUI_v2.exe
echo.
echo You can now:
echo 1. Run the executable from: dist\Prasanth_TRepo_GUI_v2.exe
echo 2. Copy it to any location
echo 3. Share it with others (no Python needed!)
echo.
echo ========================================
echo New Features in v2:
echo ========================================
echo - Transaction column word wrap in PDF
echo - Company logo support
echo - Report Prepared By field
echo - Transactions Per Second chart
echo - Active Threads Over Time chart
echo - Error codes in error analysis
echo - Response times in seconds (not ms)
echo ========================================
echo.

pause
