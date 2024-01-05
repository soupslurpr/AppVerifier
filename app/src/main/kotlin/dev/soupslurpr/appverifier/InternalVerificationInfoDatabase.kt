package dev.soupslurpr.appverifier

import dev.soupslurpr.appverifier.data.Hashes

/**
 * The package name is the app's package name.
 * The hashesList is a list of Hashes, which itself contains a list of hashes.
 * There should be one Hashes for each signing configuration an app has.
 * Above the Hashes there should be a comment saying where it is from.
 * For example, if those Hashes are from GitHub and the Google Play Store,
 * then the comment would be // GitHub/Google Play Store.
 * If for example the Google Play Store one has different hashes then it gets its own Hashes
 * and comment of // Google Play Store.
 */
data class InternalDatabaseVerificationInfo(val packageName: String, val hashesList: List<Hashes>)

/**
 * The internal verification info database.
 */
val internalVerificationInfoDatabase = setOf(
    InternalDatabaseVerificationInfo(
        "dev.soupslurpr.beautyxt",
        listOf(
            // GitHub/Accrescent
            Hashes(
                listOf(
                    "00:03:01:CC:29:1B:B9:9B:5E:BC:13:BE:89:F0:8C:46:03:80:71:27:B5:5E:21:AA:1E:69:8B:1D:E6:B8:43:46"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "org.thoughtcrime.securesms",
        listOf(
            // Website/Google Play Store
            Hashes(
                listOf(
                    "29:F3:4E:5F:27:F2:11:B4:24:BC:5B:F9:D6:71:62:C0:EA:FB:A2:DA:35:AF:35:C1:64:16:FC:44:62:76:BA:26"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "app.accrescent.client",
        listOf(
            // Website/GitHub
            Hashes(
                listOf(
                    "06:7A:40:C4:19:3A:AD:51:AC:87:F9:DD:FD:EB:B1:5E:24:A1:85:0B:AB:FA:48:21:C2:8C:5C:25:C3:FD:C0:71"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "app.accrescent.client",
        listOf(
            // Website/GitHub
            Hashes(
                listOf(
                    "06:7A:40:C4:19:3A:AD:51:AC:87:F9:DD:FD:EB:B1:5E:24:A1:85:0B:AB:FA:48:21:C2:8C:5C:25:C3:FD:C0:71"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "net.mullvad.mullvadvpn",
        listOf(
            // Website/GitHub
            Hashes(
                listOf(
                    "7B:E2:19:30:C3:B4:D7:39:06:B0:89:30:45:0A:1D:3A:FB:D2:2C:98:D9:D8:E9:87:DF:8C:1F:BC:2D:0C:90:BB",
                ),
                false
            ),
            // Google Play Store
            Hashes(
                listOf(
                    "D7:4C:E0:E0:B2:9F:4D:1D:57:AB:F5:EF:7F:9A:37:57:E7:87:CC:A7:A6:25:9B:9C:32:BB:5B:B1:8E:34:63:BD",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "E1:B6:6A:F1:AC:48:69:A3:3B:09:1F:81:DC:BD:57:7B:F8:DC:FE:91:25:DD:DE:33:81:BF:FF:91:81:33:31:EC",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.dominospizza",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "97:59:E1:5B:C7:AD:25:FB:A0:5D:43:36:16:E5:1C:E5:04:09:2E:F0:4F:63:C3:61:36:5C:FD:FE:DA:DD:3B:FC"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.google.android.GoogleCamera",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "F0:FD:6C:5B:41:0F:25:CB:25:C3:B5:33:46:C8:97:2F:AE:30:F8:EE:74:11:DF:91:04:80:AD:6B:2D:60:DB:83"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.google.android.inputmethod.latin",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "F0:FD:6C:5B:41:0F:25:CB:25:C3:B5:33:46:C8:97:2F:AE:30:F8:EE:74:11:DF:91:04:80:AD:6B:2D:60:DB:83",
                    "7C:E8:3C:1B:71:F3:D5:72:FE:D0:4C:8D:40:C5:CB:10:FF:75:E6:D8:7D:9D:F6:FB:D5:3F:04:68:C2:90:50:53"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.einnovation.temu",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "8A:DE:FE:CE:37:49:DC:F2:3C:3C:EB:3A:8B:BB:C9:A1:D8:80:91:B6:76:30:05:88:91:1B:B5:8B:85:97:0B:AF"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.zhiliaoapp.musically",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "90:41:80:3E:91:BC:B8:14:B4:B4:39:9F:B5:C8:5A:91:64:0B:75:5E:5E:8B:A7:68:13:81:4B:F4:CF:2A:B5:BA"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.whatsapp",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "39:87:D0:43:D1:0A:EF:AF:5A:87:10:B3:67:14:18:FE:57:E0:E1:9B:65:3C:9D:F8:25:58:FE:B5:FF:CE:5D:44"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.squareup.cash",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "21:A7:46:75:96:C1:68:65:0F:D7:B6:31:B6:54:22:EB:56:3E:1D:21:AF:F2:2D:DE:73:89:BA:0D:5D:73:87:48"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "im.molly.app",
        listOf(
            // GitHub/F-Droid
            Hashes(
                listOf(
                    "6A:A8:0F:DF:4A:8C:C1:37:37:CF:B4:34:FC:0C:DE:48:6F:09:CF:8F:CD:A2:1A:67:BE:A5:EE:1C:A2:70:08:86"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "org.oxycblt.auxio",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "DA:84:E2:53:4C:1A:CC:0B:6E:4F:57:DE:DB:64:0D:4D:C8:93:F5:BF:41:37:A2:E1:EC:BA:87:AD:F8:25:BA:44",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "65:B3:E6:2A:2B:57:BF:73:23:5B:E6:D2:D4:2A:E5:46:FC:B0:2F:D1:7F:62:CD:14:50:0D:1C:41:2A:28:59:72"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "ch.protonvpn.android",
        listOf(
            // Website/GitHub/Google Play Store
            Hashes(
                listOf(
                    "DC:C9:43:9E:C1:A6:C6:A8:D0:20:3F:34:23:EE:42:BC:C8:B9:70:62:8E:53:CB:73:A0:39:3F:39:8D:D5:B8:53",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "95:0E:E2:D4:D0:A4:3F:FB:A7:EE:1D:A9:54:1C:4A:13:DE:FE:81:EB:69:7B:A7:D2:4C:17:F6:F8:86:E3:21:24"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "ch.protonmail.android",
        listOf(
            // Website/GitHub/Google Play Store
            Hashes(
                listOf(
                    "DC:C9:43:9E:C1:A6:C6:A8:D0:20:3F:34:23:EE:42:BC:C8:B9:70:62:8E:53:CB:73:A0:39:3F:39:8D:D5:B8:53",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "me.proton.android.drive",
        listOf(
            // Website/GitHub/Google Play Store
            Hashes(
                listOf(
                    "DC:C9:43:9E:C1:A6:C6:A8:D0:20:3F:34:23:EE:42:BC:C8:B9:70:62:8E:53:CB:73:A0:39:3F:39:8D:D5:B8:53",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "proton.android.pass",
        listOf(
            // Website/GitHub/Google Play Store
            Hashes(
                listOf(
                    "DC:C9:43:9E:C1:A6:C6:A8:D0:20:3F:34:23:EE:42:BC:C8:B9:70:62:8E:53:CB:73:A0:39:3F:39:8D:D5:B8:53",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "me.proton.android.calendar",
        listOf(
            // Website/GitHub/Google Play Store
            Hashes(
                listOf(
                    "DC:C9:43:9E:C1:A6:C6:A8:D0:20:3F:34:23:EE:42:BC:C8:B9:70:62:8E:53:CB:73:A0:39:3F:39:8D:D5:B8:53",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.x8bit.bitwarden",
        listOf(
            // GitHub/Google Play Store
            Hashes(
                listOf(
                    "24:E0:6C:04:C2:08:04:8F:19:F1:C9:93:B4:DD:A4:43:0E:A8:B0:6D:B8:37:5E:A0:E3:7B:83:46:96:B9:AC:3A",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "DE:6E:C9:14:31:55:79:95:29:7B:F3:E6:5B:C8:03:49:BC:60:3A:04:70:81:60:61:8C:86:BC:99:94:17:1C:90"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.github.lamarios.clipious",
        listOf(
            // GitHub/Accrescent
            Hashes(
                listOf(
                    "19:DE:04:E5:D6:84:66:06:9D:30:EC:63:C6:BA:7D:9E:3C:F7:3B:5D:61:CB:4B:37:62:C2:B9:B2:53:EC:BD:03"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.beemdevelopment.aegis",
        listOf(
            // GitHub/Google Play Store
            Hashes(
                listOf(
                    "C6:DB:80:A8:E1:4E:52:30:C1:DE:84:15:EF:82:0D:13:DC:90:1D:8F:E3:3C:F3:AC:B5:7B:68:62:D8:58:A8:23",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "09:CF:DE:62:E2:A8:1C:80:50:D3:BE:4C:20:E3:F8:D8:DD:D0:15:31:BE:1B:47:CB:3B:0E:EC:21:3F:64:1F:89"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "dev.imranr.obtainium",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "B3:53:60:1F:6A:1D:5F:D6:60:3A:E2:F5:0B:E8:0C:F3:01:36:7B:86:B6:AB:8B:1F:66:24:3D:A9:6C:D5:73:62",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "cloud.pablos.overload",
        listOf(
            // Codeberg/Google Play Store/F-Droid
            Hashes(
                listOf(
                    "BD:39:CA:B0:CB:22:4D:4A:E0:97:95:11:F3:24:1E:D8:85:8D:1A:F8:69:37:B7:C6:39:7B:E4:BA:7E:C1:A2:B4"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.google.android.apps.maps",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "F0:FD:6C:5B:41:0F:25:CB:25:C3:B5:33:46:C8:97:2F:AE:30:F8:EE:74:11:DF:91:04:80:AD:6B:2D:60:DB:83",
                    "7C:E8:3C:1B:71:F3:D5:72:FE:D0:4C:8D:40:C5:CB:10:FF:75:E6:D8:7D:9D:F6:FB:D5:3F:04:68:C2:90:50:53"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.google.android.youtube",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "3D:7A:12:23:01:9A:A3:9D:9E:A0:E3:43:6A:B7:C0:89:6B:FB:4F:B6:79:F4:DE:5F:E7:C2:3F:32:6C:8F:99:4A",
                    "5A:AD:2B:EE:6D:B9:5D:17:E0:5A:08:D7:D1:E6:4C:10:A1:51:18:79:15:44:83:91:6B:6A:E6:C7:FD:9C:B0:C6",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "eu.faircode.email",
        listOf(
            // GitHub/Google Play Store
            Hashes(
                listOf(
                    "E0:20:67:24:9F:5A:35:0E:0E:C7:03:FE:9D:F4:DD:68:2E:02:91:A0:9F:0C:2E:04:10:50:BB:E7:C0:64:F5:C9",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "B9:D0:41:58:2A:F4:6E:E3:9B:BA:0F:2F:18:29:D9:48:AE:21:EC:F7:FF:A6:BA:12:03:85:D2:45:EB:B7:88:AE",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "org.localsend.localsend_app",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "BB:3E:E2:82:39:B1:41:8A:F1:6D:DC:64:7D:5A:94:8A:57:3C:2D:13:6D:2B:74:BC:E4:7E:9D:8E:23:35:30:4E",
                ),
                false
            ),
            // F-Droid/GitHub
            Hashes(
                listOf(
                    "32:20:C3:53:A7:3C:FB:D0:C2:F3:05:24:71:C4:45:32:4C:F4:52:BC:BA:26:DE:1C:47:3A:52:FE:5C:44:E1:D6",
                ),
                false
            )
        ),
    ),
    InternalDatabaseVerificationInfo(
        "de.tutao.tutanota",
        listOf(
            // Google Play Store/GitHub
            Hashes(
                listOf(
                    "B4:54:C1:76:F9:0A:1E:A0:57:29:87:D3:82:72:3B:5C:D7:4F:94:2A:79:37:A2:A0:B9:9A:36:80:69:14:88:50",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "FC:19:32:E0:84:64:AE:FC:AE:82:59:7D:C0:FC:9D:04:C0:8B:24:AA:09:D1:F9:50:DF:20:EA:81:23:4F:30:CB",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.google.android.markup",
        listOf(
            // Pixel OS
            Hashes(
                listOf(
                    "BA:83:57:40:B0:89:8D:BB:0F:FD:CB:00:F5:3F:9C:90:D3:19:4B:64:C3:9A:55:88:47:8F:9A:1A:AD:79:14:4F",
                ),
                false
            )
        )
    ),
)
