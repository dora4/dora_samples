plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.example.app"
    compileSdk = 36
    buildToolsVersion = "34.0.0"
    defaultConfig {
        minSdk = 24
        versionCode = 81
        versionName = "1.6.22"
        applicationId = "com.example.dora"
        // 21以上虚拟机天然支持multidex
        multiDexEnabled = true
    }
    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("libs")
        }
    }
    buildFeatures {
        dataBinding = true
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
}

kotlin {
    // 安装了多jdk的情况下，编译时自动帮你选jvm，否则需要手动操作IDE
    jvmToolchain(17)
}

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":dora"))
    implementation(project(":dview"))
    implementation(project(":dcache"))
    kapt("com.alibaba:arouter-compiler:1.5.2")
    kapt("com.google.dagger:dagger-compiler:2.16")
}
