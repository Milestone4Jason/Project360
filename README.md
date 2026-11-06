# Project360

Project360 is an Android Xbox 360 emulator build for ARM64 devices.

## Emulator engine

The APK build uses **Xendroid+**, an Android port based on the Xenia Xbox 360 emulation project. The GitHub Actions workflow fetches a pinned upstream source revision, changes the displayed app name to Project360 (while retaining upstream credits and licensing), and builds its Android APK.

- Upstream project: https://github.com/phforner0/Xendroid-Plus
- Pinned upstream source: https://github.com/phforner0/Xendroid-Plus/commit/f8fa3066e2930725fd25d82deabd255434552922
- Upstream build instructions: https://github.com/phforner0/Xendroid-Plus/blob/main/BUILD.md
- Upstream license: AGPL-3.0-or-later; see the upstream repository and third-party notices for the full license information.

## Build

GitHub Actions builds the ARM64 Android emulator APK. Open the latest successful run in the Actions tab and download the artifact named `Project360-Xbox360-emulator-arm64`.

The build requires JDK 21, Android SDK 35, NDK 29.0.14206865, CMake 3.30.3, Ninja, Python 3, glslang and SPIR-V tools.

## Device compatibility

The emulator is experimental. It requires Android 10+ on 64-bit ARM and a Vulkan-capable GPU. The upstream project recommends Snapdragon 8 Gen 2 or newer with a supported Adreno GPU. The Samsung Galaxy Tab A7 (Snapdragon 662 / Adreno 610) is below the recommended hardware and may fail to launch games or perform very poorly.

## Games and system files

No games, disc images, firmware, system files or keys are included. Use only game backups and system files you are legally entitled to use.

## Credits

Project360's emulator engine is based on Xendroid+ by phforner0, which continues the XenDroid Android port by rfandango and uses Xenia/Xenia Canary. Project360 is not affiliated with or endorsed by Microsoft.
