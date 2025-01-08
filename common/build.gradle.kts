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
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

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
    api("com.github.dora4:dora:1.2.36")
    api("com.github.dora4:dora-brvah-support:1.2")
    api("com.github.dora4:dora-arouter-support:1.6")
    api("com.github.dora4:dora-dagger-support:1.12")
    api("com.github.dora4:dcache-android:3.1.8")
//    api("com.github.dora4:dora-eventbus-support:1.1")
    api("com.github.dora4:dview-colors:1.1")
    api("com.github.dora4:dview-titlebar:1.37")

    // XXPermissions
    api("com.github.getActivity:XXPermissions:18.2")
    // AgentWeb
    api("com.github.Justson.AgentWeb:agentweb-core:v5.0.0-alpha.1-androidx") // (必选)
//    implementation("com.github.Justson.AgentWeb:agentweb-filechooser:v5.0.0-alpha.1-androidx") // (可选)
//    implementation("com.github.Justson:Downloader:v5.0.0-androidx") // (可选)

}