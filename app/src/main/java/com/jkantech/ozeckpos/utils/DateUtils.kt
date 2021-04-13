package com.jkantech.ozeckpos.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    @Throws(ParseException::class)
    fun getDate(date: String?): Date {

        return getDate(date, "yyyy-MM-dd HH:mm:ss")

    }

    @Throws(ParseException::class)
    fun getDate(date: String?, srcFormat: String?): Date {
        return getDate(date, srcFormat, Locale.ENGLISH)
    }

    @Throws(ParseException::class)
    fun getDate(date: String?, srcFormat: String?, locale: Locale?): Date {
        return SimpleDateFormat(srcFormat, locale).parse(date)!!
    }

    @SuppressLint("SimpleDateFormat")
    fun formatDate(date: Date?, format: String?): String {
        val sdf = SimpleDateFormat(format)
        return sdf.format(date)
    }

    fun formatDate(date: Long, destFormat: String?, locale: Locale?): String {
        val sdf = SimpleDateFormat(destFormat, locale)
        return sdf.format(Date(date))
    }

    @JvmOverloads
    @JvmStatic
    @Throws(ParseException::class)
     fun formatDate(date: String?, srcFormat: String?, destFormat: String?, locale: Locale? = Locale.ENGLISH): String {
        val sdf = SimpleDateFormat(destFormat!!, Locale.FRANCE)
        return sdf.format(getDate(date!!, srcFormat!!,locale))
    }

    val date: Date
        get() = Date()

    private fun getFromCurrentDate(format: String?, locale: Locale?, dayInterval: Int): String {
        val sdf = SimpleDateFormat(format, locale)
        val ca = Calendar.getInstance()
        ca.add(Calendar.DAY_OF_YEAR, dayInterval)
        return sdf.format(ca.time)
    }

    fun getFromCurrentDate(format: String?, dayInterval: Int): String {
        return getFromCurrentDate(format, Locale.ENGLISH, dayInterval)
    }

    fun getCurrentDate(format: String?, locale: Locale?): String {
        val sdf = SimpleDateFormat(format, locale)
        return sdf.format(date)
    }

    fun getCurrentDate(format: String?): String {
        return getCurrentDate(format, Locale.ENGLISH)
    }

    val currentDateTime: String
        get() {
            val f = "yyyy-MM-dd HH:mm:ss"
            return getCurrentDate(f)
        }

    fun now(): String {
        return currentDateTime
    }
}