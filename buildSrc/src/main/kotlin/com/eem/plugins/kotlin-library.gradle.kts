package com.eem.plugins

plugins {
    id("com.eem.plugins.sanity")
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
