package com.example.listfilm.extension

import java.text.SimpleDateFormat
import java.util.*

fun String.dateToString(): String {
    val dataArray = this.split("-")
    return "${dataArray[2]}/${dataArray[1]}/${dataArray[0]}"
}