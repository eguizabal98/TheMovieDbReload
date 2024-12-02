package com.eem.plugins

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = AppConfig.NAME_SPACE
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = AppConfig.javaCompileVersion
        targetCompatibility = AppConfig.javaCompileVersion
    }

    kotlinOptions {
        jvmTarget = AppConfig.JVM_TARGET
    }

    buildFeatures {
        compose = true
    }

    packaging { excludeCommonResources() }
}

kotlin {
    jvmToolchain(AppConfig.javaLanguageVersion.asInt())
    compilerOptions {
        allWarningsAsErrors = false
    }
}

dependencies {
    libs.findLibrary("androidx.core").ifPresent(this::implementation)
    libs.findLibrary("dispatch.core").ifPresent(this::implementation)
}
