import domain.InputArgs

fun main(args: Array<String>) {
    val inputArgs = InputArgs()
    for (arg in args.indices) {
        when (args[arg]) {
            "-login" -> inputArgs.login = args[arg + 1]
            "-pass" -> inputArgs.password = args[arg + 1]
            "-res" -> inputArgs.resource = args[arg + 1]
            "-role" -> inputArgs.role = args[arg + 1]
            "-ds" -> inputArgs.dateStart = args[arg + 1]
            "-de" -> inputArgs.dateEnd = args[arg + 1]
            "-vol" -> inputArgs.volume = args[arg + 1]
        }
    }
    println(inputArgs)

}