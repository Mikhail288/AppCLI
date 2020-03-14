fun main(args: Array<String>) {
    for(arg in args.indices){
        when(args[arg]){
            "-login" -> println(args[arg+1])
            "-pass" -> println(args[arg+1])
        }
    }
}