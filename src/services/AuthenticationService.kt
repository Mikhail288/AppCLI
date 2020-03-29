package services

import domain.User
import java.security.MessageDigest


class AuthenticationService(private val users: List<User>) {
        fun validateLogin(log: String): Boolean {
        val regex = "[a-z]{1,9}".toRegex()
        return (regex.matches(log))
    }

    fun findUserLogin(log: String): Boolean {
        return users.find { it.login == log } != null
    }

    fun verificationPassword(log: String, pass: String): Boolean {
        val h = (getHash(pass, getSalt(log)))
        return users.find { it.login == log && it.hash == h } != null
    }

    private fun hash(s: String): String {
        val bytes = s.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }

    private fun getSalt(login: String): String {
        return users.find { it.login == login }!!.salt
    }

    private fun getHash(pass: String, salt: String): String {
        return hash(pass + salt)
    }
}