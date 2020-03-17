import domain.InputArgs
import enum.ConsoleFlag.*
import enum.ExitCode
import util.validateLogin
import util.validateRole
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val inputArgs = InputArgs()
    for (arg in args.indices) {
        when (args[arg]) {
            LOGIN.nameParam -> inputArgs.login = args[arg + 1]
            PASSWORD.nameParam -> inputArgs.password = args[arg + 1]
            RESOURCE.nameParam -> inputArgs.resource = args[arg + 1]
            ROLE.nameParam -> inputArgs.role = args[arg + 1]
            DATE_START.nameParam -> inputArgs.dateStart = args[arg + 1]
            DATE_END.nameParam -> inputArgs.dateEnd = args[arg + 1]
            VOLUME.nameParam -> inputArgs.volume = args[arg + 1]
        }
    }
    println(inputArgs)
    validateRole(inputArgs.role!!)
    exitProcess(ExitCode.INVALID_PASSWORD.codeNumber)
    exitProcess(ExitCode.UNKNOWN_ROLE.codeNumber)
    //validateLogin(inputArgs.login!!)


}