package com.psob96.domain.usecase

import com.psob96.common_utils.AppError
import com.psob96.common_utils.AppResult
import com.psob96.domain.model.Post
import com.psob96.domain.model.VoteType
import com.psob96.domain.repository.IAuthenticator
import com.psob96.domain.repository.IPostRepo
import javax.inject.Inject

class VoteUseCase @Inject constructor(
    private val userRepo: IAuthenticator,
    private val postRepo: IPostRepo
) {
    suspend fun vote(
        post: Post,
        isUpvote: Boolean
    ): AppResult<Post> {

        if (!userRepo.isLoggedIn()) {
            return AppResult.failed(AppError.Unauthenticated)
        }

        val newVote = if (isUpvote) VoteType.UPVOTE else VoteType.DOWNVOTE
        val modifier = if (isUpvote) 1 else -1

        when (post.vote) {
            VoteType.NONE -> {
                post.vote = newVote
                post.score += modifier
            }
            newVote -> {
                post.vote = VoteType.NONE
                post.score -= modifier
            }
            else -> {
                post.vote = newVote
                post.score += modifier * 2
            }
        }

       return when (val result = postRepo.vote(post, post.vote)) {
           is AppResult.Error -> result
           is AppResult.Success -> AppResult.success(post)
       }
    }
}