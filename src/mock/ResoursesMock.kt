package mock

import domain.Resources
import enum.Roles

class ResoursesMock {
    val resources = listOf(
                    Resources("A",	Roles.READ.roleName, "vasya"),
                    Resources("A.B.C",	Roles.WRITE.roleName,	"vasya"),
                    Resources("A",	Roles.EXECUTE.roleName,	"admin"),
                    Resources("A",	Roles.READ.roleName,	"admin"),
                    Resources("A",	Roles.WRITE.roleName,	"admin"),
                    Resources("A",	Roles.READ.roleName,	"admin"),
                    Resources("A",	Roles.EXECUTE.roleName,	"q"),
                    Resources("A",	Roles.EXECUTE.roleName,	"vasya")
    )
}