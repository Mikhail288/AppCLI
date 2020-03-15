package util

import enum.ExitCode
import enum.Role
import kotlin.system.exitProcess

fun validateLogin(login: String): Int {
    val regex = "[a-z]{1,9}".toRegex()
    if (!regex.matches(login)) {
        exitProcess(ExitCode.INVALID_LOGIN.codeNumber)
    }
    exitProcess(ExitCode.SUCCESS.codeNumber)
}

fun validateRole(role: String): Int {

/*
    if(!Role.values().contains(Role.valueOf(role))){
        exitProcess(ExitCode.UNKNOWN_ROLE.codeNumber)
    }
    exitProcess(ExitCode.SUCCESS.codeNumber)
*/
    for (r in Role.values())
        if (!r.roleName.equals(role)) {
            exitProcess(ExitCode.UNKNOWN_ROLE.codeNumber)
        }
    exitProcess(ExitCode.SUCCESS.codeNumber)
}