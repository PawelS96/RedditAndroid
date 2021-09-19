package com.psob96.network.endpoints

import com.psob96.common_utils.AppResult
import com.psob96.network.RedditApiService
import com.psob96.network.mapToDataResult
import com.psob96.network.models.SubredditAboutDTO
import com.psob96.network.safeCall
import javax.inject.Inject
import javax.inject.Singleton

interface SubredditsEndpoint {
    suspend fun getSubreddit(name: String): AppResult<SubredditAboutDTO>
}

@Singleton
internal class SubredditsEndpointImpl @Inject constructor(
    private val service: RedditApiService
) : SubredditsEndpoint {
    override suspend fun getSubreddit(name: String): AppResult<SubredditAboutDTO> {
        return safeCall { service.getSubredditInfo(name) }.mapToDataResult()
    }
}