pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle.kts.kts files
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android.tools.build") {
                useModule("com.android.tools.build:gradle:8.0.2")
            }
            if (requested.id.namespace == "org.jetbrains.kotlin") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.21")
            }
            if (requested.id.namespace == "com.google.firebase") {
                useModule("com.google.firebase:firebase-crashlytics-gradle:2.9.2")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://jitpack.io")
        }
        // 蒲公英的仓库
        maven {
            // GitHub CI/CD 环境对 Cookie 的管理会更加严格，当域名不合法时会直接拒绝使用。该仓库没有遵循
            // RFC 6265 标准，所以要允许不安全的协议
            isAllowInsecureProtocol = true
            setUrl("https://frontjs-static.pgyer.com/dist/sdk/pgyersdk")
        }
    }
}

rootProject.name = "dora_samples"
include(":app")
include(":dview")
include(":common")
include(":dcache")
include(":dora")
