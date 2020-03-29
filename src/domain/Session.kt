package domain

import enum.Roles

data class Session(val user: String, val role: Roles, val resource: String, val ds: String, val de: String, val vol: Int)

