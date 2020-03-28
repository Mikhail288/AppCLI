package domain


data class ArgsHandler(
    var login: String?,
    var password: String?,
    var resource: String?,
    var role: String?,
    var dateStart: String?,
    var dateEnd: String?,
    var volume: String?
)