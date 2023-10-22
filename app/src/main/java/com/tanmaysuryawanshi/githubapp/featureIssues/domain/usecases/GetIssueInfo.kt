package com.tanmaysuryawanshi.githubapp.featureIssues.domain.usecases



import android.util.Log
import com.tanmaysuryawanshi.githubapp.core.util.Resource
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.githubItem
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.repository.IssueInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetIssueInfo(private val repository: IssueInfoRepository) {

    operator fun invoke(word:String):
            Flow<Resource<List<githubItem>>> {
        if(word.isBlank()){
           return repository.getWordInfo("")
            Log.d("check", "invoke: use case blank text")
        }
        Log.d("check", "invoke: use case not blank text")
        return repository.getWordInfo(word)
    }

}