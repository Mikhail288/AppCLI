package services

import domain.ArgsHandler

class CmdServise {

    fun parse(args: Array<String>): ArgsHandler {
        var help: Boolean = false
        var login: String? = null
        var pass: String? = null
        var res: String? = null
        var role: String? = null

        if (args[0] == "-h") {
            help = true
        }

        if (args[0] == "-log" && args[2] == "-pass") {
            login = args[1]
            pass = args[3]
        } else {
            help = true
        }
        if (args[4] == "-res" && args[6] == "-role") {
            res = args[5]
            role = args[7]
        }
        return ArgsHandler(help, login, pass, res, role)
    }

    fun isAuthenticationNeeded(log: String?, pass: String?): Boolean {
        return (log != null && pass != null)
    }

    fun isAuthorizationNeeded(res: String?, role: String?): Boolean {
        return (res != null && role != null)
    }

    fun outputHelp() {
        println("Это справка!!!")
    }
}

