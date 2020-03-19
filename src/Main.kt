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


}
fun outputHelp(){
    println("Это справка!!!")
}

