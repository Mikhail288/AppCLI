package enum

enum class Roles(val roleName: String) {
    READ("READ"),
    WRITE("WRITE"),
    EXECUTE("EXECUTE")
}

fun findRoles(role: String) = Roles.values().find { it.roleName == role } != null
