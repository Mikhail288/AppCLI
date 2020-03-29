import enum.ExitCode.SUCCESS
import mock.ResoursesMock
import mock.SessionMock
import mock.UsersMock
import services.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val authenticationService = AuthenticationService(UsersMock().users)
    val authorizationService = AuthorizationService(ResoursesMock().resources)
    val accountingService = AccountingService(SessionMock.session)
    val businessLogic = BusinessLogic(authenticationService, authorizationService, accountingService)
    val cmdServise = CmdServise(args)
    val cmd = cmdServise.parse()
    var status = SUCCESS
    if (cmdServise.isAuthenticationNeeded()) {
        status = businessLogic.authentication(cmd.login!!, cmd.password!!)
    }
    if (status == SUCCESS && cmdServise.isAuthorizationNeeded()) {
        status = businessLogic.authorization(cmd.login!!, cmd.role!!, cmd.resource!!)
    }
    if (status == SUCCESS && cmdServise.isAccountingNeeded()) {
        status = businessLogic.accounting(cmd.login!!, cmd.resource!!, cmd.role!!, cmd.dateStart!!, cmd.dateEnd!!, cmd.volume!!)
    }
    exitProcess(status.codeNumber)
}

