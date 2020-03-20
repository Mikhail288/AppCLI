package services

import domain.User

class Users {
    private val users = listOf(
            User("vasya", "123"),
            User("admin", "admin"),
            User("q", "?!#"),
            User("abcdefghij", "qwerty")
    )

    fun validateLogin(log: String): Boolean {
        val regex = "[a-z]{1,9}".toRegex()
        val isCorrect = regex.matches(log)
        return (regex.matches(log))
    }

    fun findUserLogin(log: String): Boolean {
        return users.find { it.login == log } != null
    }

    fun verificationPassword(log: String, pass: String): Boolean {
        return users.find { it.login == log && it.password == pass } != null
    }

}