package services

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


class AccountingService {
    fun parseDate(dateString: String): LocalDate? {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        var date: LocalDate?
        try {
            date = LocalDate.parse(dateString, formatter)
        } catch (ex: DateTimeParseException) {
            date = null
        }
        return date
    }

    fun validateVolume(volume: String): Boolean {
      return volume as? Int != null
    }
}