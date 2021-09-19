package com.psob96.data.mappers

import com.psob96.data.repositories.UserProfileImageCache
import com.psob96.domain.model.*
import com.psob96.network.models.CommentDTO
import com.psob96.network.models.CommentResponseDTO
import com.psob96.network.models.MoreDTO

internal fun CommentResponseDTO.toDomain(userProfileImageCache: UserProfileImageCache): CommentItem {
    return when (this) {
        is MoreDTO -> toDomain()
        is CommentDTO -> toDomain(userProfileImageCache)
    }
}

internal fun CommentDTO.toDomain(userProfileImageCache: UserProfileImageCache): Comment {

    val children = childComments?.children ?: listOf()

    return Comment(
        id = id,
        authorId = authorId.orEmpty(),
        authorName = authorName.orEmpty(),
        text = body.orEmpty(),
        awards = Awards(0, listOf()),
        date = dateCreated,
        score = score,
        itemDepth = depth,
        myVote = VoteType.NONE,
        isPostAuthor = isPostAuthor,
        replies = children.mapNotNull { it.data?.toDomain(userProfileImageCache) },
        authorImage = userProfileImageCache.getImageForUserId(authorId.toString()),
    )
}

private fun MoreDTO.toDomain(): MoreComments {
    return MoreComments(count, depth)
}