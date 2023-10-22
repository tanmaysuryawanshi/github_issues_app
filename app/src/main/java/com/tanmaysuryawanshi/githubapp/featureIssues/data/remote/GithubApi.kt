package com.tanmaysuryawanshi.githubapp.featureIssues.data.remote



import com.tanmaysuryawanshi.githubapp.featureIssues.data.remote.dto.GithubItemDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("repos/{owner}/{repo}/issues?state=closed")
    suspend fun getWordInfo(
        @Path("owner") owner:String,
        @Path("repo") repo:String
    ):List<GithubItemDto>

    companion object{
        const val BASE_URL = " https://api.github.com/"
    }
}