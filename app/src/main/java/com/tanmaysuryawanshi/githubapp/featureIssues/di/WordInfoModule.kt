package com.tanmaysuryawanshi.githubapp.featureIssues.di

import android.app.Application
import androidx.room.Room
import com.tanmaysuryawanshi.githubapp.featureIssues.data.util.GsonParser

import com.tanmaysuryawanshi.githubapp.featureIssues.data.remote.GithubApi
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.repository.IssueInfoRepository
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.repository.IssueInfoRepositoryImpl
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.usecases.GetIssueInfo
import com.google.gson.Gson
import com.tanmaysuryawanshi.githubapp.featureIssues.data.local.Converters
import com.tanmaysuryawanshi.githubapp.featureIssues.data.local.IssueInfoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWorldInfoUseCase(repository: IssueInfoRepository): GetIssueInfo {
        return GetIssueInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db:IssueInfoDatabase,
        api: GithubApi
    ): IssueInfoRepository {
        return IssueInfoRepositoryImpl(api,db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app:Application): IssueInfoDatabase
    {
        return Room.databaseBuilder(
            app,
            IssueInfoDatabase::class.java,"word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun providesDictionaryApi(): GithubApi {
        return Retrofit.Builder()
            .baseUrl(GithubApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }

}