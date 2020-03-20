package domain

data class ArgsHandler(
        var help: Boolean? = false,
        var login: String?,
        var password: String?
)