# Namma-Raste Reporter (Android Project)

## Project Overview
This is a Kotlin-based Android application for reporting infrastructure issues.
Built with:
- Jetpack Compose
- MVVM Architecture
- CameraX API
- Firebase (Auth, Firestore, Storage)
- Room Database (Offline Cache)
- Material 3

## Setup Instructions

### 1. Firebase Integration
To make the app functional, you need to add your own `google-services.json`:
1. Go to [Firebase Console](https://console.firebase.google.com/).
2. Create a new project named "Namma-Raste Reporter".
3. Add an Android App with package name `com.nammaraste.reporter`.
4. Download `google-services.json` and place it in the `app/` directory of this project.
5. Enable **Authentication** (Email/Password).
6. Enable **Cloud Firestore** in test mode.
7. Enable **Cloud Storage** for images.
8. Monitor your database at: https://console.firebase.google.com/project/gen-lang-client-0814353168/firestore/databases/ai-studio-ed708e32-7d37-4972-bfd1-b690048179ac/data

### 2. Android Studio
1. Open Android Studio.
2. Select "Open" and choose the root directory of this project.
3. Sync Gradle and build.
4. Run on an emulator or physical device (Min SDK 26).

## Development Options

### Option A: Android Studio (Recommended)
1. **Min Version:** Use Android Studio Hedgehog (2023.1.1) or newer.
2. **JDK:** Ensure **JDK 17** is selected in `Settings > Build > Build Tools > Gradle`.
3. **Invalidate Caches:** If you see "Unable to find method" errors, go to `File > Invalidate Caches...` and restart.

### Option B: VS Code
1. Install **Extension Pack for Java**, **Kotlin**, and **Gradle for Java**.
2. Set `JAVA_HOME` to JDK 17 and `ANDROID_HOME` to your Android SDK.
3. Open terminal and run:
   ```bash
   # On Mac/Linux
   ./gradlew installDebug
   
   # On Windows
   gradlew.bat installDebug
   ```

## Key Features
- **One-Tap Reporting:** CameraX implementation for quick evidence capture.
- **Auto-Location:** Fused Location Provider fetches GPS coordinates automatically.
- **Unique Ticket ID:** Auto-generated structured IDs (NR-YYYY-XXXX).
- **Offline Mode:** Reports are saved to Room DB and can be synced later.
- **Status Tracking:** Real-time updates from Firestore.

---
*Developed for Namma Raste (Our Road).*

## Troubleshooting Gradle Errors
If you see "Unable to find method... fileCollection(Spec)" or sync errors:
1. **Clean & Build:** `Build > Clean Project`, then `Build > Rebuild Project`.
2. **Invalidate Caches:** Go to `File > Invalidate Caches...`, check all boxes, and click `Invalidate and Restart`.
3. **JDK Version:** Ensure you are using **JDK 17** for the Gradle JDK (found in `Settings > Build, Execution, Deployment > Build Tools > Gradle`).
4. **Force Sync:** Click the "Sync Project with Gradle Files" icon (blue elephant) in the top toolbar.
5. **Delete .gradle folder:** Close Android Studio, delete the `.gradle` folder in the project root, and reopen.
