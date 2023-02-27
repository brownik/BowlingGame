plugins {
    id("brownik.android.library")
    id("brownik.android.hilt")
}

android {
    namespace = "com.brownik.bowling_game.common_util"

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    kapt { correctErrorTypes = true }
}

dependencies {

    implementation(projects.common.commonModel)

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.security.crypto)

    implementation(libs.glide)

    implementation(libs.coroutine.core)
    implementation(libs.coroutine.android)
    implementation(libs.google.gson)

    implementation(libs.okhttp)
    implementation(libs.okhttp.interceptor)

    /* AnKo */
    implementation(libs.anko.commons)
    implementation(libs.anko.sdk25)

    // Firebase
    implementation(platform(libs.google.firebase))
    implementation(libs.google.firebase.analytics)
    implementation(libs.google.firebase.crashlytics)
    implementation(libs.google.firebase.messaging)

    testImplementation(libs.junit)
    testImplementation(libs.coroutine.test)

    implementation(libs.jsoup)
}