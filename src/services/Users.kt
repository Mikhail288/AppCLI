import domain.User
import enum.ExitCode
import kotlin.system.exitProcess

class Users {
    private val users = listOf(
            User(login = "Vasya", password = "123"),
            User("admin", "admin"),
            User("q", "?!#"),
            User("abcdefghij", "qwerty")
    )

    fun validateLogin(login: String) {
        val regex = "[a-z]{1,9}".toRegex()
        if (!regex.matches(login))
            exitProcess(ExitCode.INVALID_LOGIN.codeNumber)
    }

    fun findUserLogin(log: String) {
        users.find { it.login == log }
    }

    fun verificationPassword(log: String, pass: String) {
        users.find { it.login == log && it.password == pass }
    }

}