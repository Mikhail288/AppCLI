import mock.UsersMock
import services.BusinessLogic
import services.CmdServise



fun main(args: Array<String>) {
    val cmd = CmdServise().parse(args)
    if(cmd.help) BusinessLogic().help()
    if(CmdServise().isAuthenticationNeeded(cmd.login, cmd.password)){
        BusinessLogic().authentication(cmd.login!!, cmd.password!!, UsersMock().users)
    } else {
        BusinessLogic().help()
    }


}

