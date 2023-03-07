plugins {
    id("brownik.android.library")
    id("brownik.android.hilt")
    id("brownik.android.feature")
}

android {
    namespace = "com.brownik.bowling_game.feature_game"

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
    implementation(libs.androidx.activity)
    implementation(libs.google.gson)
    implementation(libs.richUtilsKt)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.fragment.ktx)
}