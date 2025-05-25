# <img src="https://github.com/user-attachments/assets/b470d2ae-4dd1-4e4a-9b72-4f362bb2b9e8" width="60" height="60" align="center" /> Server Status - Higher Or Lower
A simple Android app that monitors the status of a server. Every 15 minutes, a background worker sends a request to a specified server link. If no response is received or server responds incorrectly, the app notifies the user that the server is down.

## ⭐️Features
- ⏱️ Periodic server checks every 15 minutes using WorkManager
- 🔔 Push notifications if the server is down or unreachable
- 🟢 Clean UI showing the current status (UP / DOWN / UNREACHABLE)
- 🌙 Works in the background even when the app is closed

## ⚙️Technologies
- **Kotlin & Jetpack Compose** - Modern UI toolkit for declarative UI design.
- **Ktor** - Network client for fetching movie data from TMDB API.
- **Koin** - Dependency injection
- **WorkManager** – Handles background tasks reliably, even if the app is closed or the device restarts. Used to check server status every 15 minutes.

## Here are some overview pictures:
![Image](https://github.com/user-attachments/assets/1fa3f082-28ff-4e2e-aa55-2670edb61fab)
![1](https://github.com/user-attachments/assets/7d17e298-73ab-4321-8b01-0d2c4d874455)
![Image](https://github.com/user-attachments/assets/6ca6d2c3-3e7c-4254-b2cf-3a788a348c90)

## Installation
1. Clone the repository:
```bash
git clone https://github.com/AdamDawi/Status-Higher-or-Lower
```
2. Open the project in Android Studio.
3. Be sure the versions in gradle are same as on github
4. Add the server URL to your local gradle.properties file as follows:
```properties
SERVER_URL="https://test.com"
```

## Requirements
Minimum version: Android 7.0 (API level 24) or later📱

Target version: Android 15 (API level 35) or later📱

## Author

Adam Dawidziuk🧑‍💻
