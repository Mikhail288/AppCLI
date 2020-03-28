import mock.ResoursesMock
import mock.UsersMock
import services.BusinessLogic
import services.CmdServise
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val cmd = CmdServise().parse(args)
    var status: Int = 0
    if (cmd.help) status = BusinessLogic().help()
    if (CmdServise().isAuthenticationNeeded(cmd.login, cmd.password)) {
        status = BusinessLogic().authentication(cmd.login!!, cmd.password!!, UsersMock().users)
    } else {
        BusinessLogic().help()
    }
    if (status == 0 && CmdServise().isAuthorizationNeeded(cmd.resource, cmd.role)) {
        status = BusinessLogic().authorization(cmd.login!!, cmd.role!!, cmd.resource!!, ResoursesMock().resources)
    }
    if (status == 0 && CmdServise().isAccountingNeeded(cmd.dateStart, cmd.dateEnd, cmd.volune)) {
        status = BusinessLogic().accounting(cmd.dateStart!!, cmd.dateEnd!!, cmd.volune!!)
    }
    exitProcess(status)

}

