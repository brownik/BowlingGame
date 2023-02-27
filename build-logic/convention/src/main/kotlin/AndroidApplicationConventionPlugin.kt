import com.android.build.api.dsl.ApplicationExtension
import com.brownik.bowling_game.build_logic.VersionConstants
import com.brownik.bowling_game.build_logic.configureBuildFeatures
import com.brownik.bowling_game.build_logic.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("kotlin-kapt")
                apply("com.google.firebase.crashlytics")
                apply("com.google.gms.google-services")
                apply("kotlin-parcelize")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureBuildFeatures()
                defaultConfig.targetSdk = VersionConstants.TARGET_SDK
            }
        }
    }
}