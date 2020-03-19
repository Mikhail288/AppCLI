package domain

data class InputArgs(
    var login: String? = null,
    var password: String? = null,
    var resource: String? = null,
    var role: String? = null,
    var dateStart: String? = null,
    var dateEnd: String? = null,
    var volume: String? = null
)
