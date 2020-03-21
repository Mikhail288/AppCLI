package services

import enum.Roles
import mock.ResoursesMock

class ResourcesService {
    fun findRoles(role: String): Boolean {
        return Roles.values().find { it.roleName == role } != null
    }

    fun checkResourceAccess(login: String, res: String, role: String): Boolean {
        return ResoursesMock().resources.find { it.user == login && it.resource == res && it.role == role } != null
    }
}