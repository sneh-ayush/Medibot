import org.gradle.internal.impldep.junit.runner.Version.id

rootProject.name = "Medibot"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
                gradlePluginPortal()
                maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
                gradlePluginPortal()
                maven("https://maven.pkg.jetbrains.space/public/p/compose/dev") // Required

            }
        }
        mavenCentral()
    }
}

include(":composeApp")