plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.lock.base"
    compileSdk = 33

    defaultConfig {
        minSdk = 28

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(com.deshanddez.deshndezz_android.Deps.coreKtx)
    implementation(com.deshanddez.deshndezz_android.Deps.appCompat)
    implementation(com.deshanddez.deshndezz_android.Deps.material)
    implementation(com.deshanddez.deshndezz_android.Deps.constraintXml)
    testImplementation(com.deshanddez.deshndezz_android.Deps.junit)
    androidTestImplementation(com.deshanddez.deshndezz_android.Deps.junitExt)
    androidTestImplementation(com.deshanddez.deshndezz_android.Deps.espresso)

    implementation(com.deshanddez.deshndezz_android.Deps.activityKtx)
    implementation(com.deshanddez.deshndezz_android.Deps.navFrag)
    implementation(com.deshanddez.deshndezz_android.Deps.kotlinxCourotines)
    implementation(com.deshanddez.deshndezz_android.Deps.hiltAndroid)
    kapt(com.deshanddez.deshndezz_android.Deps.hiltCompiler)
    implementation(project(":data"))

}

kapt {
    correctErrorTypes = true
}
