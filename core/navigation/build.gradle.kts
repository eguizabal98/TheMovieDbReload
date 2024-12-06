plugins {
    id("com.eem.plugins.android-library")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    alias(libs.plugins.kotlin.compose)
}

android {
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.compose.navigation)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // google
    implementation(libs.gson)
}
