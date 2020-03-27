package services

import domain.Resources
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
    fun authorization(login: String, role: String, resource: String, resources: List<Resources>): Boolean{
        val isRoleExist = ResourcesService().findRoles(role)
        var isChildAccessExist = false
        var isParentAccessExist = false
        if(isRoleExist){
            isChildAccessExist = ResourcesService().checkResourceAccess(login, resource, role)
        } else {
            exitProcess(ExitCode.UNKNOWN_ROLE.codeNumber)
        }
        if(!isChildAccessExist){
             isParentAccessExist = ResourcesService().isParentHaveAccess(resource, resources, login, role)
        }
        val isAccessExist = isChildAccessExist || isParentAccessExist
        if(!isAccessExist){
            exitProcess(ExitCode.FORBIDDEN.codeNumber)
        }
        return isAccessExist
    }
}