plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.dview"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
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

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    implementation(project(":common"))
    implementation("com.github.dora4:dview-bottom-dialog:1.13")
    implementation("com.github.dora4:dview-loading-dialog:1.5")
    implementation("com.github.dora4:dview-progress-view:1.0")
    implementation("com.github.dora4:dview-toggle-button:1.5")
    implementation("com.github.dora4:dview-toast:1.1")
    implementation("com.github.dora4:dview-tabbar:1.1")
    implementation("com.github.dora4:dview-radio-group:1.0")
    implementation("com.github.dora4:dview-empty-layout:1.12")
    implementation("com.github.dora4:dview-menu-panel:1.38")
    implementation("com.github.dora4:dview-flexible-scrollview:1.0")
    implementation("com.github.dora4:dview-swipe-layout:1.0")
    implementation("com.github.dora4:dview-floating-menu:1.1")
    implementation("com.github.dora4:dview-gridview:1.20")
    implementation("com.github.dora4:dview-coupon-view:1.16")
    implementation("com.github.dora4:dview-flow-layout:1.0")
    implementation("com.github.dora4:dview-iconlabel-view:1.0")
    implementation("com.github.dora4:dview-swipe-menu:1.1")
    implementation("com.github.dora4:dview-badge-view:1.0")
    implementation("com.github.dora4:dview-bottombar:1.9")
    implementation("com.github.dora4:dview-progressbar:1.0")
    implementation("com.github.dora4:dview-addsub-view:1.3")
    implementation("com.github.dora4:dview-dropdown-layout:1.2")
    implementation("com.github.dora4:dview-clear-edittext:1.0")
    implementation("com.github.dora4:dview-charts:1.0")
    implementation("com.github.dora4:dview-pinchzoom-layout:1.0")
    implementation("com.github.dora4:dview-sidebar:1.0")
    implementation("com.github.dora4:dview-skeleton-view:1.0")
    implementation("com.github.dora4:dview-flash-view:1.0")
    implementation("com.github.dora4:dview-button:1.0")
    implementation("com.github.dora4:dview-flipper-view:1.2")
    implementation("com.github.dora4:dview-parallax-layout:1.2")
    implementation("com.github.dora4:dview-avatar:1.4")





    kapt("com.alibaba:arouter-compiler:1.5.2")
    kapt("com.google.dagger:dagger-compiler:2.16")
}