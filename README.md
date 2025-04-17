# AI Assistant (Chat Assistant & Image Generator App)

This Android application integrates a chat assistant powered by Google's Gemini API and an image generation feature using Imagine.art, providing a versatile tool for interacting with AI and creating images from text prompts. It leverages OkHttp for efficient REST API communication and follows modern Android development practices.

## Key Features

1.  **Gemini Chat Assistant:**
    *   Engage in conversations with an AI assistant powered by the Gemini API.
    *   Receive intelligent and context-aware responses to your queries.
    *   Enjoy a natural language processing experience within the app.

2.  **Imagine.art Image Generator:**
    *   Generate images from text prompts using the Imagine.art API.
    *   Visualize your ideas and concepts by creating images based on your descriptions.
    *   Experiment with different prompts to explore the creative capabilities of the AI.

3.  **REST API Communication with OkHttp:**
    *   Utilizes OkHttp, a robust and efficient HTTP client, for seamless communication with the Gemini and Imagine.art APIs.
    *   Handles network requests, responses, and potential errors effectively.
    *   Ensures reliable and performant interaction with the external APIs.

4.  **Modern Android Development:**
    *   Built with Kotlin, a concise and expressive programming language.
    *   Employs Jetpack Compose for a declarative and reactive user interface.
    *   Follows best practices for code organization, maintainability, and performance.

## Technologies Used

*   **Kotlin:** The primary programming language for robust and concise code.
*   **Jetpack Compose:** For building a declarative and reactive user interface.
*   **OkHttp:** For making efficient and reliable REST API calls to the Gemini and Imagine.art services.
*   **Google AI Client SDK for Android:**  Provides convenient access to the Gemini API for chat functionality.
*   **Navigation Compose:** For managing navigation between different screens within the app.
*   **MVVM Architecture:** The app follows the Model-View-ViewModel architecture pattern, ensuring separation of concerns and maintainability of code.
*   **Compose Animation:** Adds smooth and engaging animations to the user interface.

## Getting Started

1. **Clone the repository:**  
   ```
   https://github.com/qaziHuzaif/AIAssistant.git
2.  **Open in Android Studio:**
    *   Open Android Studio and select "Open an Existing Project."
    *   Navigate to the cloned repository and select the root directory.

3.  **API Keys:**
    *   You will need API keys for both the Gemini API and the Imagine.art API.
    *   **Gemini API Key:** Obtain an API key from the Google AI Studio ([https://makersuite.google.com/app/apikey](https://makersuite.google.com/app/apikey)).
    *   **Imagine.art API Key:** Obtain an API key from Imagine.art ([https://www.imagine.art/api/keys](https://www.imagine.art/api/keys)).
    *   **Securely Store API Keys:**  **Do not hardcode your API keys directly in the code.**

4.  **Build and Run:**
    *   Connect an Android device or start an emulator.
    *   Click the "Run" button in Android Studio to build and run the app.

## Dependencies

The project uses the following key dependencies (as specified in your `build.gradle` file):

*   `com.google.ai.client.generativeai:generativeai`
*   `com.squareup.okhttp3:okhttp`
*   `androidx.navigation`
  
(And other dependencies listed in the project)
