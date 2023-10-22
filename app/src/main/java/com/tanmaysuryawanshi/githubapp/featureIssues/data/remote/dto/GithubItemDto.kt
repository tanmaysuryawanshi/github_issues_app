package com.tanmaysuryawanshi.githubapp.featureIssues.data.remote.dto

import com.tanmaysuryawanshi.githubapp.featureIssues.data.local.entity.IssueInfoEntity
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.githubItem

data class GithubItemDto(
    val active_lock_reason: Any,
    val assignee: AssigneeDto,
    val assignees: List<AssigneeDto>,
    val author_association: String,
    val body: String,
    val closed_at: String,
    val comments: Int,
    val comments_url: String,
    val created_at: String,
    val draft: Boolean,
    val events_url: String,
    val html_url: String,
    val id: Int,
    val labels: List<LabelDto>,
    val labels_url: String,
    val locked: Boolean,
    val milestone: Any,
    val node_id: String,
    val number: Int,
    val performed_via_github_app: Any,
    val pull_request: PullRequestDto,
    val reactions: ReactionsDto,
    val repository_url: String,
    val state: String,
    val state_reason: String,
    val timeline_url: String,
    val title: String,
    val updated_at: String,
    val url: String,
    val user: UserDto
){
    fun togithubItem():githubItem{
        return githubItem(

           author_association =  author_association,

           closed_at =  closed_at,
           created_at =  created_at,
           html_url =  html_url,
           id =  id,
           labels =  labels.map { it.toLabel() },

           number =  number,
           repository_url =  repository_url,
           title =  title,
           url =  url,
           user =  user.toUser()
        )
    }
    fun toIssueInfoEntity(): IssueInfoEntity {
return IssueInfoEntity(   author_association =  author_association,

    closed_at =  closed_at,
    created_at =  created_at,
    html_url =  html_url,
    id =  id,
    labels =  labels.map { it.toLabel() },

    number =  number,
    repository_url =  repository_url,
    title =  title,
    url =  url,
    user =  user.toUser())
    }
}