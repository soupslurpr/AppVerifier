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
            // Google Play Store
            Hashes(
                listOf(
                    "BA:83:57:40:B0:89:8D:BB:0F:FD:CB:00:F5:3F:9C:90:D3:19:4B:64:C3:9A:55:88:47:8F:9A:1A:AD:79:14:4F",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "org.futo.voiceinput",
        listOf(
            // Website
            Hashes(
                listOf(
                    "74:3F:AD:58:64:AB:C4:26:50:0B:2D:C2:C4:7C:8A:D3:24:CB:CD:16:03:3F:80:16:99:48:41:35:63:74:F9:95",
                ),
                false
            ),
            // Google Play Store
            Hashes(
                listOf(
                    "0F:C8:4A:BB:FB:37:10:88:2E:0D:32:98:35:E7:B3:C1:6B:2D:B8:36:88:2C:94:D3:B2:B8:A0:BC:5B:84:A9:43"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "io.github.divverent.aaaaxy",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "AA:E0:BE:2A:65:90:40:3E:1A:E3:FD:25:DC:AB:67:8E:73:F8:4A:50:C8:CA:4E:B5:72:7E:BB:B7:F7:6B:83:C2",
                ),
                false
            ),
            // Google Play Store
            Hashes(
                listOf(
                    "F8:D9:23:A7:77:53:B2:93:13:11:25:36:84:69:D9:54:B6:5B:CC:75:C4:BD:C7:FB:8B:BA:30:20:46:1B:57:47",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "3A:03:6C:60:5F:89:04:73:71:B3:0A:78:D9:9F:45:C5:12:48:32:35:26:82:04:8C:72:18:03:B8:9D:EE:1F:C8"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "tech.ula",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "DC:28:10:10:FD:AC:57:C7:C4:D3:9C:74:CB:8C:8B:2F:CC:A9:42:8D:16:4E:43:8F:71:57:B5:E2:06:6C:11:A3",
                ),
                false
            ),
            // Google Play Store
            Hashes(
                listOf(
                    "92:83:2A:E7:79:56:ED:9A:FC:E3:DB:0A:DE:44:AB:88:DD:02:BE:84:DE:9A:F7:C3:3B:94:98:29:EB:EE:4C:74",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "3A:19:DD:7D:23:81:C9:41:4F:70:64:5C:F0:BA:AB:EB:CB:0A:74:3F:1E:EE:07:0D:61:9B:0C:A1:79:73:3F:9F"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "net.gsantner.markor",
        listOf(
            // Google Play Store/GitHub
            Hashes(
                listOf(
                    "57:D1:06:D0:CF:A8:76:34:42:B3:64:5E:F2:74:1C:38:BB:82:0B:D5:6F:D4:61:2B:F4:0A:23:B6:D9:98:BE:5E",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "9C:70:03:32:37:DC:46:FE:50:52:E4:20:C6:65:70:8D:E8:B3:10:5B:89:84:28:43:81:89:81:82:6B:7E:EC:9C"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.android.vending",
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
        "com.brave.browser",
        listOf(
            // Google Play Store/GitHub
            Hashes(
                listOf(
                    "9C:2D:B7:05:13:51:5F:DB:FB:BC:58:5B:3E:DF:3D:71:23:D4:DC:67:C9:4F:FD:30:63:61:C1:D7:9B:BF:18:AC"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "org.dslul.openboard.inputmethod.latin",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "B7:A3:48:D9:01:70:D3:5F:05:6A:A1:C9:9B:49:08:7F:17:52:56:0A:28:AF:67:56:B1:7E:E1:12:C4:CA:1D:89",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "73:54:79:EF:F8:75:F0:F4:2B:F6:12:52:85:89:CA:57:E6:FC:EF:F9:1D:19:6D:C2:23:4F:DE:09:82:63:B8:9C"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.aurora.store",
        listOf(
            // Website/GitLab
            Hashes(
                listOf(
                    "4C:62:61:57:AD:02:BD:A3:40:1A:72:63:55:5F:68:A7:96:63:FC:3E:13:A4:D4:36:9A:12:57:09:41:AA:28:0F",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "5C:83:C7:67:2B:92:99:55:DC:0A:1D:B8:9A:5E:6A:E4:38:9E:2E:AE:7E:C9:39:95:60:41:69:4E:58:15:F5:32"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.aurora.store.nightly",
        listOf(
            // Website
            Hashes(
                listOf(
                    "4C:62:61:57:AD:02:BD:A3:40:1A:72:63:55:5F:68:A7:96:63:FC:3E:13:A4:D4:36:9A:12:57:09:41:AA:28:0F",
                ),
                false
            ),
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.limbo.emu.main.arm",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "E9:48:6A:3C:94:F5:1F:63:97:62:0B:04:AE:41:BD:68:26:DB:B4:D1:11:C4:98:6A:39:63:1A:44:65:C2:18:C2",
                ),
                false
            ),
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.limbo.emu.main",
        listOf(
            // F-Droid
            Hashes(
                listOf(
                    "F7:8B:31:E0:F5:B8:2F:06:0B:44:17:E7:E2:7A:E5:1B:CE:DE:42:77:B6:F2:7A:7F:42:43:EB:74:2C:C5:4A:A2"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.google.android.gms",
        listOf(
            // Google Pixel OS
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
        "com.google.android.gsf",
        listOf(
            // Google Pixel OS
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
        "com.trianguloy.urlchecker",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "F9:A2:D8:D8:94:FA:FE:A1:4C:F6:05:C4:D7:22:AF:D0:49:4D:69:41:1F:60:6A:AA:0B:B1:F2:85:E7:A9:A6:60",
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "93:D7:9B:1E:72:D5:A6:B0:BC:68:11:B9:BC:0A:83:18:1C:35:10:D5:8C:11:57:11:40:FF:3F:8A:63:F2:21:74"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "io.element.android.x",
        listOf(
            // Google Play Store/GitHub
            Hashes(
                listOf(
                    "C6:DB:9B:9C:8C:BD:D6:5D:16:E8:EC:8C:8B:91:C8:31:B9:EF:C9:5C:BF:98:AE:41:F6:A9:D8:35:15:1A:7E:16"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "fr.emersion.goguma",
        listOf(
            // Goguma F-Droid
            Hashes(
                listOf(
                    "2D:39:E6:25:CD:51:45:F5:40:97:50:CD:D1:B6:38:A6:0E:82:67:AE:92:35:BF:36:2B:08:21:2B:DE:2B:A6:25"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "BD:43:1B:EE:F8:37:80:00:75:68:BF:C0:3C:32:EC:96:10:1A:D6:DD:6A:8B:8E:5A:05:24:5E:C4:D9:79:4B:BE"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "fr.emersion.goguma.play",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "CE:58:F4:DA:7C:70:5B:FA:A2:E5:D9:CF:D7:5C:63:07:C9:A6:AE:AA:D0:09:CF:38:97:15:8A:3F:E4:96:30:F6"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.nutomic.syncthingandroid",
        listOf(
            // Google Play Store/GitHub
            Hashes(
                listOf(
                    "03:E7:17:F5:B7:50:C9:AD:44:BC:06:5E:7E:52:50:81:77:6E:73:8B:4F:91:74:F7:D0:55:35:5A:BC:5A:56:4B"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "BA:33:35:6A:09:ED:07:FA:5C:4B:17:68:F7:09:CF:5A:E7:D1:13:FD:B2:E8:93:FC:7A:E2:01:DB:30:0D:45:9D"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.nononsenseapps.feeder",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "C5:EE:FF:22:48:81:35:FF:C2:58:3C:3A:43:B0:53:A1:61:CA:86:98:62:96:1A:B8:53:4F:44:C7:5F:D5:7D:97"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "A8:0D:F8:17:0D:6C:89:1E:C9:A0:55:21:1D:F6:40:A8:55:D4:51:05:23:07:BF:29:CD:CE:3F:EF:9A:FA:94:FD"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.nononsenseapps.feeder.play",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "AC:75:28:54:1E:6F:FC:7D:AD:2C:C7:AA:52:51:12:31:93:C0:09:2C:5B:52:FC:26:62:9D:0F:73:76:81:9D:58"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.github.libretube",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "72:0C:4F:CE:CF:73:8A:41:D0:33:B9:FB:E0:BE:F9:7A:C2:32:03:0C:E9:3E:27:4D:2E:0A:E2:32:E4:4E:EA:CE"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "A8:66:31:E8:CC:55:58:38:E8:DF:C2:90:19:FB:0F:7D:AC:33:3E:F1:CD:A1:13:9C:42:4D:1A:08:D6:8A:03:0B",
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.github.muellerma.coffee",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "90:43:1B:46:5B:44:03:31:14:5C:76:9C:40:D8:72:B0:79:BE:15:40:50:88:22:CD:FC:3A:2A:C3:97:D4:6C:AE"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "70:B1:60:C0:F6:57:4E:BE:9F:FE:B0:F3:AE:93:48:71:41:52:22:4A:BE:7D:DC:48:1C:CB:84:3E:84:F6:99:12"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.unciv.app",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "7D:6E:6B:EA:76:81:61:C3:D8:DA:8B:3F:B0:0D:EF:53:77:EF:FE:65:DC:72:68:48:2F:8F:77:9B:B4:FC:6E:2E"
                ),
                false
            ),
            // Google Play Store
            Hashes(
                listOf(
                    "B9:39:32:67:BA:C3:37:79:49:23:68:EF:24:19:D5:8E:94:C5:7C:D2:5F:D1:F0:A2:4F:DD:90:09:98:66:0C:0F"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "CD:16:E3:86:46:9F:23:98:8F:C9:CD:EC:A0:1B:FE:FB:D0:DE:AE:D1:3A:49:07:BC:E7:6E:91:AC:C9:66:2C:68"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.kunzisoft.keepass.free",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "7D:55:B8:AF:21:03:81:AA:BF:96:0F:07:E1:7C:F7:85:7B:6D:2A:64:2C:A2:DA:6B:F0:BD:F1:B2:00:36:2F:04"
                ),
                false
            ),
            // Google Play Store
            Hashes(
                listOf(
                    "46:D5:15:D5:F4:15:72:42:0C:EF:30:C0:7B:52:6B:F2:C4:0F:C4:A1:13:EF:19:1F:4F:9D:F9:01:2E:09:1F:35"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.kunzisoft.keepass.libre",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "7D:55:B8:AF:21:03:81:AA:BF:96:0F:07:E1:7C:F7:85:7B:6D:2A:64:2C:A2:DA:6B:F0:BD:F1:B2:00:36:2F:04"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "C8:10:AA:B7:EF:A4:D5:AD:3F:C2:94:1F:DF:5F:99:B8:8A:3B:73:F8:62:19:71:56:27:ED:B4:DA:BA:C5:41:A4"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "org.telegram.messenger.web",
        listOf(
            // Website
            Hashes(
                listOf(
                    "49:C1:52:25:48:EB:AC:D4:6C:E3:22:B6:FD:47:F6:09:2B:B7:45:D0:F8:80:82:14:5C:AF:35:E1:4D:CC:38:E1"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "org.telegram.messenger",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "49:C1:52:25:48:EB:AC:D4:6C:E3:22:B6:FD:47:F6:09:2B:B7:45:D0:F8:80:82:14:5C:AF:35:E1:4D:CC:38:E1"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.duolingo",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "12:33:FF:6D:E4:C7:0E:F4:D7:DE:AE:54:AF:15:B1:67:FC:7C:FD:25:39:51:7B:D2:17:58:70:F3:CB:77:17:31"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "me.hackerchick.catima",
        listOf(
            // GitHub and IzzyOnDroid F-Droid
            Hashes(
                listOf(
                    "D4:05:CD:69:ED:E4:C2:20:74:C3:28:FB:82:56:89:A8:4A:B3:FC:A4:B3:FD:F0:B6:CC:13:33:AF:62:C6:7E:B3"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "62:86:4D:B7:87:CC:31:92:8D:C2:C1:14:67:3C:DB:B0:17:BE:AB:B1:3B:A6:DF:6A:E5:25:6E:73:8B:B9:53:AE"
                ),
                false
            ),
            // Google Play Store
            Hashes(
                listOf(
                    "75:FD:99:1B:AC:EA:84:8E:5A:BF:F1:4A:01:D9:60:9B:76:50:CF:03:06:B3:7A:60:ED:56:15:67:8C:B3:64:07"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.github.olga_yakovleva.rhvoice.android",
        listOf(
            // Website/Google Play Store
            Hashes(
                listOf(
                    "ED:6B:F5:A8:DA:10:F1:DF:B1:03:84:F3:9B:D5:85:9C:06:61:7C:9B:F3:5E:24:B3:86:90:2E:50:92:CB:09:EA"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "10:79:02:73:B7:C5:68:B3:C3:11:35:4D:47:3D:4B:83:B4:82:07:12:E1:F5:95:E3:24:C4:DD:B9:67:2B:D2:3A"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.kylecorry.trail_sense",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "8A:0A:C4:74:32:1E:FD:27:8E:E1:05:BF:35:F6:7A:26:4B:94:3F:C4:D0:38:71:A0:1C:95:71:7A:D5:24:A2:62"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "AF:A3:19:DC:E2:2C:6A:8F:B3:E4:D8:52:A2:C0:DF:6C:07:CF:99:5D:AB:2F:78:33:1E:4B:C5:B5:DD:48:BF:AF"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.kylecorry.trail_sense.dev",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "D3:B7:CB:BC:63:3F:7C:1B:E2:CA:A2:F7:5F:B0:72:EE:9B:40:FD:10:FA:AF:96:42:69:2B:27:C4:AF:5E:C4:A7"
                ),
                false
            ),
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.collabora.libreoffice",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "57:32:58:C8:4E:14:9B:5F:4D:92:99:E7:43:4B:2B:69:A8:41:03:72:92:1D:4A:E5:86:BA:91:EC:76:78:92:CC"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "de.dennisguse.opentracks",
        listOf(
            // F-Droid
            Hashes(
                listOf(
                    "47:74:E9:91:7C:E0:5A:20:71:B5:C3:39:E8:E6:FA:A8:01:BF:C9:1B:9D:CC:C4:80:45:58:CF:8A:E6:55:5C:74"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "de.dennisguse.opentracks.nightly",
        listOf(
            // StorchPs F-Droid
            Hashes(
                listOf(
                    "71:C1:27:B4:2F:EF:A3:37:2E:ED:95:44:AA:25:97:C8:FA:C4:E1:A4:79:17:1B:E3:BC:B4:81:DE:2D:95:AC:D2"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "org.breezyweather",
        listOf(
            // GitHub/Breezy Weather F-Droid
            Hashes(
                listOf(
                    "29:D4:35:F7:0A:A9:AE:C3:C1:FA:FF:7F:7F:FA:6E:15:78:50:88:D8:7F:06:EC:FC:AB:9C:3C:C6:2D:C2:69:D8"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "org.videolan.vlc",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "C8:76:8D:2C:EA:0C:4B:62:2E:41:9B:4B:47:15:98:19:46:82:1E:4E:BC:03:5F:B4:17:76:CA:D3:95:A7:F6:8E"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "80:53:5B:E6:1E:ED:B9:A0:3B:04:76:A6:F4:93:D4:96:C3:49:87:70:40:43:39:EA:7A:80:00:F5:E6:1D:22:C0"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.fsck.k9",
        listOf(
            // Google Play Store/GitHub
            Hashes(
                listOf(
                    "55:C8:A5:23:B9:73:35:F5:BF:60:DF:E8:A9:F3:E1:DD:E7:44:51:6D:93:57:E8:0A:92:5B:7B:22:E4:F5:55:24"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "C4:30:66:5E:36:62:25:3B:20:78:DC:DA:35:0C:2C:6C:E4:4D:91:5A:3D:8A:14:7B:63:CE:D6:19:BB:9E:85:76"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.flauschcode.broccoli",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "BF:A3:F7:DA:10:9F:7D:33:07:10:6E:C4:86:28:15:DF:82:E8:A4:EB:CA:74:0D:38:45:ED:57:97:50:11:2A:F6"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "73:8E:4F:5A:7C:A8:28:E8:00:C0:22:AB:44:AB:51:72:8E:66:00:1E:61:D3:50:E2:7C:E7:D9:DF:CF:0F:6B:99"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "app.organicmaps",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "B9:C7:AE:79:A5:A9:02:70:DF:08:A1:32:E5:36:B9:C6:66:F5:BE:F1:F5:9B:30:4F:CE:CF:86:87:86:5E:4B:5B"
                ),
                false
            ),
            // Google Play Store
            Hashes(
                listOf(
                    "9D:5A:95:65:8F:EC:4E:A2:FD:C1:E0:A6:96:E3:69:E5:B9:38:D2:E3:0A:28:ED:FF:50:AE:99:BD:A2:7E:8F:A3"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "E2:16:FC:38:6C:32:7E:C8:8D:05:60:26:F1:DE:A2:7B:E2:BC:3F:9D:7E:E9:56:E4:36:1C:4B:64:EC:45:9F:E9"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.noahjutz.gymroutines",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "93:84:20:5F:EF:78:98:F2:E8:F8:A5:43:5F:B1:7D:E9:7E:4A:92:5D:78:B0:72:99:15:3D:05:D2:A0:7A:8B:52"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "C5:0C:37:9B:64:63:43:CF:83:85:F4:21:E9:DE:27:BC:BA:DB:29:05:4F:81:67:52:52:37:B7:AB:F4:A2:8E:31"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "com.apps.adrcotfas.goodtime",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "F9:56:D7:C5:FD:49:90:AA:43:D4:F2:FF:25:4C:70:F6:3D:6E:38:23:68:4D:35:A7:50:32:80:A5:97:48:B0:7C"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "5F:72:28:01:44:59:51:76:B6:64:F4:8D:0F:80:E4:8B:6F:30:0B:F7:60:98:8C:E6:60:79:B1:88:44:F2:4E:90"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "chat.fluffy.fluffychat",
        listOf(
            // GitHub
            Hashes(
                listOf(
                    "5E:DB:5C:43:95:B2:F2:D9:BA:68:2F:6A:1D:27:51:70:CC:E5:36:5A:6F:A2:7D:22:20:EA:8D:52:A6:D9:5F:07"
                ),
                false
            ),
            // Google Play Store
            Hashes(
                listOf(
                    "21:64:41:F3:2F:AD:2A:60:64:71:23:F8:08:DD:D1:E9:C2:D2:D7:74:37:1E:26:E1:C9:D2:1F:E3:28:D9:54:F8"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "05:7A:C4:51:64:A2:E6:E3:1F:6D:DE:55:5A:5F:2C:CC:B4:D8:83:4C:B1:85:25:49:68:1B:00:E3:46:68:CA:F3"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        // Syphon
        "org.tether.tether",
        listOf(
            // GitHub/Google Play Store
            Hashes(
                listOf(
                    "6C:BD:9B:DC:71:F0:8A:AF:53:BC:F2:0A:16:48:D0:3A:BE:D4:5B:C2:76:B8:EF:53:D8:DD:E6:2A:ED:B0:F0:BD"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "D3:DD:DB:89:34:EC:0B:A7:AF:85:14:60:FA:8A:5B:C0:C0:15:99:78:D9:B0:E7:D2:9F:EC:0C:2F:8B:4E:2A:65"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "chat.quadrix.android",
        listOf(
            // Google Play Store
            Hashes(
                listOf(
                    "57:16:3A:29:A5:EE:D8:CC:9A:AA:3C:9F:4E:C8:2F:B9:16:2C:48:A5:DE:A3:90:65:15:F0:64:D8:32:43:C7:14"
                ),
                false
            )
        )
    ),
    InternalDatabaseVerificationInfo(
        "de.spiritcroc.riotx",
        listOf(
            // Google Play Store/SpiritCroc F-Droid
            Hashes(
                listOf(
                    "66:12:AD:E7:E9:31:74:A5:89:CF:5B:A2:6E:D3:AB:28:23:1A:78:96:40:54:6C:8F:30:37:5E:F0:45:BC:92:42"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "5D:47:3A:51:69:EF:71:AE:DC:BC:A1:DA:51:12:10:BA:B4:AA:FF:27:8C:5E:F7:85:76:0D:F8:82:95:4B:1A:99"
                ),
                false
            )
        )
    ),
    InternalDatabseVerificationInfo(
        "de.spiritcroc.riotx.foss",
        listOf(
            // SpiritCroc F-Droid Stable
            Hashes(
                listOf(
                    "FA:C0:73:C4:2D:F8:A2:4E:D7:9E:D6:1A:19:86:A0:08:B6:3D:64:68:99:21:70:F8:2C:29:D7:9B:C6:80:8E:AC"
                ),
                false
            )
        )
    ),
    InternalDatabseVerificationInfo(
        "de.spiritcroc.riotx.fcm",
        listOf(
            // SpiritCroc F-Droid Stable
            Hashes(
                listOf(
                    "FA:C0:73:C4:2D:F8:A2:4E:D7:9E:D6:1A:19:86:A0:08:B6:3D:64:68:99:21:70:F8:2C:29:D7:9B:C6:80:8E:AC"
                ),
                false
            )
        )
    ),
    InternalDatabseVerificationInfo(
        "de.spiritcroc.riotx.testing.foss",
        listOf(
            // SpiritCroc F-Droid Beta
            Hashes(
                listOf(
                    "52:D0:3F:2F:AB:78:55:73:BB:29:5C:7A:B2:70:69:5E:3A:1B:DD:2A:DC:6A:6D:E8:71:32:50:B3:3F:23:12:25"
                ),
                false
            )
        )
    ),
    InternalDatabseVerificationInfo(
        "de.spiritcroc.riotx.testing.fcm",
        listOf(
            // SpiritCroc F-Droid Beta
            Hashes(
                listOf(
                    "0F:D3:50:17:8D:3E:15:6D:FE:52:32:63:6D:7C:43:31:A5:DF:85:C3:6E:8E:3A:11:79:8D:4D:06:6D:31:62:27"
                ),
                false
            )
        )
    ),
    InternalDatabseVerificationInfo(
        "im.vector.app",
        listOf(
            // GitHub/Google Play Store
            Hashes(
                listOf(
                    "F3:FF:38:D2:E5:A6:38:84:86:4A:4E:0D:45:C5:3B:19:8E:7E:39:C0:50:5B:D9:63:F5:55:D6:53:2D:EA:BF:5F"
                ),
                false
            ),
            // F-Droid
            Hashes(
                listOf(
                    "B1:5D:9B:67:3B:55:B9:FE:65:61:90:79:4D:87:2E:59:EC:5B:85:B3:BF:B8:A7:6B:94:42:F1:7E:AE:28:87:C9"
                ),
                false
            )
        )
    ),
)
