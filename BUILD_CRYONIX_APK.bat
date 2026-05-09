@echo off
REM Build script for Cryonix Launcher Release APK
REM This script will compile the Android project and generate the release APK

echo.
echo ========================================
echo   Cryonix Launcher - Build Script
echo ========================================
echo.

REM Check if gradlew.bat exists
if not exist gradlew.bat (
    echo ERROR: gradlew.bat not found in current directory
    echo Please run this script from the project root directory
    pause
    exit /b 1
)

echo.
echo [1/3] Cleaning previous builds...
call gradlew.bat clean

if errorlevel 1 (
    echo ERROR: Failed to clean project
    pause
    exit /b 1
)

echo.
echo [2/3] Building native libraries and APK...
echo This may take 5-15 minutes depending on your system
echo.
call gradlew.bat assembleFullRelease

if errorlevel 1 (
    echo.
    echo ERROR: Build failed!
    echo Please check the error messages above
    pause
    exit /b 1
)

echo.
echo [3/3] Build completed successfully!
echo.

REM Find and display the APK location
if exist app_pojavlauncher\build\outputs\apk\fullRelease\app_pojavlauncher-full-release.apk (
    echo.
    echo ========================================
    echo   BUILD SUCCESSFUL
    echo ========================================
    echo.
    echo APK Location:
    echo   app_pojavlauncher\build\outputs\apk\fullRelease\app_pojavlauncher-full-release.apk
    echo.
) else (
    echo WARNING: Could not find APK file
    echo Please check the build output above for details
    echo.
)

echo.
pause
