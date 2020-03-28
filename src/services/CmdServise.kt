package services

import domain.ArgsHandler
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType


class CmdServise(args: Array<String>) {

    private val parser = ArgParser("AppCli.jar", true)
    private val login by parser.option(
        ArgType.String,
        "login",
        "log",
        "Логин пользователя, строка, длина не больше 10 символов строчными буквами"
    )
    private val pass by parser.option(
        ArgType.String,
        "password",
        "pass",
        "Пароль, строка любой длины и любого содержания"
    )
    private val res by parser.option(
        ArgType.String,
        "resource",
        "res",
        "Путь к запрашиваемому ресурсу, используются заглавные буквы, разделенные точками"
    )
    private val role by parser.option(
        ArgType.String,
        "role",
        "role",
        "Права доступа к русерсу, возможны - WRITE, READ, EXECUTE"
    )
    private val ds by parser.option(
        ArgType.String,
        "dataStart",
        "ds",
        "Дата начала сессии работы с ресурсом, формат YYYY-mm-dd"
    )
    private val de by parser.option(
        ArgType.String,
        "dataEnd",
        "de",
        "Дата окончания сессии работы с ресурсом, формат YYYY-mm-dd"
    )
    private val vol by parser.option(ArgType.String, "volume", "vol", "Потребляемый объем, целочисленное значение")

    init {
        try {
            parser.parse(args)
        } catch (e: IllegalStateException) {
            println(e)
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

