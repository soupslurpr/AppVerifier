package dev.soupslurpr.appverifier.data

import android.graphics.drawable.Drawable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class VerifyAppUiState(
    val name: MutableState<String> = mutableStateOf(""),
    val packageName: MutableState<String> = mutableStateOf(""),
    val hash: MutableState<String> = mutableStateOf(""),
    val icon: MutableState<Drawable?> = mutableStateOf(null),
    val verificationStatus: MutableState<VerificationStatus> = mutableStateOf(VerificationStatus.UNKNOWN),
    val appNotFound: MutableState<Boolean> = mutableStateOf(false),
    val invalidFormat: MutableState<Boolean> = mutableStateOf(false),
    val internalDatabaseStatus: MutableState<InternalDatabaseStatus> = mutableStateOf(InternalDatabaseStatus.NOT_FOUND)
)

enum class InternalDatabaseStatus(val info: String, val simpleInternalDatabaseStatus: SimpleInternalDatabaseStatus) {
    NOT_FOUND(
        "This app was not found in the internal database. This isn't anything to worry about, but please verify the " +
                "app normally.",
        SimpleInternalDatabaseStatus.NOT_FOUND,
    ),
    MATCH(
        "This app's verification info matches an entry in the internal database. You don't need to verify normally.",
        SimpleInternalDatabaseStatus.SUCCESS,
    ),
    NOMATCH(
        "This app was found in the internal database, but its hash did NOT match. This app may be " +
                "non-genuine.",
        SimpleInternalDatabaseStatus.FAILURE,
    ),
}

enum class SimpleInternalDatabaseStatus(val color: Color) {
    NOT_FOUND(Color.Gray),
    SUCCESS(Color.Green),
    FAILURE(Color.Red)
}

data class VerificationInfo(val packageName: String, val hashes: Set<String>)

enum class SimpleVerificationStatus(val color: Color) {
    UNKNOWN(Color.Gray),
    SUCCESS(Color.Green),
    WARNING(Color.Red.copy(red = 161f / 256f, green = 102f / 256f, blue = 14f / 256f)),
    FAILURE(Color.Red)
}

enum class VerificationStatus(val info: String, val simpleVerificationStatus: SimpleVerificationStatus) {
    UNKNOWN(
        "Since you haven't provided any verification information, I'm unable to determine the verification status",
        SimpleVerificationStatus.UNKNOWN,
    ),
    MATCH(
        "Both the package name and signing certificate hash match with the expected values",
        SimpleVerificationStatus.SUCCESS,
    ),
    NOMATCH(
        "Both the package name and the signing certificate hash DO NOT match with the expected values. Please make " +
                "sure you are verifying the correct app and check the formatting.",
        SimpleVerificationStatus.FAILURE,
    ),
    PKG_NOT_GIVEN_BUT_SIG_HASH_MATCH(
        "The package name was not given but the signing certificate hash matches",
        SimpleVerificationStatus.SUCCESS,
    ),
    PKG_MATCH_BUT_SIG_HASH_NOT_GIVEN(
        "The package name matched with the expected value but the signing certificate hash was not given",
        SimpleVerificationStatus.FAILURE,
    ),
    PKG_MATCH_BUT_SIG_HASH_CONTAINS(
        "The package name matched with the expected value but the signing certificate hash is included with other " +
                "text in the given text. Please make sure you are verifying the correct app and check the formatting.",
        SimpleVerificationStatus.WARNING,
    ),
    PKG_MATCH_BUT_SIG_HASH_NOMATCH(
        "The package name matches but the signing certificate hash DOES NOT match. Be wary, the application might " +
                "be non-genuine.",
        SimpleVerificationStatus.FAILURE
    ),
    PKG_CONTAINS_AND_SIG_HASH_CONTAINS(
        "Both the package name and signing certificate hash is only contained in the " +
                "given text. Please make sure you are verifying the correct app and check the formatting.",
        SimpleVerificationStatus.WARNING,
    ),
    PKG_CONTAINS_BUT_SIG_HASH_MATCH(
        "The package name is contained in the given text, and the signing certificate " +
                "hash matches. Please make sure you are verifying the correct app and check the formatting.",
        SimpleVerificationStatus.WARNING,
    ),
    PKG_CONTAINS_BUT_SIG_HASH_NOMATCH(
        "The package name is contained in the given text, but the signing certificate " +
                "hash DOES NOT match. Please make sure you are verifying the correct app and check the formatting.",
        SimpleVerificationStatus.FAILURE,
    ),
    PKG_NOMATCH_BUT_SIG_HASH_CONTAINS(
        "The package name does not match but the signing " +
                "certificate hash is included with other text in the given text. Please make sure you are verifying the " +
                "correct app and check the formatting.",
        SimpleVerificationStatus.WARNING,
    ),
    PKG_NOMATCH_BUT_SIG_HASH_MATCH(
        "The package name does not match but the signing certificate hash matches. Please make sure you are verifying" +
                " the correct app.",
        SimpleVerificationStatus.WARNING,
    ),
}