plugins {
    val agpVersion = "8.5.0"
    id("com.android.application") version agpVersion apply false
    id("com.android.test") version agpVersion apply false

    id("org.jetbrains.kotlin.android") version "2.0.0" apply false

    // Using an older version because of problems with certain characters in a profile path
    // https://issuetracker.google.com/issues/371642809
    id("androidx.baselineprofile") version "1.2.4" apply false
}
