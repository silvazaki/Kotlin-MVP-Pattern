package com.github.kotlin_mvp_pattern.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by User on 12/27/2018.
 */

object DateFormat {
    fun format(date1: String): String {

        val format = SimpleDateFormat("yyyy-MM-dd")
        var date: Date? = null
        try {
            date = format.parse(date1)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val dt1 = SimpleDateFormat("dd-MM-yyyy")
        return dt1.format(date)
    }
}
