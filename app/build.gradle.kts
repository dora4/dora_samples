plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.example.app"
    compileSdk = 34
    buildToolsVersion = "34.0.0"
    defaultConfig {
        minSdk = 23
        targetSdk = 34
        versionCode = 48
        versionName = "1.5.16"
        applicationId = "com.example.dora"
        // 21以上虚拟机天然支持multidex
        multiDexEnabled = true
    }
    flavorDimensions.add("app")
    // Flavor变体
    productFlavors {
//        create("beta") {
//            dimension = "app"
//            versionNameSuffix = "-beta"
//        }
//        create("alpha") {
//            dimension = "app"
//            applicationIdSuffix = ".alpha"
//            versionNameSuffix = "-alpha"
//        }
//        create("dev") {
//            dimension = "app"
//            applicationIdSuffix = ".dev"
//            versionNameSuffix = "-dev"
//        }
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
    signingConfigs {
        create("release") {
            storeFile = File(rootProject.projectDir, "dora_samples.jks")
            keyAlias = "key0"
            keyPassword = "123456"
            storePassword = "123456"
            enableV1Signing = true
            enableV2Signing = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_17)
        targetCompatibility(JavaVersion.VERSION_17)
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
    }
}

dependencies {
    // 官方库
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.databinding:databinding-runtime:7.0.0")
    
    implementation(project(":common"))
    implementation(project(":dora"))
    implementation(project(":dview"))
    implementation(project(":dcache"))

    kapt("com.alibaba:arouter-compiler:1.5.2")
    kapt("com.google.dagger:dagger-compiler:2.16")

    implementation("com.github.dora4:dora-firebase-support:1.13")
//    implementation(platform("com.google.firebase:firebase-bom:33.14.0"))
//    implementation("com.google.firebase:firebase-crashlytics-ktx")
//    implementation("com.google.firebase:firebase-analytics-ktx")
//    implementation("com.google.firebase:firebase-config-ktx")
//    implementation("com.google.firebase:firebase-analytics-ktx")
}
