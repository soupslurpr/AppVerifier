package dev.soupslurpr.appverifier

import dev.soupslurpr.appverifier.data.VerificationInfo

val internalVerificationInfoDatabase = setOf(
    VerificationInfo(
        "dev.soupslurpr.beautyxt",
        setOf(
            "00:03:01:CC:29:1B:B9:9B:5E:BC:13:BE:89:F0:8C:46:03:80:71:27:B5:5E:21:AA:1E:69:8B:1D:E6:B8:43:46"
        )
    ),
    VerificationInfo(
        "org.thoughtcrime.securesms",
        setOf(
            "29:F3:4E:5F:27:F2:11:B4:24:BC:5B:F9:D6:71:62:C0:EA:FB:A2:DA:35:AF:35:C1:64:16:FC:44:62:76:BA:26"
        )
    ),
    VerificationInfo(
        "app.accrescent.client",
        setOf(
            "06:7A:40:C4:19:3A:AD:51:AC:87:F9:DD:FD:EB:B1:5E:24:A1:85:0B:AB:FA:48:21:C2:8C:5C:25:C3:FD:C0:71"
        )
    ),
    VerificationInfo(
        "net.mullvad.mullvadvpn",
        setOf(
            // Official
            "7B:E2:19:30:C3:B4:D7:39:06:B0:89:30:45:0A:1D:3A:FB:D2:2C:98:D9:D8:E9:87:DF:8C:1F:BC:2D:0C:90:BB",
            // Google Play Store
            "D7:4C:E0:E0:B2:9F:4D:1D:57:AB:F5:EF:7F:9A:37:57:E7:87:CC:A7:A6:25:9B:9C:32:BB:5B:B1:8E:34:63:BD",
            // F-Droid
            "E1:B6:6A:F1:AC:48:69:A3:3B:09:1F:81:DC:BD:57:7B:F8:DC:FE:91:25:DD:DE:33:81:BF:FF:91:81:33:31:EC",
        )
    ),
    VerificationInfo(
        "com.dominospizza",
        setOf(
            "97:59:E1:5B:C7:AD:25:FB:A0:5D:43:36:16:E5:1C:E5:04:09:2E:F0:4F:63:C3:61:36:5C:FD:FE:DA:DD:3B:FC"
        )
    ),
    VerificationInfo(
        "com.google.android.GoogleCamera",
        setOf(
            "F0:FD:6C:5B:41:0F:25:CB:25:C3:B5:33:46:C8:97:2F:AE:30:F8:EE:74:11:DF:91:04:80:AD:6B:2D:60:DB:83"
        )
    ),
    VerificationInfo(
        "com.google.android.inputmethod.latin",
        setOf(
            "F0:FD:6C:5B:41:0F:25:CB:25:C3:B5:33:46:C8:97:2F:AE:30:F8:EE:74:11:DF:91:04:80:AD:6B:2D:60:DB:83"
        )
    ),
    VerificationInfo(
        "com.einnovation.temu",
        setOf(
            "8A:DE:FE:CE:37:49:DC:F2:3C:3C:EB:3A:8B:BB:C9:A1:D8:80:91:B6:76:30:05:88:91:1B:B5:8B:85:97:0B:AF"
        )
    ),
    VerificationInfo(
        "com.zhiliaoapp.musically",
        setOf(
            "90:41:80:3E:91:BC:B8:14:B4:B4:39:9F:B5:C8:5A:91:64:0B:75:5E:5E:8B:A7:68:13:81:4B:F4:CF:2A:B5:BA"
        )
    ),
    VerificationInfo(
        "com.whatsapp",
        setOf(
            "39:87:D0:43:D1:0A:EF:AF:5A:87:10:B3:67:14:18:FE:57:E0:E1:9B:65:3C:9D:F8:25:58:FE:B5:FF:CE:5D:44"
        )
    ),
    VerificationInfo(
        "com.squareup.cash",
        setOf(
            "21:A7:46:75:96:C1:68:65:0F:D7:B6:31:B6:54:22:EB:56:3E:1D:21:AF:F2:2D:DE:73:89:BA:0D:5D:73:87:48"
        )
    ),
    VerificationInfo(
        "im.molly.app",
        setOf(
            "6A:A8:0F:DF:4A:8C:C1:37:37:CF:B4:34:FC:0C:DE:48:6F:09:CF:8F:CD:A2:1A:67:BE:A5:EE:1C:A2:70:08:86"
        )
    ),
    VerificationInfo(
        "org.oxycblt.auxio",
        setOf(
            // Official
            "DA:84:E2:53:4C:1A:CC:0B:6E:4F:57:DE:DB:64:0D:4D:C8:93:F5:BF:41:37:A2:E1:EC:BA:87:AD:F8:25:BA:44",
            // F-Droid
            "65:B3:E6:2A:2B:57:BF:73:23:5B:E6:D2:D4:2A:E5:46:FC:B0:2F:D1:7F:62:CD:14:50:0D:1C:41:2A:28:59:72"
        )
    ),
    VerificationInfo(
        "ch.protonvpn.android",
        setOf(
            // Official
            "DC:C9:43:9E:C1:A6:C6:A8:D0:20:3F:34:23:EE:42:BC:C8:B9:70:62:8E:53:CB:73:A0:39:3F:39:8D:D5:B8:53",
            // F-Droid
            "95:0E:E2:D4:D0:A4:3F:FB:A7:EE:1D:A9:54:1C:4A:13:DE:FE:81:EB:69:7B:A7:D2:4C:17:F6:F8:86:E3:21:24"
        )
    ),
    VerificationInfo(
        "ch.protonmail.android",
        setOf(
            // Official
            "DC:C9:43:9E:C1:A6:C6:A8:D0:20:3F:34:23:EE:42:BC:C8:B9:70:62:8E:53:CB:73:A0:39:3F:39:8D:D5:B8:53",
        )
    ),
    VerificationInfo(
        "me.proton.android.drive",
        setOf(
            // Official
            "DC:C9:43:9E:C1:A6:C6:A8:D0:20:3F:34:23:EE:42:BC:C8:B9:70:62:8E:53:CB:73:A0:39:3F:39:8D:D5:B8:53",
        )
    ),
    VerificationInfo(
        "proton.android.pass",
        setOf(
            // Official
            "DC:C9:43:9E:C1:A6:C6:A8:D0:20:3F:34:23:EE:42:BC:C8:B9:70:62:8E:53:CB:73:A0:39:3F:39:8D:D5:B8:53",
        )
    ),
    VerificationInfo(
        "me.proton.android.calendar",
        setOf(
            // Official
            "DC:C9:43:9E:C1:A6:C6:A8:D0:20:3F:34:23:EE:42:BC:C8:B9:70:62:8E:53:CB:73:A0:39:3F:39:8D:D5:B8:53",
        )
    ),
    VerificationInfo(
        "com.x8bit.bitwarden",
        setOf(
            // Official
            "24:E0:6C:04:C2:08:04:8F:19:F1:C9:93:B4:DD:A4:43:0E:A8:B0:6D:B8:37:5E:A0:E3:7B:83:46:96:B9:AC:3A",
            // F-Droid
            "DE:6E:C9:14:31:55:79:95:29:7B:F3:E6:5B:C8:03:49:BC:60:3A:04:70:81:60:61:8C:86:BC:99:94:17:1C:90"
        )
    ),
    VerificationInfo(
        "com.github.lamarios.clipious",
        setOf(
            // Official
            "19:DE:04:E5:D6:84:66:06:9D:30:EC:63:C6:BA:7D:9E:3C:F7:3B:5D:61:CB:4B:37:62:C2:B9:B2:53:EC:BD:03"
        )
    ),
    VerificationInfo(
        "com.beemdevelopment.aegis",
        setOf(
            // Official
            "C6:DB:80:A8:E1:4E:52:30:C1:DE:84:15:EF:82:0D:13:DC:90:1D:8F:E3:3C:F3:AC:B5:7B:68:62:D8:58:A8:23",
            // F-Droid
            "09:CF:DE:62:E2:A8:1C:80:50:D3:BE:4C:20:E3:F8:D8:DD:D0:15:31:BE:1B:47:CB:3B:0E:EC:21:3F:64:1F:89"
        )
    ),
    VerificationInfo(
        "dev.imranr.obtainium",
        setOf(
            // Official
            "B3:53:60:1F:6A:1D:5F:D6:60:3A:E2:F5:0B:E8:0C:F3:01:36:7B:86:B6:AB:8B:1F:66:24:3D:A9:6C:D5:73:62",
        )
    ),
        VerificationInfo(
        "app.grapheneos.apps",
        setOf(
            // Official
            "33:84:C3:1F:CE:4A:7C:00:8A:8F:7B:26:52:BC:48:CC:43:21:F1:D2:C8:77:B1:8E:30:A4:ED:61:9A:F1:2F:6B"
        )
    ),
    VerificationInfo(
        "com.looker.droidify",
        setOf(
            // Official
            "ED:88:59:C5:5A:F3:11:16:26:58:B9:4A:F9:82:B9:F0:91:DC:D2:76:28:D4:DE:34:86:D1:21:7E:BF:3C:99:35",
            // F-Droid
            "B4:F1:C8:A8:1E:4B:9F:6E:02:63:8E:93:BE:AD:56:65:65:02:C2:1F:B9:5C:8D:3E:C9:3D:0C:DD:1F:6E:0D:3F"
        )
    ),
    VerificationInfo(
        "org.fdroid.fdroid",
        setOf(
            "43:23:8D:51:2C:1E:5E:B2:D6:56:9F:4A:3A:FB:F5:52:34:18:B8:2E:0A:3E:D1:55:27:70:AB:B9:A9:C9:CC:AB"
        )
    ),
    VerificationInfo(
        "org.fdroid.basic",
        setOf(
            "EF:7F:82:2B:76:53:E2:01:1C:B8:C5:A7:FC:99:E8:D2:AD:E1:71:7E:53:9C:A5:6D:64:56:29:5E:3B:C0:73:12"
        )
    ),
    VerificationInfo(
        "com.machiav3lli.fdroid",
        setOf(
            // Official
            "C5:86:01:46:13:8B:77:99:BB:9D:06:17:C3:98:C1:E5:24:15:50:F5:58:25:2A:3F:97:B2:A5:1F:15:26:3E:F7",
            // F-Droid
            "6D:8F:A0:E2:D8:F4:C1:D8:11:B8:5C:C7:33:E8:7D:5D:AC:66:67:40:C5:D7:32:38:E2:37:5B:81:A1:17:61:B5"
        )
    ),
)
