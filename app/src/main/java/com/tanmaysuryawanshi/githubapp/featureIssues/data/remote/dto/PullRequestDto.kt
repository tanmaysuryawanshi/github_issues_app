package com.tanmaysuryawanshi.githubapp.featureIssues.data.remote.dto

data class PullRequestDto(
    val diff_url: String,
    val html_url: String,
    val merged_at: String,
    val patch_url: String,
    val url: String
)