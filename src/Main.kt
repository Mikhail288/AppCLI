import enum.ExitCode.*
import mock.ResoursesMock
import mock.UsersMock
import services.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val authenticationService = AuthenticationService()
    val authorizationService = AuthorizationService()
    val accountingService = AccountingService()
    val businessLogic = BusinessLogic(authenticationService, authorizationService, accountingService)
    val cmdServise = CmdServise(args)
    val cmd = cmdServise.parse()
    var status = SUCCESS
    if (cmdServise.isAuthenticationNeeded()) {
        status = businessLogic.authentication(cmd.login!!, cmd.password!!, UsersMock().users)
    }
    if (status == SUCCESS && cmdServise.isAuthorizationNeeded()) {
        status = businessLogic.authorization(cmd.login!!, cmd.role!!, cmd.resource!!, ResoursesMock().resources)
    }
    if (status == SUCCESS && cmdServise.isAccountingNeeded()) {
        status = businessLogic.accounting(cmd.dateStart!!, cmd.dateEnd!!, cmd.volume!!)
    }

    exitProcess(status.codeNumber)
}

