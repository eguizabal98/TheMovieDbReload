package com.eem.plugins

import org.gradle.api.JavaVersion
import org.gradle.jvm.toolchain.JavaLanguageVersion

object AppConfig {
    const val NAME_SPACE = "com.eem.themoviedbreload"
    const val APPLICATION_ID = "com.eem.themoviedbreload"

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"

    const val COMPILE_SDK = 35
    const val TARGET_SDK = 35
    const val MIN_SDK = 24

    const val JVM_TARGET = "17"
    
    val javaCompileVersion = JavaVersion.VERSION_17
    val javaLanguageVersion: JavaLanguageVersion = JavaLanguageVersion.of(17)
}
