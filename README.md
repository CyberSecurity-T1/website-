<div align="center">

# 🎮 Cyber Leveling

**A cybersecurity education platform with safe labs, academy courses, AI assistance, and RPG-style progression.**

[![Release](https://img.shields.io/badge/Release-v1.0.0-blue?style=for-the-badge)](https://github.com/CyberSecurity-T1/website-/releases/tag/v1.0.0)
[![Android](https://img.shields.io/badge/Android-8+-brightgreen?style=for-the-badge&logo=android)](https://github.com/CyberSecurity-T1/website-/releases/tag/v1.0.0)
[![License](https://img.shields.io/badge/License-Educational%20Use-lightblue?style=for-the-badge)](LICENSE)

[🌐 Live Website](https://cybersecurity-t1.github.io/website-/) • [📱 Get APK](#download-apk) • [📖 Docs](#documentation) • [🚀 Getting Started](#getting-started)

</div>

---

## Overview

Cyber Leveling is a comprehensive Android application designed to teach cybersecurity fundamentals through structured lessons, hands-on labs, AI-guided learning, and quantifiable progression. The platform combines an engaging user interface with a rigorous curriculum focused on defensive security.

All practical exercises run in isolated, sandboxed environments. **This project is authorized for educational use only** and does not provide tools for attacking real-world systems.

---

## 🎯 Features

### 🏫 Academy
- Structured curriculum across Linux, Networking, Web Security, and Defense
- Progressive lessons with clear learning objectives
- XP-based progression system with visual feedback

### 🧪 Safe Labs
- Sandboxed terminal simulations for hands-on practice
- Real-world scenario validation with safe feedback loops
- No access to external networks or production systems

### 🤖 AI Tutor
- Context-aware hints and educational guidance
- Powered by backend APIs (no embedded keys)
- Supports collaborative learning without spoilers

### 📊 Player Progression
- XP and leveling system with rank advancement
- Daily streaks and achievement badges
- Offline-ready with automatic sync

---

## 📦 Technical Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Kotlin 1.9+ |
| **UI Framework** | Jetpack Compose |
| **Architecture** | MVVM + Clean Architecture |
| **Dependency Injection** | Hilt 2.52 |
| **Local Database** | Room 2.6.1 |
| **Networking** | Retrofit 2.11 + OkHttp |
| **Background Tasks** | WorkManager 2.9 |
| **Build System** | Gradle 8.7 |
| **Android SDK** | Min: 26, Target: 34 |
| **Java** | OpenJDK 17 |

---

## 🚀 Getting Started

### Prerequisites
- Android Studio (latest)
- Java 17 or higher
- Git

### Clone the Repository

```bash
git clone https://github.com/CyberSecurity-T1/website-.git
cd website-
```

### Build Locally

```bash
# Grant execute permissions to Gradle wrapper
chmod +x ./gradlew

# Build debug APK
./gradlew assembleDebug
```

Generated APK: `app/build/outputs/apk/debug/app-debug.apk`

### Run on Emulator or Device

```bash
./gradlew installDebug
./gradlew run
```

---

## 📥 Download APK

### GitHub Releases

Download the latest APK from the [v1.0.0 Release](https://github.com/CyberSecurity-T1/website-/releases/tag/v1.0.0).

### GitHub Actions Artifacts

Each push to `main` automatically builds a debug APK. Download from the [Actions tab](https://github.com/CyberSecurity-T1/website-/actions).

**Installation:**
1. Enable "Install unknown apps" on your device
2. Transfer the APK file
3. Tap to install

---

## 🏗️ Project Structure

```
website-/
├── app/                          # Android application module
│   ├── src/main/
│   │   ├── java/com/cyberleveling/
│   │   │   ├── academy/         # Academy screens & logic
│   │   │   ├── ai/              # AI tutor integration
│   │   │   ├── labs/            # Lab environment & validation
│   │   │   ├── profile/         # User profile & achievements
│   │   │   ├── data/            # Database, API, repositories
│   │   │   ├── domain/          # Business logic & use cases
│   │   │   ├── di/              # Dependency injection
│   │   │   └── app/             # Application entry point
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── website/                      # GitHub Pages preview
│   ├── index.html
│   ├── styles.css
│   └── script.js
├── gradle/wrapper/               # Gradle wrapper files
├── .github/workflows/
│   ├── build-apk.yml            # APK build automation
│   └── deploy-website.yml       # Website deployment
├── gradle.properties
├── settings.gradle.kts
├── build.gradle.kts
└── README.md
```

---

## 🔄 CI/CD Pipeline

### Build APK Workflow (`.github/workflows/build-apk.yml`)

- **Trigger:** Push to `main`
- **Steps:**
  1. Checkout code
  2. Set up Java 17
  3. Grant Gradle wrapper permissions
  4. Build debug APK
  5. Upload artifact
- **Output:** `cyber-leveling-debug-apk` artifact (16.7 MB)

### Deploy Website Workflow (`.github/workflows/deploy-website.yml`)

- **Trigger:** Push to `main`
- **Steps:**
  1. Checkout code
  2. Upload website artifact
  3. Deploy to GitHub Pages
- **Output:** Live at https://cybersecurity-t1.github.io/website-/

---

## 📝 Version History

### v1.0.0 - Foundation Release

**Features:**
- Android Compose application foundation
- Dark cyberpunk System theme with Neon Cyan accents
- XP, levels, ranks, and daily streak progression system
- Academy with course and lesson structures
- Safe simulated lab terminal with command validation
- AI tutor client networking (backend-only API keys)
- Profile with achievements and badges
- Background sync and offline support via Room
- GitHub Actions automated APK generation

**Technical:**
- Clean Architecture + MVVM pattern
- Hilt dependency injection
- Jetpack Compose UI
- Room database
- Retrofit + OkHttp networking

---

## 📖 Documentation

- **[Live Website Preview](https://cybersecurity-t1.github.io/website-/)** — Interactive demo of app features
- **[Releases Page](https://github.com/CyberSecurity-T1/website-/releases)** — Download APK and release notes
- **[GitHub Actions](https://github.com/CyberSecurity-T1/website-/actions)** — Build status and artifact downloads

---

## 🔐 Security & Safety

✅ **Authorized Educational Use Only**
- All labs run in isolated sandbox environments
- No real-world attack capabilities
- No embedded API keys or secrets
- Backend-only sensitive configurations

✅ **Data Privacy**
- All user data stored locally via Room
- No telemetry or tracking
- Optional cloud sync (future releases)

---

## 🤝 Contributing

We welcome contributions to improve Cyber Leveling. Please follow these guidelines:

1. **Fork** the repository
2. **Create a feature branch** (`git checkout -b feature/amazing-feature`)
3. **Commit changes** with clear messages
4. **Push to your branch** (`git push origin feature/amazing-feature`)
5. **Open a Pull Request** with a detailed description

---

## 📄 License

This project is licensed for **authorized educational use only**. See the LICENSE file for details.

---

## 📞 Support

- **Issues:** [GitHub Issues](https://github.com/CyberSecurity-T1/website-/issues)
- **Discussions:** [GitHub Discussions](https://github.com/CyberSecurity-T1/website-/discussions)

---

<div align="center">

**Built with ❤️ for cybersecurity education**

[⬆ Back to top](#-cyber-leveling)

</div>