package util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun toDate(date: String, format: String = "dd/MM/yyyy HH:mm:ss"): LocalDateTime
        = LocalDateTime.parse(date.trim(), DateTimeFormatter.ofPattern(format))
