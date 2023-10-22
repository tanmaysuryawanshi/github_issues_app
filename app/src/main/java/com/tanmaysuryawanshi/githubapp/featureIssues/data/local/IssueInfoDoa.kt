package com.tanmaysuryawanshi.githubapp.featureIssues.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tanmaysuryawanshi.githubapp.featureIssues.data.local.entity.IssueInfoEntity

@Dao
interface IssueInfoDoa {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos:List<IssueInfoEntity>)

    @Query("DELETE FROM IssueInfoEntity WHERE title IN(:titles)")
    suspend fun deleteWordInfos(titles:List<String>)

    @Query("SELECT * FROM issueinfoentity WHERE title LIKE '%' || :title ||'%'")
    suspend fun getWordInfos(title:String):List<IssueInfoEntity>

}