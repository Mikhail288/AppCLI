package util
import enum.ExitCode.*
import enum.Role
import java.time.LocalDate
import java.time.format.DateTimeParseException
import kotlin.system.exitProcess

fun help() {
    println("ITs help!!!!")

}

fun printHelp(args: Array<String>){
    if(args.isEmpty()){
        help()
        exitProcess(HELP.codeNumber)
    }

    if(args[0] == "-h" || args[0].isBlank()){
        help()
        exitProcess(HELP.codeNumber)
    }

    if (args[0] != "-h" && args.size==1){
        help()
        exitProcess(SUCCESS.codeNumber)
    }


}

fun validateLogin(login: String) {
    val regex = "[a-z]{1,9}".toRegex()
    if (!regex.matches(login)|| login.isEmpty())
        exitProcess(INVALID_LOGIN.codeNumber)
}

fun validateRole(role: String) {
    try {
        !Role.values().contains(Role.valueOf(role))
    } catch (e: IllegalArgumentException) {
        exitProcess(UNKNOWN_ROLE.codeNumber)
    }
}

fun validateVolume(volume: String) {
    try {
        volume.toInt()
    } catch (e: NumberFormatException) {
        exitProcess(INCORRECT_ACTIVITY.codeNumber)
    }
}

fun validateDate(dateStart: String, dateEnd: String) {
    try {
         LocalDate.parse(dateStart)
         LocalDate.parse(dateEnd)
    } catch(e: DateTimeParseException) {
        exitProcess(INCORRECT_ACTIVITY.codeNumber)
    }
}



