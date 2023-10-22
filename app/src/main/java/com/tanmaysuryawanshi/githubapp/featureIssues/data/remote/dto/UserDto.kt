package com.tanmaysuryawanshi.githubapp.featureIssues.data.remote.dto

import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.User

data class UserDto(
    val avatar_url: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
)
{
    fun toUser():User{
        return User(
            avatar_url,
            events_url,
            html_url,
            id,
            login,
            type,
            url
        )
    }
}