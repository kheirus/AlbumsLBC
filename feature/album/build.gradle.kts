plugins {
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.kdroid_consulting.feature.album"
    compileSdk = 34
}

dependencies {

    testImplementation("org.testng:testng:6.9.6")
}