import com.brownik.bowling_game.build_logic.VersionConstants

plugins {
    id("brownik.android.application")
    id("brownik.android.hilt")
    id("brownik.android.feature")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.brownik.bowling_game"
    compileSdkVersion (33)

    val extensionAware = this as ExtensionAware

    defaultConfig {
        multiDexEnabled = true
        applicationId = VersionConstants.APPLICATION_ID
        versionCode = VersionConstants.VERSION_CODE
        versionName = VersionConstants.VERSION_NAME
    }

    kapt {
        mapDiagnosticLocations = true
        correctErrorTypes = true
    }

    lintOptions {
        isCheckReleaseBuilds = false
        isAbortOnError = false
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    implementation(libs.androidx.core)
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.viewpager2)
    implementation(libs.androidx.constraintlayout)

    // Firebase
    implementation(platform(libs.google.firebase))
    implementation(libs.google.firebase.analytics) // 파이어베이스 : 애널리틱스
    implementation(libs.google.firebase.messaging) // 파이어베이스 : 메세징
    implementation(libs.google.firebase.config) // 파이어베이스 : 리모트콘피그
    implementation(libs.google.firebase.dynamiclinks) // 파이어베이스 : 딥링크
    implementation(libs.google.firebase.crashlytics)
    implementation(libs.google.firebase.auth)

    // Google
    implementation(libs.google.play.services.auth)
    implementation(libs.google.play.services.base)
    implementation(libs.google.play.services.location)

    implementation(libs.androidx.lifecycle.extension)
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.livedata)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.legacy.support)
    implementation(libs.androidx.exifinterface)
    implementation(libs.androidx.core.shortcuts)
    implementation(libs.androidx.viewpager2)
    implementation(libs.androidx.workmanager)

    // Util
    implementation(libs.google.gson) // Gson
    implementation(libs.richUtilsKt) // RPermission 등등 사용 유틸.

    // coroutine
    implementation(libs.coroutine.core)
    implementation(libs.coroutine.android)

    // 에뮬레이터 체크
    implementation(libs.antifake)

    // 루팅 체크
    implementation(libs.rootbeer)

    /* AnKo */
    implementation(libs.anko.commons)
    implementation(libs.anko.sdk25)
}