package services

import domain.User
import enum.ExitCode
import kotlin.system.exitProcess


class BusinessLogic {
    fun help(){
        CmdServise().outputHelp()
        exitProcess(ExitCode.HELP.codeNumber)
    }
    fun authentication(login: String, pass: String, users: List<User>): Boolean {
        var isLoginValidated: Boolean = Users().validateLogin(login)
        var isLoginExist: Boolean = false
        var isPasswordVerificated: Boolean = false
        if(isLoginValidated){
            isLoginExist = Users().findUserLogin(users, login)
        } else {
           exitProcess(ExitCode.INVALID_LOGIN.codeNumber)
        }
        if(isLoginExist){
            isPasswordVerificated = Users().verificationPassword(users, login, pass)
        } else {
            exitProcess(ExitCode.UNKNOWN_LOGIN.codeNumber)
        }
        if(isPasswordVerificated){
            exitProcess(ExitCode.SUCCESS.codeNumber)
        } else {
            exitProcess(ExitCode.INVALID_PASSWORD.codeNumber)
        }

        return isPasswordVerificated
    }
}