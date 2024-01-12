# Contributing

Thanks for your interest in contributing!

If you want to suggest a feature or notify us about a bug, please use the issue tracker.

If you want to contribute to the internal verification info database, you currently must contribute in code form.
You can use IntelliJ IDEA Community edition, which is what the lead developer, soupslurpr uses.
It is available at https://www.jetbrains.com/idea/download/?section=windows#:~:text=free%20to%20use-,IntelliJ%20IDEA%20Community%20Edition,-The%20IDE%20for

Open the file at app/src/main/kotlin/dev/soupslurpr/appverifier/InternalVerificationInfoDatabase.kt for the database and start adding entries from the bottom. 
Use AppVerifier (with "Show hasMultipleSigners" on in Settings) to get the verification info.
Other tools may not provide all the needed info or hashes so do not use them.
You must check the app's website or repo to see which sources they say the app is officially available from (view INTERNAL_DATABASE_CRITERIA.md),
and check the verification info of each source to see if it's the same. If the package name is
the same but not the hashes, then you have to make a `Hashes` in the same `InternalDatabaseVerificationInfo` with the hashes for the app from that source and whether it has multiple signers.
If the package name is different, then create another `InternalDatabaseVerificationInfo`.
Above the `Hashes` put a comment that says the source where the app was obtained from.
Please look at the other entries in the database for examples of this.

If you need help with development or have questions it's recommended to join the AppVerifier room on matrix at
https://matrix.to/#/#appverifier:matrix.org and ask for help there from [soupslurpr](https://github.com/soupslurpr),
the lead developer.

Java code is not accepted, we will only use Kotlin and Rust if needed (this project is currently 100% Rust free).

Views should be avoided at all costs and only Jetpack Compose should be used unless there is no other way, but it
has to be very important (unlikely).
