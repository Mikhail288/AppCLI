import mock.ResoursesMock
import mock.UsersMock
import services.BusinessLogic
import services.CmdServise
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val cmdServise = CmdServise(args)
    val cmd = cmdServise.parse()
    var status: Int = 0
    if (cmdServise.isAuthenticationNeeded()) {
        status = BusinessLogic().authentication(cmd.login!!, cmd.password!!, UsersMock().users)
    } else {
        BusinessLogic().help()
    }
    if (status == 0 && cmdServise.isAuthorizationNeeded()) {
        status = BusinessLogic().authorization(cmd.login!!, cmd.role!!, cmd.resource!!, ResoursesMock().resources)
    }
    if (status == 0 && cmdServise.isAccountingNeeded()) {
        status = BusinessLogic().accounting(cmd.dateStart!!, cmd.dateEnd!!, cmd.volune!!)
    }
    exitProcess(status)

}

