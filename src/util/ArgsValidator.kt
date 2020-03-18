package util

import domain.InputArgs
import enum.ExitCode
import enum.Role
import java.time.LocalDate
import java.time.format.DateTimeParseException
import kotlin.system.exitProcess

fun validateArgs(inputArgs: InputArgs) {
    validateLogin(inputArgs.login.toString())
    validateRole(inputArgs.role.toString())
    validateDate(inputArgs.dateStart.toString(), inputArgs.dateEnd.toString())
    validateVolume(inputArgs.volume.toString())
}

fun validateLogin(login: String) {
    val regex = "[a-z]{1,9}".toRegex()
    if (!regex.matches(login))
        exitProcess(ExitCode.INVALID_LOGIN.codeNumber)
}

fun validateRole(role: String) {
    try {
        !Role.values().contains(Role.valueOf(role))
    } catch (e: IllegalArgumentException) {
        exitProcess(ExitCode.UNKNOWN_ROLE.codeNumber)
    }
}

fun validateVolume(volume: String) {
    try {
        if (volume != null) {
            volume.toInt()
        }
    } catch (e: NumberFormatException) {
        exitProcess(ExitCode.INCORRECT_ACTIVITY.codeNumber)
    }
}

fun validateDate(dateStart: String, dateEnd: String) {
    try {
         LocalDate.parse(dateStart)
         LocalDate.parse(dateEnd)
    } catch(e: DateTimeParseException) {
        exitProcess(ExitCode.INCORRECT_ACTIVITY.codeNumber)
    }
}



