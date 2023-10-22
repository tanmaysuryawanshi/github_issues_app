package com.tanmaysuryawanshi.githubapp.featureIssues.data.remote.dto

import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.label

data class LabelDto(
    val color: String,
    val default: Boolean,
    val description: String,
    val id: Long,
    val name: String,
    val node_id: String,
    val url: String
){
    fun toLabel():label{
        return label(color, description, id, name, url)
    }
}
