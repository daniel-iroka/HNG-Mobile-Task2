# HNG-MOBILE-TASK2

This is the Second Task for the Mobile track in the ZURI HNG INTERNSHIP. This was built entirely using Kotlin.
Appetize Link for the Project [Appetize.io]. To be posted later on.

# Description

This is a simple mobile application which serves as a comprehensive CV, allowing the user to be able to view and edit their personal
and professional information.

# Technical Requirements

These are the setup instructions to run this Project. Ensure you have the Android Studio IDE Installed. If you
don't, you can download it from here [Download Android Studio](https://developer.android.com/studio)

Ensure you also have these dependencies present in yout Project :
In your yout top level gradle file
```
buildscript {
    dependencies {
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.5.1"
    }
}
```

In your App level gradle file
```
plugins {
    id 'androidx.navigation.safeargs'
    id 'kotlin-parcelize'
}
```

```
implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
implementation "androidx.navigation:navigation-fragment-ktx:2.5.1"
implementation "androidx.navigation:navigation-ui-ktx:2.5.1"
```

Follow this steps to run this Project :
- Git clone this project. Run the command below on your windows/linux or mac terminal.
```
git clone https://github.com/daniel-iroka/HNG-Mobile-Task2.git
```
- Use Android Studio 3.3 or later to open the project.
- Use Compile SDK 34.
- Run the App.

Other details include :
```
minSdk 24
targetSdk 32
Android Gradle Plugin Version : '7.4.0-beta01'
```

# Features
## Architecture
Although a simple project, this app was built using the [MVVM](https://proandroiddev.com/understanding-mvvm-pattern-for-android-in-2021-98b155b37b54) architecture which promotes seperation of
concerns, thereby ensuring scalability and robustness of this project if it decides to grow.

## About 
- This App was built entirely using kotlin.
- Makes use of the MVVM Architecture for seperation of concerns and project scalabity.
- This App enables users to be able to both View and Edit their personal prefilled details.
- Clean, readable and interactive UI.
- Updates to user details happen dynamically in real time to enable smooth UI updates and overall good User experience.
- No third party Dependencies were used in the making of this project, rather made good use of native libraries, dependencies and
plugins.

## Assumptions
- Upon running the app for the first timee, it should come prefilled with the User's personal and professional details.
- Users should also be able to edit this prefilled details and add their own.
- Users should not be able to add their details if they leave out the required fields for the proper functioning of the app.
- A Toast message should appear if the User successfully edits their details or leaves out an empty field. 
- The project should also feature smooth navigation between the two screens without any issues. 

## Important Note

Layout Preview may not show up sometimes when opening Android Studio for the first time due to an internal
bug. In case this happens, an easy fix can be achieved by one of this two below :
- Force Refresh Layout in the Design Tab.
- Clean Project or Clean and Rebuild.
