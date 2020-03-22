package services


import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import kotlin.system.exitProcess


class DateService {
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
}