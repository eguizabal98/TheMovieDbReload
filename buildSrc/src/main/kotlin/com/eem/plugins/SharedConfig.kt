package com.eem.plugins

import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.Packaging
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import java.io.File

const val DEFAULT_PROGUARD_FILE_NAME = "proguard-android-optimize.txt"

val COMPILER_ARGS = listOf(
    "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
    "-opt-in=kotlinx.coroutines.FlowPreview",
    "-opt-in=kotlin.time.ExperimentalTime",
    "-opt-in=kotlin.ExperimentalStdlibApi",
)

fun BuildType.configureRelease(proguardFile: File) {
    isMinifyEnabled = false
    proguardFiles(
        proguardFile,
        "proguard-rules.pro",
    )
}

fun Packaging.excludeCommonResources() {
    resources {
        excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        excludes.add("/META-INF/LICENSE.md")
        excludes.add("/META-INF/LICENSE-notice.md")
    }
}

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

