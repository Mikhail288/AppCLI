package services

import domain.Resources
import domain.User
import enum.ExitCode.*

class BusinessLogic(
    private val authenticationService: AuthenticationService,
    private val authorizationService: AuthorizationService,
    private val accountingService: AccountingService
) {
    fun authentication(login: String, pass: String, users: List<User>): Int {
        val isLoginValidated: Boolean = authenticationService.validateLogin(login)
        val isLoginExist: Boolean
        val isPasswordVerificated: Boolean
        if (isLoginValidated) {
            isLoginExist = authenticationService.findUserLogin(users, login)
        } else {
            return INVALID_LOGIN.codeNumber
        }
        if (isLoginExist) {
            isPasswordVerificated = authenticationService.verificationPassword(users, login, pass)
        } else {
            return UNKNOWN_LOGIN.codeNumber
        }
        return if (isPasswordVerificated) {
            SUCCESS.codeNumber
        } else {
            INVALID_PASSWORD.codeNumber
        }
    }

    fun authorization(login: String, role: String, resource: String, resources: List<Resources>): Int {
        val isRoleExist = authorizationService.findRoles(role)
        val isChildAccessExist: Boolean
        var isParentAccessExist = false
        if (isRoleExist) {
            isChildAccessExist = authorizationService.checkResourceAccess(login, resource, role)
        } else {
            return UNKNOWN_ROLE.codeNumber
        }
        if (!isChildAccessExist) {
            isParentAccessExist = authorizationService.isParentHaveAccess(resource, resources, login, role)
        }
        val isAccessExist = isChildAccessExist || isParentAccessExist
        return if (isAccessExist) {
            SUCCESS.codeNumber
        } else {
            FORBIDDEN.codeNumber
        }
    }

    fun accounting(ds: String, de: String, vol: String): Int {
        val dateStarted = accountingService.parseDate(ds)
        val dateEnd = accountingService.parseDate(de)
        val isDateValided = dateStarted != null && dateEnd != null && dateStarted.compareTo(dateEnd) == -1
        val isVolumeValided = accountingService.validateVolume(vol)
        return if (isDateValided && isVolumeValided) {
            SUCCESS.codeNumber
        } else {
            INCORRECT_ACTIVITY.codeNumber
        }
    }
}