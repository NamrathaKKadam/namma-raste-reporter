package com.nammaraste.reporter.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object TicketGenerator {
    fun generateTicketId(): String {
        val year = SimpleDateFormat("yyyy", Locale.getDefault()).format(Date())
        val random = (1000..9999).random()
        return "NR-$year-$random"
    }
}
