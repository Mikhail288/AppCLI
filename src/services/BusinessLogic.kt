package services

import domain.Resources
import domain.User
import enum.ExitCode

class BusinessLogic {
    fun authentication(login: String, pass: String, users: List<User>): Int {
        val isLoginValidated: Boolean = AuthenticationService().validateLogin(login)
        val isLoginExist: Boolean
        val isPasswordVerificated: Boolean
        if (isLoginValidated) {
            isLoginExist = AuthenticationService().findUserLogin(users, login)
        } else {
            return ExitCode.INVALID_LOGIN.codeNumber
        }
        if (isLoginExist) {
            isPasswordVerificated = AuthenticationService().verificationPassword(users, login, pass)
        } else {
            return ExitCode.UNKNOWN_LOGIN.codeNumber
        }
        return if (isPasswordVerificated) {
            ExitCode.SUCCESS.codeNumber
        } else {
            ExitCode.INVALID_PASSWORD.codeNumber
        }
    }

    fun authorization(login: String, role: String, resource: String, resources: List<Resources>): Int {
        val isRoleExist = AuthorizationService().findRoles(role)
        val isChildAccessExist: Boolean
        var isParentAccessExist = false
        if (isRoleExist) {
            isChildAccessExist = AuthorizationService().checkResourceAccess(login, resource, role)
        } else {
            return ExitCode.UNKNOWN_ROLE.codeNumber
        }
        if (!isChildAccessExist) {
            isParentAccessExist = AuthorizationService().isParentHaveAccess(resource, resources, login, role)
        }
        val isAccessExist = isChildAccessExist || isParentAccessExist
        return if (isAccessExist) {
            ExitCode.SUCCESS.codeNumber
        } else {
            ExitCode.FORBIDDEN.codeNumber
        }
    }

    fun accounting(ds: String, de: String, vol: String): Int {
        val dateStarted = AccountingService().parseDate(ds)
        val dateEnd = AccountingService().parseDate(de)
        val isDateValided = dateStarted != null && dateEnd != null && dateStarted.compareTo(dateEnd) == -1
        val isVolumeValided = AccountingService().validateVolume(vol)
        return if (isDateValided && isVolumeValided) {
            ExitCode.SUCCESS.codeNumber
        } else {
            ExitCode.INCORRECT_ACTIVITY.codeNumber
        }
    }
}