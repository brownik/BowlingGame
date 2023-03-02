package com.brownik.bowling_game.common_util.extension

import android.content.Context
import android.util.DisplayMetrics
import java.text.DecimalFormat

fun Number.toMoneyFormat(): String {
    val decimalFormat = DecimalFormat("#,###,###,###")
    return decimalFormat.format(this.toInt())
}

fun Number.toPx(context: Context): Int {
    val densityDpi = context.resources.displayMetrics.densityDpi
    return (this.toFloat() * (densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
}

fun Number.toDp(context: Context): Float {
    val densityDpi = context.resources.displayMetrics.densityDpi
    return this.toFloat() / (densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

fun Long.toTimeFormat(): String {
    val hour = this / (60 * 60) % 24
    val minute = (this / 60) % 60
    val second = this % 60
    return if (hour > 0) String.format("%02d : %02d : %02d", hour, minute, second)
    else String.format("%02d : %02d", minute, second)
}

fun String?.numberCheck(): Boolean{
    return try {
        this!!.toInt()
        true
    } catch (e : Exception) {
        false
    }
}
