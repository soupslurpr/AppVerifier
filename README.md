# AppVerifier

AppVerifier is an app signing certificate hash viewer and verifier.\
It enables you to easily verify that your apps are genuine with others!

AppVerifier takes the app's package name and signing certificates hash(es) and compares them to the ones you provided or the ones in the internal database to verify that your apps are genuine.\
You can simply share the verification info to others and receive verification info from them and
share the received verification info to AppVerifier and you will see the verification status.\
AppVerifier does the heavy lifting for you 💪

## Download

AppVerifier is available on the [Accrescent](https://accrescent.app) app store and GitHub releases. [Accrescent](https://accrescent.app) is the recommended way to get AppVerifier as it is more secure than GitHub releases.\
Click on the badge below to get it on [Accrescent](https://accrescent.app).

<a href="https://accrescent.app/app/dev.soupslurpr.appverifier">
                            <img alt="Get it on Accrescent" src="https://accrescent.app/badges/get-it-on.png">
                        </a>
                        
The package name and SHA-256 hash of the signing certificate is below, so you can verify AppVerifier with [`apksigner`](https://developer.android.com/studio/command-line/apksigner#usage-verify) using `apksigner verify --print-certs AppVerifier-X.Y.Z.apk` if you are downloading the APK. If you are downloading from [Accrescent](https://accrescent.app) then you should verify [Accrescent](https://accrescent.app) itself [here](https://accrescent.app/faq#verifying).

DO NOT use AppVerifier to verify itself!\
Also DO NOT use AppVerifier to verify Accrescent if you downloaded AppVerifier from it.

dev.soupslurpr.appverifier\
3A:04:A8:0B:2A:88:33:4C:74:74:85:F0:B2:15:16:40:A3:8B:B3:D2:D7:3A:8E:AB:81:DF:50:3E:0F:02:02:B2


It can also be found on a [Bluesky post](https://bsky.app/profile/soupslurpr.dev/post/3khnczlribj2i) to distrust the website. It is encouraged to verify it's the same with other people as well for assurance.

## Community

Join the Matrix space at https://matrix.to/#/#appverifier-space:matrix.org for the Discussion, Announcements, and Beta Testing rooms.

## Contributing

Check [CONTRIBUTING.md](https://github.com/soupslurpr/AppVerifier/blob/master/CONTRIBUTING.md) for things to know
if you want to contribute.

## Donation

A fan of AppVerifier? You can donate to [soupslurpr](https://github.com/soupslurpr), the lead developer of AppVerifier to support their work on AppVerifier and their other open source projects. Thank you!

[Monero](https://www.getmonero.org/) address:\
`88rAaNowhaC8JG8NJDpcdRWr1gGVmtFPnHWPS9xXvqY44G4XKVi5hZMax2FQ6B8KAcMpzkeJAhNek8qMHZjjwvkEKuiyBKF`

The [Monero](https://www.getmonero.org/) address can also be found in the app's settings.
