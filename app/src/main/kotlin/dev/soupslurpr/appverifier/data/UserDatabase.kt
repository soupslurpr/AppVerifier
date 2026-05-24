package dev.soupslurpr.appverifier.data

data class UserDatabaseEntry(
    val packageName: String,
    val hashes: List<String>,
    val hasMultipleSigners: Boolean,
)

fun parseUserDatabaseEntriesFromText(text: String): List<UserDatabaseEntry>? {
    val entries = text.trim().split("\n\n").filter { it.isNotBlank() }
    val result = mutableListOf<UserDatabaseEntry>()
    for (entry in entries) {
        val lines = entry.lines().map { it.trim() }.filter { it.isNotBlank() }
        if (lines.size < 2) return null
        val packageName = lines.first()
        if (!packageName.contains(".")) return null
        val hashes = lines.drop(1).filter { it.contains(":") }
        if (hashes.isEmpty()) return null
        result.add(UserDatabaseEntry(
            packageName = packageName,
            hashes = hashes,
            hasMultipleSigners = hashes.size > 1,
        ))
    }
    return result
}
