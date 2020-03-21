package services

import domain.User


class Users {
    fun validateLogin(log: String): Boolean {
        val regex = "[a-z]{1,9}".toRegex()
        val isCorrect = regex.matches(log)
        return (regex.matches(log))
    }

    fun findUserLogin(users: List<User>, log: String): Boolean {
        return users.find { it.login == log } != null
    }

    fun verificationPassword(users: List<User>, log: String, pass: String): Boolean {
        return users.find { it.login == log && it.password == pass } != null
    }
}