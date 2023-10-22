package com.tanmaysuryawanshi.githubapp.featureIssues.domain.model

data class User(
    val avatar_url: String,
    val events_url: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val type: String,
    val url: String
)
