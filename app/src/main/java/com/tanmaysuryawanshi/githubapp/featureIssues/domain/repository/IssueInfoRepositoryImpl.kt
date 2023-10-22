package com.tanmaysuryawanshi.githubapp.featureIssues.domain.repository

import android.util.Log
import com.tanmaysuryawanshi.githubapp.core.util.Resource
import com.tanmaysuryawanshi.githubapp.featureIssues.data.local.IssueInfoDoa
import com.tanmaysuryawanshi.githubapp.featureIssues.data.remote.GithubApi
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.githubItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class IssueInfoRepositoryImpl(
    private val api: GithubApi,
   private val dao: IssueInfoDoa
): IssueInfoRepository {

    override fun getWordInfo(title:String): Flow<Resource<List<githubItem>>> =flow{
        Log.d("check", "getWordInfo: repository start")
     emit(Resource.Loading())
        Log.d("check", "getWordInfo: repository loading")
    val issuesInfos=dao.getWordInfos(title).map{it.toIssueInfo()}
     emit(Resource.Loading(issuesInfos))
try {
    Log.d("check", "getWordInfo: repository try start")
val remoteIssueInfos=api.getWordInfo("langchain-ai", "langchain")
    Log.d("check", "getWordInfo: repository try susccess")
    dao.deleteWordInfos(remoteIssueInfos.map { it.title })
    dao.insertWordInfos(remoteIssueInfos.map{it.toIssueInfoEntity()})
//emit(Resource.Success(remoteIssueInfos.map { it.togithubItem() }))
}catch (e:HttpException){
    Log.d("check", "getWordInfo: repository http error"+e.message)
    emit(Resource.Error("Something went wrong",))
}
        catch (e:IOException){
            Log.d("check", "getWordInfo: repository IO error"+e.message)
            emit(Resource.Error("Couldn't reach Server"))
        }
        catch (e:Exception){
            Log.d("check", "getWordInfo: repository general error"+e.message)
            emit(Resource.Error("Exception Occured"))
        }

        val newIssueInfos=dao.getWordInfos(title).map { it.toIssueInfo() }
        emit(Resource.Success(newIssueInfos))
    }

}