package services

import enum.ExitCode
import enum.ExitCode.*

class BusinessLogic(
    private val authenticationService: AuthenticationService,
    private val authorizationService: AuthorizationService,
    private val accountingService: AccountingService
) {
    fun authentication(login: String, pass: String): ExitCode {
        val isLoginValidated: Boolean = authenticationService.validateLogin(login)
        val isLoginExist: Boolean
        val isPasswordVerificated: Boolean
        if (isLoginValidated) {
            isLoginExist = authenticationService.findUserLogin(login)
        } else {
            return INVALID_LOGIN
        }
        if (isLoginExist) {
            isPasswordVerificated = authenticationService.verificationPassword(login, pass)
        } else {
            return UNKNOWN_LOGIN
        }
        return if (isPasswordVerificated) {
            SUCCESS
        } else {
            INVALID_PASSWORD
        }
    }

    fun authorization(login: String, role: String, resource: String): ExitCode {
        val isRoleExist = authorizationService.findRoles(role)
        val isChildAccessExist: Boolean
        var isParentAccessExist = false
        if (isRoleExist) {
            isChildAccessExist = authorizationService.checkResourceAccess(login, resource, role)
        } else {
            return UNKNOWN_ROLE
        }
        if (!isChildAccessExist) {
            isParentAccessExist = authorizationService.isParentHaveAccess(resource, login, role)
        }
        val isAccessExist = isChildAccessExist || isParentAccessExist
        return if (isAccessExist) {
            SUCCESS
        } else {
            FORBIDDEN
        }
    }

    fun accounting(ds: String, de: String, vol: String): ExitCode {
        val dateStarted = accountingService.parseDate(ds)
        val dateEnd = accountingService.parseDate(de)
        val isDateValided = dateStarted != null && dateEnd != null && dateStarted.compareTo(dateEnd) == -1
        val isVolumeValided = accountingService.validateVolume(vol)
        return if (isDateValided && isVolumeValided) {
            SUCCESS
        } else {
            INCORRECT_ACTIVITY
        }
    }
}