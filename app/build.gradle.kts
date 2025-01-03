

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.services)
}

android {
    signingConfigs {
        getByName("debug") {
            storeFile = file("E:\\JobAndroid\\MyKey\\keyandroid.jks")
            storePassword = "Ybrjkm"
            keyAlias = "key0"
            keyPassword = "Ybrjkm"
        }
        create("release") {
            storeFile = file("E:\\JobAndroid\\MyKey\\keyandroid.jks")
            storePassword = "Ybrjkm"
            keyAlias = "key0"
            keyPassword = "Ybrjkm"
        }
    }
    namespace = "com.volkov.notificationjeleapps"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.volkov.notificationjeleapps"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }


}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.core.coroutines)
    implementation(libs.koin.core.compose)
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    implementation(platform(libs.firebase.bom))

    implementation(project(":notification"))
}