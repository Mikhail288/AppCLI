import enum.ExitCode.SUCCESS
import enum.Roles
import mock.ResoursesMock
import mock.SessionMock.Companion.session
import mock.UsersMock
import services.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val authenticationService = AuthenticationService(UsersMock().users)
    val authorizationService = AuthorizationService(ResoursesMock().resources)
    val accountingService = AccountingService()
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
        status = businessLogic.accounting(cmd.dateStart!!, cmd.dateEnd!!, cmd.volume!!)
    }
    accountingService.successSession(
        session,
        UsersMock().users.first { it.login == cmd.login },
        cmd.resource!!,
        Roles.valueOf(cmd.role!!),
        cmd.dateStart!!,
        cmd.dateEnd!!,
        cmd.volume!!.toInt()
    )

    exitProcess(status.codeNumber)
}

