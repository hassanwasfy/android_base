plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.lock.utils"
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
}

dependencies {

    implementation(com.deshanddez.deshndezz_android.Deps.coreKtx)
    implementation(com.deshanddez.deshndezz_android.Deps.appCompat)
    implementation(com.deshanddez.deshndezz_android.Deps.material)
    implementation(com.deshanddez.deshndezz_android.Deps.constraintXml)
    testImplementation(com.deshanddez.deshndezz_android.Deps.junit)
    androidTestImplementation(com.deshanddez.deshndezz_android.Deps.junitExt)
    androidTestImplementation(com.deshanddez.deshndezz_android.Deps.espresso)
    implementation(com.deshanddez.deshndezz_android.Deps.gmsAuth)
    implementation(com.deshanddez.deshndezz_android.Deps.phoneNum)
    implementation(com.deshanddez.deshndezz_android.Deps.glide)
    implementation(com.deshanddez.deshndezz_android.Deps.retrofit)
    implementation(com.deshanddez.deshndezz_android.Deps.retrofitConvertoer)
    implementation(com.deshanddez.deshndezz_android.Deps.okhttp3)
    implementation(com.deshanddez.deshndezz_android.Deps.okhttp3Logging)
}