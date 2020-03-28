package services

import domain.Resources
import domain.User
import enum.ExitCode
import java.security.MessageDigest


class BusinessLogic {
    fun authentication(login: String, pass: String, users: List<User>): Int {
        var isLoginValidated: Boolean = Users().validateLogin(login)
        var isLoginExist: Boolean
        var isPasswordVerificated: Boolean
        if (isLoginValidated) {
            isLoginExist = Users().findUserLogin(users, login)
        } else {
            return ExitCode.INVALID_LOGIN.codeNumber
        }
        if (isLoginExist) {
            isPasswordVerificated = Users().verificationPassword(users, login, pass)
        } else {
            return ExitCode.UNKNOWN_LOGIN.codeNumber
        }
        if (isPasswordVerificated) {
            return ExitCode.SUCCESS.codeNumber
        } else {
            return ExitCode.INVALID_PASSWORD.codeNumber
        }
    }

    fun authorization(login: String, role: String, resource: String, resources: List<Resources>): Int {
        val isRoleExist = ResourcesService().findRoles(role)
        var isChildAccessExist: Boolean
        var isParentAccessExist = false
        if (isRoleExist) {
            isChildAccessExist = ResourcesService().checkResourceAccess(login, resource, role)
        } else {
            return ExitCode.UNKNOWN_ROLE.codeNumber
        }
        if (!isChildAccessExist) {
            isParentAccessExist = ResourcesService().isParentHaveAccess(resource, resources, login, role)
        }
        val isAccessExist = isChildAccessExist || isParentAccessExist
        if (isAccessExist) {
            return ExitCode.SUCCESS.codeNumber
        } else {
            return ExitCode.FORBIDDEN.codeNumber
        }
    }

    fun accounting(ds: String, de: String, vol: String): Int {
        val dateStarted = AccountingService().parseDate(ds)
        val dateEnd = AccountingService().parseDate(de)
        val isDateValided = dateStarted != null && dateEnd != null
        val isVolumeValided = AccountingService().validateVolume(vol)
        if (isDateValided && isVolumeValided) {
            return ExitCode.SUCCESS.codeNumber
        } else {
            return ExitCode.INCORRECT_ACTIVITY.codeNumber
        }
    }


}