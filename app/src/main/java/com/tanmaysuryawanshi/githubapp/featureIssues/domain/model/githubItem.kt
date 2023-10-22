package com.tanmaysuryawanshi.githubapp.featureIssues.domain.model

import com.tanmaysuryawanshi.githubapp.featureIssues.data.remote.dto.UserDto

data class githubItem(

    val author_association: String,
    val closed_at: String,
    val created_at: String,
    val html_url: String,
    val id: Int,
    val labels: List<label>,
    val number: Int,
    val repository_url: String,
    val title: String,
    val url: String,
    val user: User
)
