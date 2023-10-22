package com.tanmaysuryawanshi.githubapp.featureIssues.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ReactionsDto(
    @SerializedName("+1")
    val plusOne: Int,
    @SerializedName("-1")
    val minusOne: Int,
    val confused: Int,
    val eyes: Int,
    val heart: Int,
    val hooray: Int,
    val laugh: Int,
    val rocket: Int,
    val total_count: Int,
    val url: String
)