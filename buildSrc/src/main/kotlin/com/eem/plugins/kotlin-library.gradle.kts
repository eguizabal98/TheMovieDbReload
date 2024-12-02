package com.eem.plugins

plugins {
    kotlin("jvm")
}

kotlin {
    jvmToolchain(AppConfig.javaLanguageVersion.asInt())
    compilerOptions {
        allWarningsAsErrors = false
        freeCompilerArgs.addAll(COMPILER_ARGS)
    }
}

dependencies {
    libs.findLibrary("kotlinx.coroutines").ifPresent(this::implementation)
    libs.findLibrary("dispatch.core").ifPresent(this::implementation)
}
