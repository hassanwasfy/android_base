plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id ("kotlinx-serialization")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.lock.data"
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

    implementation(com.deshanddez.deshndezz_android.Deps.serialization)
    implementation(com.deshanddez.deshndezz_android.Deps.kotlinxCourotines)
    implementation(com.deshanddez.deshndezz_android.Deps.roomKtx)
    implementation(com.deshanddez.deshndezz_android.Deps.kotlinStd)
    implementation(com.deshanddez.deshndezz_android.Deps.roomCompiler)
    implementation(com.deshanddez.deshndezz_android.Deps.roomPaging)
    implementation(com.deshanddez.deshndezz_android.Deps.roomCompilerKapt)
    implementation(com.deshanddez.deshndezz_android.Deps.okhttp3Logging)
    implementation(com.deshanddez.deshndezz_android.Deps.okhttp3)
    implementation(com.deshanddez.deshndezz_android.Deps.retrofit)
    implementation(com.deshanddez.deshndezz_android.Deps.retrofitConvertoer)
    implementation(com.deshanddez.deshndezz_android.Deps.hiltAndroid)
    implementation(com.deshanddez.deshndezz_android.Deps.hiltWork)
    kapt(com.deshanddez.deshndezz_android.Deps.hiltCompiler)

//    implementation(project(":utils"))

}

kapt {
    correctErrorTypes = true
}