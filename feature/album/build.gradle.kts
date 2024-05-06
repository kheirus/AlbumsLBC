plugins {
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.android.library)
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.kdroid_consulting.feature.album"
    compileSdk = 34
}

dependencies {
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}