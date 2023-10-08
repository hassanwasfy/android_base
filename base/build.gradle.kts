import com.deshanddez.deshndezz_android.Deps

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.deshanddezz.base"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.constraintXml)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    androidTestImplementation(Deps.espresso)

    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
}

kapt {
    correctErrorTypes = true
}