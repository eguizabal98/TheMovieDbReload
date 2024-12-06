package com.eem.plugins

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("com.android.library")
    id("com.eem.plugins.sanity")
    kotlin("android")
}

tasks.withType<Test>().configureEach {
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED)
        showStandardStreams = true
    }
}

android {
    namespace = AppConfig.NAME_SPACE
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AppConfig.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            configureRelease(proguardFile = getDefaultProguardFile(DEFAULT_PROGUARD_FILE_NAME))
            consumerProguardFile("consumer-rules.pro")
        }
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
        freeCompilerArgs.addAll(COMPILER_ARGS)
    }
}

dependencies {
    libs.findLibrary("androidx.core").ifPresent(this::implementation)
    libs.findLibrary("dispatch.core").ifPresent(this::implementation)
}
