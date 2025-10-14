plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    // 不要去掉，BindingAdapters类需要
    id("kotlin-kapt")
}

android {
    namespace = "com.example.common"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        // ARouter
        kapt {
            arguments {
                arg("AROUTER_MODULE_NAME", project.name)
            }
        }
    }
    buildFeatures {
        // 不要去掉，BindingAdapters类需要
        dataBinding = true
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Dora全家桶
    api("com.github.dora4:dora:1.3.37")
    api("com.github.dora4:dora-brvah-support:1.5")
    api("com.github.dora4:dora-arouter-support:1.6")
    kapt("com.alibaba:arouter-compiler:1.5.2")
    api("com.github.dora4:dora-pgyer-support:1.9")

    api("com.github.dora4:dora-dagger-support:1.12")
    api("com.github.dora4:dora-walletconnect-support:2.1.16") {
        exclude(group = "com.madgag.spongycastle", module = "core")
    }
    api("com.github.dora4:dcache-android:3.5.6")
//    api("com.github.dora4:dora-eventbus-support:1.1")
    api("com.github.dora4:dview-colors:1.1")
    api("com.github.dora4:dview-titlebar:1.37")
    api("com.github.dora4:dview-menu-panel:1.39")
    api("com.github.dora4:dview-empty-layout:1.12")
    api("com.github.dora4:dview-swipe-layout:1.0")
    api("com.github.dora4:dview-alert-dialog:1.25")

    // XXPermissions
    api("com.github.getActivity:XXPermissions:18.2")
    // AgentWeb
    api("com.github.Justson.AgentWeb:agentweb-core:v5.0.0-alpha.1-androidx")
}