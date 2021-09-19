package com.psob96.database.dao

import androidx.room.*
import com.psob96.database.entity.SubredditEntity

@Dao
interface SubredditDAO {

    @Query("SELECT * FROM SubredditEntity WHERE name=:name")
    suspend fun getByName(name: String): SubredditEntity?

    @Query("SELECT iconUrl FROM SubredditEntity WHERE name=:name")
    suspend fun getIconUrl(name: String): String?

    @Update
    suspend fun update(subredditEntity: SubredditEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(subredditEntity: SubredditEntity)
}