plugins {
    val agpVersion = "8.5.0"
    id("com.android.application") version agpVersion apply false
    id("com.android.test") version agpVersion apply false

    id("org.jetbrains.kotlin.android") version "2.0.0" apply false

    id("androidx.baselineprofile") version "1.3.3" apply false
}
