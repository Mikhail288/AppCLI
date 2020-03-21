package services

import enum.Roles

class ResourcesService {
    fun findRoles(role: String): Boolean {
        return Roles.values().find { it.roleName == role } != null
    }
}