plugins {
    id("brownik.android.library")
    id("brownik.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.brownik.bowling_game.core_network"

    kapt { correctErrorTypes = true }
}

dependencies {
    implementation(projects.common.commonModel)
    implementation(projects.common.commonUtil)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.converter.scalars)

    implementation(libs.okhttp)
    implementation(libs.okhttp.interceptor)
    implementation(libs.google.gson)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.serialization.converter)
}