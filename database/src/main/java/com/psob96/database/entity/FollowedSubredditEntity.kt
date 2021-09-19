package com.psob96.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FollowedSubredditEntity(
    @PrimaryKey
    val name: String,
    var isFavorite: Boolean
)