plugins {
    id("brownik.android.library")
    id("brownik.android.hilt")
    id("kotlinx-serialization")
//    id("com.google.gms.google-services")
}

android {
    namespace = "com.brownik.bowling_game.core_database"

    kapt { correctErrorTypes = true }
}

dependencies {
    implementation(projects.common.commonModel)
    implementation(projects.common.commonUtil)

//    implementation("com.google.firebase:firebase-database:20.1.0")
    implementation(libs.google.firebase.database)
}