package com.tanmaysuryawanshi.githubapp.featureIssues.presentation

import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.githubItem


data class IssueInfoState(
    val issueInfoItems:List<githubItem> = emptyList(),
    val isLoading:Boolean=false
)
