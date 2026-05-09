# Cryonix Launcher - Build Instructions

## What Changed
- ✅ **Package Name:** Changed from `git.artdeell.mojo` to `git.artdeell.cryonix`
- ✅ **App Name:** Changed from "MojoLauncher" to "Cryonix Launcher"
- ✅ **App Short Name:** Changed from "MojoLauncher" to "Cryonix"
- ✅ **Native Build:** Enabled NDK compilation on Windows (fixes the `libexithook.so` error)

## Previous Error - FIXED
The error you were seeing:
```
java.lang.NoClassDefFoundError: net.kdt.pojavlaunch.utils.JREUtils
Caused by: java.lang.UnsatisfiedLinkError: dlopen failed: library "libexithook.so" not found
```

This occurred because:
1. The project was configured to skip NDK builds on Windows
2. The native libraries (libexithook.so, libpojavexec.so, libpojavexec_awt.so) were not being compiled
3. The build was producing an APK without these critical libraries

**Solution:** Enabled NDK builds on Windows by modifying `app_pojavlauncher/build.gradle`

## Build Requirements

Before building, ensure you have:
1. **Java Development Kit (JDK) 11+** installed
   - Check: Run `java -version` in Command Prompt
   - Download: https://www.oracle.com/java/technologies/javase-downloads.html

2. **Android SDK** installed (via Android Studio)
   - Expected location: `C:\Users\<Username>\AppData\Local\Android\Sdk`
   - Already configured in `local.properties`

3. **Android NDK** installed
   - Required for compiling native libraries
   - Can be installed via Android Studio
   - Or manually: https://developer.android.com/ndk/downloads

## Quick Build

**Option 1: Use the Build Script (Recommended)**
```batch
REM Open Command Prompt in the project directory and run:
BUILD_CRYONIX_APK.bat
```

**Option 2: Manual Build**
```batch
REM Open Command Prompt and navigate to:
cd "c:\Users\Gopal Sharma\Downloads\MojoLauncher-3_openjdk (2)\CryonixLauncher-3_openjdk"

REM Clean previous builds
gradlew.bat clean

REM Build the release APK
gradlew.bat assembleFullRelease
```

## Build Output Location

The final APK will be created at:
```
app_pojavlauncher\build\outputs\apk\fullRelease\app_pojavlauncher-full-release.apk
```

## Build Time

Expected build time: **5-15 minutes**
- First build is longer (downloads dependencies)
- Subsequent builds are faster

## Troubleshooting

### Issue: NDK Not Found
```
Error: NDK not found
```
**Solution:**
1. Open Android Studio
2. Go to: Settings → Appearance & Behavior → System Settings → Android SDK
3. Go to: SDK Tools tab
4. Check: "NDK (Side by side)"
5. Click: Apply → OK
6. Restart build

### Issue: Java Not Found
```
'java' is not recognized as an internal or external command
```
**Solution:**
1. Install JDK 11 or higher
2. Add Java to system PATH
3. Restart Command Prompt

### Issue: Gradle Daemon Issues
```
Gradle daemon shut down unexpectedly
```
**Solution:**
```batch
gradlew.bat --stop
gradlew.bat clean
gradlew.bat assembleFullRelease
```

### Issue: Out of Memory
```
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
```
**Solution:** The `gradle.properties` already sets JVM to 4GB. Try increasing it:
1. Edit: `gradle.properties`
2. Change: `org.gradle.jvmargs=-Xmx6144M`

## After Build

Once the APK is generated:
1. Transfer the APK to an Android device
2. Install: `adb install app_pojavlauncher-full-release.apk`
3. Or install manually via Android's file manager

## Files Modified

The following files were updated:
- `app_pojavlauncher/build.gradle` - Package name, NDK build enabled
- `app_pojavlauncher/src/main/AndroidManifest.xml` - Package queries updated
- `app_pojavlauncher/src/main/res/values/strings.xml` - App name and labels updated
- `BUILD_CRYONIX_APK.bat` - Helper build script (new)

## Need Help?

If the build fails:
1. Run the build with verbose output:
   ```batch
   gradlew.bat assembleFullRelease --stacktrace
   ```
2. Share the error output
3. Verify all requirements are installed

---
**Build Configuration:** Full Release APK with all libraries included
**Target Android:** API 21+ (Android 5.0 and above)
