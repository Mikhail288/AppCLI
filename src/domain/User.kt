package domain

data class User(val login: String? = null, val hash: String, val salt: String)
