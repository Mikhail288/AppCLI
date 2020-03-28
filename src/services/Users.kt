package services

import domain.User
import java.security.MessageDigest


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
        val h = (getHash(pass, getSalt(log, users)))
        return users.find { it.login == log && it.hash == h } != null
    }

    fun hash(s: String): String {
        val bytes = s.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }

    fun getSalt(login: String, users: List<User>): String {
        return  users.find { it.login == login }!!.salt
    }

    fun getHash(pass: String, salt: String): String{
        val a = hash(pass + salt)
       return  a
    }
}