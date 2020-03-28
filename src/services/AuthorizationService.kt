package services

import domain.Resources
import enum.Roles
import mock.ResoursesMock

class AuthorizationService {
    fun findRoles(role: String): Boolean {
        return Roles.values().find { it.roleName == role } != null
    }

    fun checkResourceAccess(login: String, res: String, role: String): Boolean {
        return ResoursesMock().resources.find { it.user == login && it.resource == res && it.role == role } != null
    }

    fun isParentHaveAccess(resource: String, resources: List<Resources>, user: String, role: String): Boolean {
        val resourcesByUserAndRole = resources.filter { it.user == user && it.role == role }.map { it.resource }
        val pathArray = resource.split(".")
        var isAccessExist = false
        for (pathArrayIndex in pathArray.indices) {
            for (index in resourcesByUserAndRole.indices) {
                val isResourceEqual = resourcesByUserAndRole[index].split(".") == pathArray.slice(0..pathArrayIndex)
                if (isResourceEqual) {
                    isAccessExist = true
                }
            }
        }
        return isAccessExist
    }
}