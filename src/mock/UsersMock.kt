package mock

import domain.User

class UsersMock {
    val users = listOf(
            User("vasya", "123"),
            User("admin", "admin"),
            User("q", "?!#"),
            User("abcdefghij", "qwerty")
    )
}