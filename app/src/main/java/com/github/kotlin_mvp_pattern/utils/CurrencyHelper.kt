package com.github.kotlin_mvp_pattern.utils

object CurrencyHelper {

    fun formatRP(number: Int): String {
        return String.format("Rp. %,d", number).replace(",", ".") + ",-"
    }


    fun formatRP(number: String): String {
        var numberint = 0
        try {
            numberint = Integer.parseInt(number)
        } catch (ignored: Exception) {

        }

        return String.format("Rp. %,d", numberint).replace(",", ".") + ",-"
    }

}
