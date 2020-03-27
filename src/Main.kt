import enum.ExitCode
import mock.ResoursesMock
import mock.UsersMock
import services.AccountingService
import services.BusinessLogic
import services.CmdServise
import services.ResourcesService
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val cmd = CmdServise().parse(args)
    var isAuthenticated = false
    var isAuthorizated = false
    var isAccounted = false
    if(cmd.help) BusinessLogic().help()
    if(CmdServise().isAuthenticationNeeded(cmd.login, cmd.password)){
        isAuthenticated = BusinessLogic().authentication(cmd.login!!, cmd.password!!, UsersMock().users)
    } else {
        BusinessLogic().help()
    }
   if(isAuthenticated && CmdServise().isAuthorizationNeeded(cmd.resource, cmd.role)){
       isAuthorizated = BusinessLogic().authorization(cmd.login!!, cmd.role!!, cmd.resource!!, ResoursesMock().resources)
   }
    if(isAuthorizated && CmdServise().isAccountingNeeded(cmd.dateStart, cmd.dateEnd, cmd.volune)){
        isAccounted = BusinessLogic().accounting(cmd.dateStart!!, cmd.dateEnd!!, cmd.volune!!)
    }
    if(isAccounted){
        println(isAccounted)
        exitProcess(ExitCode.SUCCESS.codeNumber)
    }


}

