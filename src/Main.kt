import enum.ExitCode
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val isArgs = args.isNotEmpty()
    //println(args[0])
    if(args[0]=="-h"){
        outputHelp()
        exitProcess(1)
    }
    if (!isArgs){
        outputHelp()
        exitProcess(0)
    }

    val isAutentificationArgs = args[0] =="-log" && args[2] == "-pass"
    val isLogin = args[1].isNotEmpty()



}
fun outputHelp(){
    println("Это справка!!!")
}

fun validateLogin(login: String) {
    val regex = "[a-z]{1,9}".toRegex()
    if (!regex.matches(login))
        exitProcess(ExitCode.INVALID_LOGIN.codeNumber)
}
