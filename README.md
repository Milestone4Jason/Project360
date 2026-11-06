# Project360

An Android ARM64-capable dashboard starter inspired by the Xbox 360 interface.

## Included
- Kotlin + Jetpack Compose dashboard
- Local document picker for a system-update ZIP
- GitHub Actions workflow to build a debug APK

## Current status
This is **not yet an Xbox 360 emulator**. It does not execute XEX files, boot the original dashboard, or launch games. A compatible emulator core still needs to be integrated and validated. No Microsoft firmware or commercial games are bundled.

The update picker currently selects a local archive; it does not parse or boot it. Use only update files you are entitled to use.

## Build
GitHub Actions is configured to build `app-debug.apk` on pushes to `main`. Download it from the workflow run's Artifacts section.
