import com.deshanddez.deshndezz_android.Deps
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.deshanddez.deshndezz_android"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.deshanddez.deshndezz_android"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.constraintXml)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    androidTestImplementation(Deps.espresso)

    implementation(Deps.navFrag)
    implementation(Deps.navUi)
    implementation(Deps.navDynamic)


    implementation(Deps.sdb)
    implementation(Deps.ssp)
    implementation(Deps.glide)
    implementation(Deps.materialrey)
    implementation(Deps.dexter)

    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)


    implementation(project(":utils"))
}

kapt {
    correctErrorTypes = true
}
