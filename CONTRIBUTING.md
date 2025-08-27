# Contributing

Thanks for your interest in contributing!

If you want to suggest a feature or notify us about a bug, please use the issue tracker.

Before working on a feature, please make sure to discuss the planned implementation in the issue for
the feature and get approval from @soupslurpr to ensure it meets the project's requirements.

Contribution of new apps to the internal verification info database won't be accepted at this time.
If an app that is already in the database is failing to verify, please notify us by making a new issue (check existing issues first).

Translations won't be accepted at this time.

If you need help with development or have questions it's recommended to join the AppVerifier room on Matrix at
https://matrix.to/#/#appverifier:matrix.org and ask for help there from [soupslurpr](https://github.com/soupslurpr),
the lead developer.

Java code is not accepted, we will only use Kotlin and Rust if needed (this project is currently 100% Rust free).

Views should be avoided at all costs and only Jetpack Compose should be used unless there is no other way, but it
has to be very important (unlikely).
