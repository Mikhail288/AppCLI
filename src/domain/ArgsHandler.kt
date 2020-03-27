package domain

import java.time.LocalDate

data class ArgsHandler(
        var help: Boolean = false,
        var login: String?,
        var password: String?,
        var resource: String?,
        var role: String?,
        var dateStart: String?,
        var dateEnd: String?,
        var volune: String?
        )