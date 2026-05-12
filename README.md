# Namma-Raste Reporter

## Project Overview
Namma-Raste Reporter is a Kotlin-based Android application developed to help citizens report infrastructure problems such as potholes and broken streetlights quickly and efficiently.

The application allows users to capture issue images, automatically fetch GPS location, generate unique ticket IDs, and track report status digitally.

---

## Technologies Used
- Kotlin
- Jetpack Compose
- MVVM Architecture
- CameraX API
- Firebase Authentication
- Firebase Firestore
- Firebase Storage
- Room Database
- Material 3 Design

---

## Key Features

### Infrastructure Issue Reporting
- Capture pothole or streetlight issues using CameraX.
- Automatic GPS location and timestamp logging.
- Generate unique Ticket IDs for each report.

### Authentication System
- Secure user login and registration using Firebase Authentication.

### Database Integration
- Firebase Firestore for cloud data storage.
- Firebase Storage for storing captured images.
- Room Database for offline caching support.

### Status Tracking
Users can track submitted complaints using generated Ticket IDs.

### Offline Support
Reports can be temporarily stored locally and synced later.

---

## Project Setup Instructions

### Firebase Configuration
1. Open Firebase Console.
2. Create a new Firebase project.
3. Add Android application using package name:
   ```text
   com.nammaraste.reporter
   ```
4. Download `google-services.json`.
5. Place the file inside:
   ```text
   app/google-services.json
   ```

### Android Studio Setup
1. Open the project in Android Studio.
2. Sync Gradle files.
3. Connect emulator or Android device.
4. Run the application.

---

## Requirements
- Android Studio Hedgehog or newer
- JDK 17
- Minimum SDK 26

---

## Screenshots

### Register Screen
<img width="1920" height="1080" alt="Screenshot (90)" src="https://github.com/user-attachments/assets/3584de62-7078-426b-9407-95ccae3ee68f" />


### Home Dashboard
<img width="1920" height="1080" alt="Screenshot (91)" src="https://github.com/user-attachments/assets/3d30c46e-c285-44a3-8a23-63e3795304c7" />


### Issue Reporting Screen
<img width="1920" height="1080" alt="Screenshot (92)" src="https://github.com/user-attachments/assets/e7adb1b9-1992-46b6-878a-284119b559a6" />

---

## Future Enhancements
- AI-based pothole severity detection
- Push notifications
- Google Maps integration
- Admin dashboard for authorities

---

## Developed By
Namratha K Kadam

---

## Troubleshooting
If Gradle sync issues occur:
1. Clean Project
2. Rebuild Project
3. Invalidate Caches and Restart
4. Ensure JDK 17 is selected
5. Re-sync Gradle files
