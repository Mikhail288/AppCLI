package services

import domain.ArgsHandler

class CmdServise(args: Array<String>) {

    fun parse(args: Array<String>): ArgsHandler {
        var help: Boolean = false
        var login: String? = null
        var pass: String? = null

        if (args[0] == "-h") {
            help = true
        }

        if (args[0] == "-log" && args[2] == "-pass") {
            login = args[1]
            pass = args[3]
        } else {

        }
        return ArgsHandler(help, login, pass)
    }

    fun outputHelp() {
        println("Это справка!!!")
    }
}

