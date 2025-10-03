import de.honoka.gradle.plugin.android.ext.kotlinAndroid

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.honoka.android)
}

version = libs.versions.p.app.get()

java {
    toolchain.languageVersion = JavaLanguageVersion.of(11)
}

android {
    namespace = "de.honoka.android.h5appdemo"
    compileSdk = libs.versions.a.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = "de.honoka.android.h5appdemo"
        minSdk = libs.versions.a.min.sdk.get().toInt()
        targetSdk = compileSdk
        versionCode = libs.versions.pvc.app.get().toInt()
        versionName = project.version as String
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

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xjvm-default=all")
    }
}

honoka.basic.dependencies {
    kotlinAndroid()
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
