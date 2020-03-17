package util
import enum.ExitCode
import enum.Role
import java.lang.IllegalArgumentException
import kotlin.system.exitProcess

fun validateLogin(login: String) {
    val regex = "[a-z]{1,9}".toRegex()
    if (!regex.matches(login))
        exitProcess(ExitCode.INVALID_LOGIN.codeNumber)
}

fun validateRole(role: String) {
    try {
        !Role.values().contains(Role.valueOf(role))
    }
    catch (e : IllegalArgumentException){
            exitProcess(ExitCode.UNKNOWN_ROLE.codeNumber)
    }
}

fun validateVolume(volume: String) {
   try {
       volume.toInt()
   }
   catch (e:NumberFormatException){
       exitProcess(ExitCode.INCORRECT_ACTIVITY.codeNumber)
   }
}


