package com.psob96.domain.model

data class PostWithComments(
    val post: Post,
    val comments: List<CommentItem>
)
