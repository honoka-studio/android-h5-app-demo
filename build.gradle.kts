import de.honoka.gradle.plugin.android.dsl.androidTestImplementation
import de.honoka.gradle.plugin.android.ext.kotlinAndroid
import de.honoka.gradle.plugin.basic.dsl.implementation
import de.honoka.gradle.plugin.basic.dsl.testImplementation
import de.honoka.gradle.util.data.classifyProjects
import de.honoka.gradle.util.dsl.applier
import de.honoka.gradle.util.dsl.invoke
import de.honoka.gradle.util.dsl.libs
import de.honoka.gradle.util.dsl.projects

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.honoka.android)
}

group = "de.honoka.android"
version = libs.versions.p.app.get()

val projects = classifyProjects {
    app = projects("app")
}

projects.app {
    applier {
        `android-application`
        `kotlin-android`
        `honoka-android`
    }

    group = rootProject.group

    honoka.basic {
        configs {
            java(11)
            kotlin()
        }

        dependencies {
            kotlinAndroid()
        }
    }

    honoka.android {
        app {
            compileSdk = libs.versions.a.compile.sdk.get().toInt()

            defaultConfig {
                minSdk = libs.versions.a.min.sdk.get().toInt()
                targetSdk = compileSdk
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            buildTypes {
                release {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            packaging {
                val excludes = listOf("META-INF/INDEX.LIST")
                resources.excludes.addAll(excludes)
            }
        }
    }

    //noinspection UseTomlInstead
    dependencies {
        implementation("androidx.core:core-ktx:1.16.0")
        implementation("androidx.appcompat:appcompat:1.7.1")
        implementation("com.google.android.material:material:1.12.0")
        implementation("androidx.activity:activity:1.10.1")
        implementation("androidx.constraintlayout:constraintlayout:2.2.1")
        implementation(libs.honoka.android.utils)
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.3.0")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
    }
}

libs.versions.d.kotlin.coroutines
