plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.dora"
    compileSdk = 34
    buildToolsVersion = "33.0.1"
    lint {
        checkReleaseBuilds = false
        // Or, if you prefer, you can continue to check for errors in release builds,
        // but continue the build even when errors are found:
        abortOnError = false
    }
    defaultConfig {
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        applicationId = "com.example.dora"
        // 21以上虚拟机天然支持multidex
        multiDexEnabled = true
    }
    flavorDimensions.add("app")
    // Flavor变体
    productFlavors {
        create("beta") {
            dimension = "app"
            versionNameSuffix = "-beta"
        }
        create("alpha") {
            dimension = "app"
            applicationIdSuffix = ".alpha"
            versionNameSuffix = "-alpha"
        }
        create("dev") {
            dimension = "app"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
        }
    }
    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("libs")
        }
    }
    buildFeatures {
        dataBinding = true
        buildConfig = true
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_17)
        targetCompatibility(JavaVersion.VERSION_17)
    }
}

kapt {
    generateStubs = true
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
    }
}

dependencies {
    // 官方库
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Dora全家桶
    implementation("com.github.dora4:dora:1.2.26")
    implementation("com.github.dora4:dora-eventbus-support:1.1")
    implementation("com.github.dora4:dora-brvah-support:1.2")
    implementation("com.github.dora4:dora-arouter-support:1.6")
    kapt("com.alibaba:arouter-compiler:1.5.2")
    implementation("com.github.dora4:dora-dagger-support:1.12")
    kapt("com.google.dagger:dagger-compiler:2.16")
    implementation("com.github.dora4:dcache-android:2.4.13")
    implementation("com.github.dora4:dview-titlebar:1.37")
    implementation("com.github.dora4:dview-colors:1.0")
    implementation("com.github.dora4:dview-bottom-dialog:1.13")
    implementation("com.github.dora4:dview-loading-dialog:1.5")
    implementation("com.github.dora4:dview-alert-dialog:1.18")
    implementation("com.github.dora4:dview-progress-view:1.0")

    // XXPermissions
    implementation("com.github.getActivity:XXPermissions:18.2")

    // AgentWeb
    implementation("com.github.Justson.AgentWeb:agentweb-core:v5.0.0-alpha.1-androidx") // (必选)
//    implementation("com.github.Justson.AgentWeb:agentweb-filechooser:v5.0.0-alpha.1-androidx") // (可选)
//    implementation("com.github.Justson:Downloader:v5.0.0-androidx") // (可选)

}
