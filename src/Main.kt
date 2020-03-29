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
    var status = 0
    if (cmdServise.isAuthenticationNeeded()) {
        status = businessLogic.authentication(cmd.login!!, cmd.password!!, UsersMock().users)
    }
    if (status == 0 && cmdServise.isAuthorizationNeeded()) {
        status = businessLogic.authorization(cmd.login!!, cmd.role!!, cmd.resource!!, ResoursesMock().resources)
    }
    if (status == 0 && cmdServise.isAccountingNeeded()) {
        status = businessLogic.accounting(cmd.dateStart!!, cmd.dateEnd!!, cmd.volume!!)
    }

    exitProcess(status)
}

