package com.psob96.data.repositories

import com.psob96.common_utils.AppResult
import com.psob96.common_utils.map
import com.psob96.data.mappers.toDomain
import com.psob96.domain.model.CommentItem
import com.psob96.domain.model.Post
import com.psob96.domain.repository.ICommentRepository
import com.psob96.network.endpoints.PostsEndpoint
import com.psob96.network.models.CommentDTO
import com.psob96.network.models.MoreDTO
import javax.inject.Inject

internal class CommentRepository @Inject constructor(
    private val endpoint: PostsEndpoint,
    private val userProfileImageCache: UserProfileImageCache
) : ICommentRepository {

    override suspend fun getComments(post: Post): AppResult<List<CommentItem>> {
        val result = endpoint.getComments(post.subreddit, post.id)
        return result.map { listing ->
            listing.children.mapNotNull {
                when (val data = it.data) {
                    is CommentDTO -> data.toDomain(userProfileImageCache)
                    is MoreDTO -> data.toDomain(userProfileImageCache)
                    else -> null
                }
            }
        }
    }
}
