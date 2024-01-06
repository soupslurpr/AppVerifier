# Contributing

Thanks for your interest in contributing!

If you want to suggest a feature or notify us about a bug, please use the issue tracker.

If you want to contribute to the internal verification info database,
the simplest way is to create an issue on GitHub with the verification info obtained from AppVerifier for that app. If you want to make it easier for reviewers and contribute
it in the form of code with hashes for all the available sources, please see
app/src/main/kotlin/dev/soupslurpr/appverifier/InternalVerificationInfoDatabase.kt for the database and use AppVerifier to get the verification info. Other tools may not provide all the needed info or hashes.

If you need help with development or have questions it's recommended to join the AppVerifier room on matrix at
https://matrix.to/#/#appverifier:matrix.org and ask for help there from [soupslurpr](https://github.com/soupslurpr),
the lead developer.

Java code is not accepted, we will only use Kotlin and Rust if needed (this project is currently 100% Rust free).

Views should be avoided at all costs and only Jetpack Compose should be used unless there is no other way, but it
has to be very important (unlikely).
