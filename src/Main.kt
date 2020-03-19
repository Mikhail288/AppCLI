fun main(args: Array<String>) {
    val isArgs = args.isNotEmpty()
    //println(args[0])
    if(!isArgs || args[0]=="-h"){
        outputHelp()
    }
}
fun outputHelp(){
    println("Это справка!!!")
}