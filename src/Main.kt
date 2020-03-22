import services.AccountingService


fun main(args: Array<String>) {
    /*val cmd = CmdServise().parse(args)
    if(cmd.help) BusinessLogic().help()
    if(CmdServise().isAuthenticationNeeded(cmd.login, cmd.password)){
        BusinessLogic().authentication(cmd.login!!, cmd.password!!, UsersMock().users)
    } else {
        BusinessLogic().help()
    }*/
    AccountingService().validateDate("2014-12-12", "2015-11-11")

}

