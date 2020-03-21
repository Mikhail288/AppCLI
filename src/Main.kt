import enum.ExitCode
import services.BusinessLogic
import services.CmdServise



fun main(args: Array<String>) {
    val cmd = CmdServise().parse(args)
    if(cmd.help) BusinessLogic().help()
    if(cmd.login != null  && cmd.password != null ){
        BusinessLogic().authentication(cmd.login!!, cmd.password!!, UsersMock().users)
    } else {
        BusinessLogic().help()
    }


}

