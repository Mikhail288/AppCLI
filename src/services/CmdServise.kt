package services

import domain.ArgsHandler
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType


class CmdServise(args: Array<String>) {

    val parser = ArgParser("AppCli.jar", true)
    val login by parser.option(ArgType.String, "login", "log", "Справка об доступных аргументах программы")
    val pass by parser.option(ArgType.String, "password", "pass", "Справка об доступных аргументах программы")
    val res by parser.option(ArgType.String, "resource", "res", "Справка об доступных аргументах программы")
    val role by parser.option(ArgType.String, "role", "role", "Справка об доступных аргументах программы")
    val ds by parser.option(ArgType.String, "dataStart", "ds", "Справка об доступных аргументах программы")
    val de by parser.option(ArgType.String, "dataEnd", "de", "Справка об доступных аргументах программы")
    val vol by parser.option(ArgType.String, "valume", "vol", "Справка об доступных аргументах программы")

    init {
        try {
            parser.parse(args)
        } catch (e: IllegalStateException) {
            println(e)
            println("Parser error :(")
        }
    }

    fun parse(): ArgsHandler {
        return ArgsHandler(login, pass, res, role, ds, de, vol)
    }

    fun isAuthenticationNeeded(): Boolean {
        return (login != null && pass != null)
    }

    fun isAuthorizationNeeded(): Boolean {
        return (res != null && role != null)
    }

    fun isAccountingNeeded(): Boolean {
        return (ds != null && de != null && vol != null)
    }
}

