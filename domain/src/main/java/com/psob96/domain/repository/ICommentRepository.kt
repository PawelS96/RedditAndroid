package com.psob96.domain.repository

import com.psob96.common_utils.AppResult
import com.psob96.domain.model.CommentItem
import com.psob96.domain.model.Post

interface ICommentRepository {

    suspend fun getComments(post: Post): AppResult<List<CommentItem>>
}