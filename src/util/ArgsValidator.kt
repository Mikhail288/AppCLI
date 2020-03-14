package util

import enum.ExitCode
import kotlin.system.exitProcess

fun validateLogin(login: String): Int {
    val regex = "[a-z]{1,9}".toRegex()
    if (!regex.matches(login)) {
        exitProcess(ExitCode.INVALID_LOGIN.codeNumber)
    }
    exitProcess(ExitCode.SUCCESS.codeNumber)
}