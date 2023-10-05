// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.47")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath ("com.android.tools.build:gradle:4.2.2")

    }
    repositories {
        google()
        mavenCentral()

    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    kotlin("kapt") version "1.9.10"
    id("com.android.library") version "8.1.1" apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"

}