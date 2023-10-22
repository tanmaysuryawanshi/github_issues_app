package com.tanmaysuryawanshi.githubapp.featureIssues.domain.repository


import com.tanmaysuryawanshi.githubapp.core.util.Resource
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.githubItem
import kotlinx.coroutines.flow.Flow

interface IssueInfoRepository {

    fun getWordInfo(title:String): Flow<Resource<List<githubItem>>>
}