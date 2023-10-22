package com.tanmaysuryawanshi.githubapp.featureIssues.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tanmaysuryawanshi.githubapp.featureIssues.data.local.entity.IssueInfoEntity

@Database(
    entities = [IssueInfoEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class IssueInfoDatabase:RoomDatabase() {
    abstract val dao: IssueInfoDoa
}