import domain.InputArgs

fun main(args: Array<String>) {
    val inputArgs = InputArgs()
    for (arg in args.indices) {
        when (args[arg]) {
            "-login" -> inputArgs.login = args[arg + 1]
            "-pass" -> println(args[arg + 1])
            "-res" -> println(args[arg + 1])
            "-role" -> println(args[arg + 1])
            "-ds" -> println(args[arg + 1])
            "-de" -> println(args[arg + 1])
            "-vol" -> println(args[arg + 1])
        }
    }
    println(inputArgs)

}