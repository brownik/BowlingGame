plugins {
    id("brownik.android.library")
    id("brownik.android.hilt")
}

android {
    namespace = "com.brownik.bowling_game.common_ui"

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(projects.common.commonUtil)
    implementation(projects.common.commonModel)

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)

    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)

    /* AnKo */
    implementation(libs.anko.commons)
    implementation(libs.anko.sdk25)

    implementation(libs.lottie)
}