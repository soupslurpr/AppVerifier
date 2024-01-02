package dev.soupslurpr.appverifier.ui

import android.app.Application
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.lifecycle.AndroidViewModel
import dev.soupslurpr.appverifier.data.InternalDatabaseStatus
import dev.soupslurpr.appverifier.data.VerificationInfo
import dev.soupslurpr.appverifier.data.VerificationStatus
import dev.soupslurpr.appverifier.data.VerifyAppUiState
import dev.soupslurpr.appverifier.internalVerificationInfoDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.security.MessageDigest

class VerifyAppViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * App verification info
     */
    private val _uiState = MutableStateFlow(VerifyAppUiState())
    val uiState: StateFlow<VerifyAppUiState> = _uiState.asStateFlow()

    fun setAppVerificationInfo(
        name: String,
        packageName: String,
        hash: String,
        internalDatabaseStatus: InternalDatabaseStatus
    ) {
        _uiState.value.name.value = name
        _uiState.value.packageName.value = packageName
        _uiState.value.hash.value = hash
        _uiState.value.internalDatabaseStatus.value = internalDatabaseStatus
    }

    fun setAppIcon(icon: Drawable) {
        _uiState.value.icon.value = icon
    }

    fun verifyFromText(text: String) {
        _uiState.value.verificationStatus.value = parseTextToVerificationStatus(text)
    }

    private fun parseTextToVerificationStatus(text: String): VerificationStatus {
        val trimmedText = text.trim()
        val lines = trimmedText.lines()

        return if (lines.size == 1) {
            val line0 = lines[0].trim()

            if (lines[0].contains(' ') && (lines[0].trim('"').split(' ').size == 2)) {
                val split = lines[0].trim('"').split(' ')
                val packageName = split[0].trim()
                val hash = split[1].trim()

                parseTextToVerificationStatus("$packageName\n$hash")
            } else if (line0 == uiState.value.packageName.value) {
                VerificationStatus.PKG_MATCH_BUT_SIG_HASH_NOT_GIVEN
            } else if ((lines[0].trim() == uiState.value.hash.value) || (lines[0].trim().iterator().run {
                    var convertedHash = ""
                    this.withIndex().forEach {
                        convertedHash += it.value
                        if (it.index % 2 != 0 && (it.index != lines[0].trim().length.dec())) {
                            convertedHash += ":"
                        }
                    }
                    return@run convertedHash.uppercase() == uiState.value.hash.value
                })) {
                VerificationStatus.PKG_NOT_GIVEN_BUT_SIG_HASH_MATCH
            } else if (
                (lines[0].trim().contains(uiState.value.packageName.value))
                && (lines[0].trim().contains(uiState.value.hash.value))
            ) {
                VerificationStatus.PKG_CONTAINS_AND_SIG_HASH_CONTAINS
            } else {
                VerificationStatus.NOMATCH
            }
        } else if (lines.size == 2) {
            val isLine0EqualToPackageName = lines[0].trim() == uiState.value.packageName.value
            val isLine1EqualToSigHash = lines[1].trim() == uiState.value.hash.value
            val isLine0ContainPackageName = lines[0].trim().contains(uiState.value.packageName.value)
            val isLine1ContainSigHash = lines[1].trim().contains(uiState.value.hash.value)

            if ((lines[0].trim() + ":" + lines[1].trim()) == uiState.value.hash.value) {
                VerificationStatus.PKG_NOT_GIVEN_BUT_SIG_HASH_MATCH
            } else if (isLine0EqualToPackageName && isLine1EqualToSigHash) {
                VerificationStatus.MATCH
            } else if (isLine0EqualToPackageName && isLine1ContainSigHash) {
                VerificationStatus.PKG_MATCH_BUT_SIG_HASH_CONTAINS
            } else if ((!isLine0EqualToPackageName && isLine0ContainPackageName) && isLine1EqualToSigHash) {
                VerificationStatus.PKG_CONTAINS_BUT_SIG_HASH_MATCH
            } else if ((isLine0ContainPackageName) && (isLine1ContainSigHash)) {
                VerificationStatus.PKG_CONTAINS_AND_SIG_HASH_CONTAINS
            } else if ((!trimmedText.contains(uiState.value.packageName.value)
                        && isLine1EqualToSigHash)
            ) {
                VerificationStatus.PKG_NOMATCH_BUT_SIG_HASH_MATCH
            } else if (!trimmedText.contains(uiState.value.packageName.value)
                && trimmedText.contains(uiState.value.hash.value)
            ) {
                VerificationStatus.PKG_NOMATCH_BUT_SIG_HASH_CONTAINS
            } else if (isLine0EqualToPackageName && !trimmedText.contains(uiState.value.hash.value)) {
                VerificationStatus.PKG_MATCH_BUT_SIG_HASH_NOMATCH
            } else if (trimmedText.contains(uiState.value.packageName.value)
                && !trimmedText.contains(uiState.value.hash.value)
            ) {
                VerificationStatus.PKG_CONTAINS_BUT_SIG_HASH_NOMATCH
            } else {
                VerificationStatus.NOMATCH
            }
        } else {
            if ((trimmedText.contains(uiState.value.packageName.value))
                && (trimmedText.contains(uiState.value.hash.value))
            ) {
                VerificationStatus.PKG_CONTAINS_AND_SIG_HASH_CONTAINS
            } else if ((!trimmedText.contains(uiState.value.packageName.value))
                && (trimmedText.contains(uiState.value.hash.value))
            ) {
                VerificationStatus.PKG_NOMATCH_BUT_SIG_HASH_CONTAINS
            } else if ((trimmedText.contains(uiState.value.packageName.value))
                && (!trimmedText.contains(uiState.value.hash.value))
            ) {
                VerificationStatus.PKG_CONTAINS_BUT_SIG_HASH_NOMATCH
            } else {
                VerificationStatus.NOMATCH
            }
        }
    }

    fun getHashHexFromPackageInfo(packageInfo: PackageInfo): String {
        val signingInfo = packageInfo.signingInfo
        val signatures = if (signingInfo.hasMultipleSigners()) {
            signingInfo.apkContentsSigners
        } else {
            signingInfo.signingCertificateHistory
        }

        val firstCertificate = signatures.first().toByteArray()

        val digest = MessageDigest.getInstance("SHA-256")
        val hashByteArray = digest.digest(firstCertificate)

        return hashByteArray.joinToString(":") { "%02x".format(it) }.uppercase()
    }

    fun findAndSetAppVerificationInfoFromPackageName(packageName: String, packageManager: PackageManager) {
        val systemPackages = packageManager.getInstalledPackages(PackageManager.MATCH_SYSTEM_ONLY)

        val userInstalledPackages = packageManager.getInstalledPackages(0)

        userInstalledPackages.removeIf { userInstalledPackage ->
            userInstalledPackage.packageName == systemPackages.firstOrNull {
                it.packageName == userInstalledPackage.packageName
            }?.packageName
        }

        userInstalledPackages.find { packageInfo: PackageInfo? -> packageInfo?.packageName == packageName }.run {
            if (this != null) {
                val packageInfo =
                    packageManager.getPackageInfo(this.packageName, PackageManager.GET_SIGNING_CERTIFICATES)

                val hashHex = getHashHexFromPackageInfo(packageInfo)

                setAppVerificationInfo(
                    packageManager.getApplicationLabel(packageInfo.applicationInfo).toString(),
                    packageInfo.packageName,
                    hashHex,
                    getInternalDatabaseStatusFromVerificationInfo(VerificationInfo(packageName, setOf(hashHex)))
                )
                setAppIcon(packageManager.getApplicationIcon(packageInfo.applicationInfo))
            } else {
                setAppNotFound(true)
            }
        }
    }

    fun setAppNotFound(b: Boolean) {
        _uiState.value.appNotFound.value = b
    }

    fun setInvalidFormat(b: Boolean) {
        _uiState.value.invalidFormat.value = b
    }

    fun getInternalDatabaseStatusFromVerificationInfo(verificationInfo: VerificationInfo): InternalDatabaseStatus {
        return internalVerificationInfoDatabase.run {
            return@run try {
                val matchedPackageNameVerificationInfo = this.first {
                    it.packageName == verificationInfo.packageName
                }

                return@run try {
                    if (verificationInfo.hashes.first {
                            matchedPackageNameVerificationInfo.hashes.contains(it)
                        }.isNotEmpty()) {
                        InternalDatabaseStatus.MATCH
                    } else {
                        InternalDatabaseStatus.NOMATCH
                    }
                } catch (e: NoSuchElementException) {
                    InternalDatabaseStatus.NOMATCH
                }
            } catch (e: NoSuchElementException) {
                InternalDatabaseStatus.NOT_FOUND
            }
        }
    }

    fun clearUiState() {
        _uiState.value = VerifyAppUiState()
    }
}