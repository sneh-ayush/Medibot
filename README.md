# Medibot: A Multiplatform Chat Application

This will tell you what all libraries I have used for this and how to run the project
**HOW TO RUN THE PROJECT AS A WEB PROJECT** : 
1- Go to run
2- Click on Edit Configuration
3- Click of Gradle
4- Add this command - wasmJsBrowserRun -t --quiet
5- You will see play button on the right top near corner


## Overview

Medibot is a Kotlin Multiplatform project designed to demonstrate a simple chatbot application that can be deployed on multiple platforms (JVM, JS/Wasm). The UI is built using Jetpack Compose, a modern toolkit for building native UIs. The project incorporates Ktor for HTTP communication and leverages the OpenAI API for generating responses.

## Key Features

*   **Multiplatform UI:** Leverages Jetpack Compose to share a single UI codebase across various platforms.
*   **Chat Interface:** Provides a user-friendly chat interface with message bubbles.
*   **Hugging Face:** Integrates with the OpenAI API to provide intelligent, conversational responses.
*   **Modern Kotlin:** Uses modern Kotlin features like coroutines and serialization.
* **Dependency Injection**: The dependency injection is done by remember.
*   **Clean Code**: The project aims for clean and well-structured code, making it easy to understand and maintain.

## Dependencies

This project relies on the following key dependencies:

### Kotlin Multiplatform

*   **`kotlin-multiplatform` plugin:** Enables the creation of multiplatform projects.

### Jetpack Compose

*   **`org.jetbrains.compose` plugin:** The Compose Multiplatform plugin for building UI.
*   **`androidx.compose.ui:ui`:** Core Compose UI library.
*   **`androidx.compose.material:material`:** Material Design components for Compose.
*   **`androidx.compose.ui:ui-tooling-preview`**: To allow the preview of the UI.
* **`androidx.compose.material3:material3`**: For the material3 UI.
*   **`org.jetbrains.compose.ui:ui-tooling-preview`**: For the preview of the ui.
* **`org.jetbrains.compose.ui:ui-tooling`**: For the tooling of the UI.
* **`org.jetbrains.compose.ui:ui-graphics`**: For the graphics of the UI.
* **`org.jetbrains.compose.ui:ui-test-junit4`**: For the testing.

### Ktor

*   **`io.ktor:ktor-client-core`:** The core Ktor HTTP client library.
*   **`io.ktor:ktor-client-js`:** Ktor engine for Kotlin/JS (browser).
*   **`io.ktor:ktor-client-jvm`:** Ktor engine for Kotlin/JVM.
*   **`io.ktor:ktor-client-content-negotiation`:** For content negotiation.
*   **`io.ktor:ktor-serialization-kotlinx-json`:** For JSON serialization.

### Kotlinx Serialization

*   **`org.jetbrains.kotlinx:kotlinx-serialization-json`:** For JSON serialization/deserialization.

### Resources

*   **org.jetbrains.compose.resources:resources**: For the resources of the project.

### Test

*   **`junit:junit`**: For the testing.

### Plugins

*   **kotlin-multiplatform**: To build a multiplatform application.
*   **kotlinx-serialization**: For the json serialization.
* **org.jetbrains.compose**: For the compose multiplatform.

## Setup Instructions

1.  **Clone the Repository:**
2.  **Open in Android Studio:**
  *   Open Android Studio and select "Open an existing project."
  *   Navigate to the cloned repository and open the project.
3.  **Configure OpenAI API Key:**
  *   You will need an OpenAI API key to use the chatbot functionality.
  *   Add your OpenAI API key in the `OpenAIRepository` class.
4.  **Sync Gradle:**
  *   Wait for Gradle to sync and download all necessary dependencies. You might need to click "Sync Project with Gradle Files" (the elephant icon with the green arrow).
5.  **Run the Project:**
  *   Select a run configuration (e.g., `jvmMain` or `wasmJsMain`) and run the project.

