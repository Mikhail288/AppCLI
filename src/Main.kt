import mock.ResoursesMock
import mock.UsersMock
import services.AccountingService
import services.BusinessLogic
import services.CmdServise
import services.ResourcesService


fun main(args: Array<String>) {
    val cmd = CmdServise().parse(args)
    if(cmd.help) BusinessLogic().help()
    if(CmdServise().isAuthenticationNeeded(cmd.login, cmd.password)){
        BusinessLogic().authentication(cmd.login!!, cmd.password!!, UsersMock().users)
    } else {
        BusinessLogic().help()
    }
   if(CmdServise().isAuthorizationNeeded(cmd.resource, cmd.role)){
       BusinessLogic().authorization(cmd.login!!, cmd.role!!, cmd.resource!!, ResoursesMock().resources)
   }



}

