package com.psob96.domain.repository

import com.psob96.common_utils.AppResult
import com.psob96.domain.model.Subreddit
import kotlinx.coroutines.flow.Flow

interface ISubredditRepository {
    fun observeRecentlyVisited(): Flow<List<Subreddit>>

    suspend fun visited(subreddit: String)

    suspend fun deleteFromVisited(subreddit: String)

    suspend fun changeSubscriptionState(subreddit: Subreddit): AppResult<Subreddit>

    suspend fun setFavorite(subreddit: Subreddit, favorite: Boolean): AppResult<Unit>

    suspend fun getSubreddit(name: String, reload: Boolean = true): Subreddit?

    suspend fun getSubscribedSubreddits(): Flow<List<Subreddit>>

    suspend fun getSubredditIcon(name: String): String?

    fun getSubredditFlow(name: String): Flow<Subreddit?>
}