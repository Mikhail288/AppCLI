package services

import domain.Session
import enum.Roles
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


class AccountingService(private val sessions: MutableList<Session>) {
    fun parseDate(dateString: String): LocalDate? {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date: LocalDate?
        date = try {
            LocalDate.parse(dateString, formatter)
        } catch (ex: DateTimeParseException) {
            null
        }
        return date
    }

    fun validateVolume(volume: String) = volume.toIntOrNull() != null

    fun addNewSession(
            user: String,
            res: String,
            role: Roles,
            ds: String,
            de: String,
            vol: Int
    ) {
        sessions += Session(user, role, res, ds, de, vol)
    }
}