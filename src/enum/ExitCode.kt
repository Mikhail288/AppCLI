package enum

enum class ExitCode(val codeNumber: Int) {
    SUCCESS(0),
    INVALID_LOGIN(2),
    UNKNOWN_LOGIN(3),
    INVALID_PASSWORD(4),
    UNKNOWN_ROLE(5),
    FORBIDDEN(6),
    INCORRECT_ACTIVITY(7)
}
