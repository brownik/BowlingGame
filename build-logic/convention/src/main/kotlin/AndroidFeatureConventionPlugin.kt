import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                add("implementation", project(":common:common-base"))
                add("implementation", project(":common:common-model"))
                add("implementation", project(":common:common-ui"))
                add("implementation", project(":common:common-util"))
                add("implementation", project(":core:core-data"))
                add("implementation", project(":core:core-network"))
            }
        }
    }
}