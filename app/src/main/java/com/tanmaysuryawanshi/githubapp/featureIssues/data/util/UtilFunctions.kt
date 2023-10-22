package com.tanmaysuryawanshi.githubapp.featureIssues.data.util

import java.text.SimpleDateFormat
import java.util.Locale

fun convertDateString(input: String): String {
    try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

        val date = inputFormat.parse(input)
        return outputFormat.format(date)
    } catch (e: Exception) {
        // Handle any parsing errors here
        e.printStackTrace()
        return "" // Return an empty string or an error message
    }
}

fun convertHexColor(hexColor: String): Int {

        // Remove any leading '#' character, if present
        val cleanHex = if (hexColor.startsWith("#")) hexColor.substring(1) else hexColor
        // Convert the cleaned hex string to an integer using radix 16
        return 0xFF shl 24 or Integer.parseInt(cleanHex, 16)

}