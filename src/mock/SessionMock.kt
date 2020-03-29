package mock

import domain.Session

class SessionMock {
    companion object {
        val session = mutableListOf<Session>()
    }

}