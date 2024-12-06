plugins {
    id("com.eem.plugins.kotlin-library")
    id("com.google.devtools.ksp")
}

dependencies {
    // Hilt
    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)

    // OkHttp
    implementation(platform(libs.okhttp.bom))
    implementation(libs.logging.interceptor)
    implementation(libs.okhttp)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // Gson
    implementation(libs.gson)
}