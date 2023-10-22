package com.tanmaysuryawanshi.githubapp.featureIssues.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.User
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.githubItem
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.label

@Entity
data class IssueInfoEntity(val author_association: String,

                           val closed_at: String,
                           val created_at: String,
                           val html_url: String,
                           val labels: List<label>,
                           val number: Int,
                           val repository_url: String,
                           val title: String,
                           val url: String,
                           val user: User,
     @PrimaryKey val id:Int
)
{
    fun toIssueInfo():githubItem{
        return githubItem( author_association =  author_association,

            closed_at =  closed_at,
            created_at =  created_at,
            html_url =  html_url,
            id =  id,
            labels =  labels,

            number =  number,
            repository_url =  repository_url,
            title =  title,
            url =  url,
            user =  user)
    }
}