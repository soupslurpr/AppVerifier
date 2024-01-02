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
)
