package com.psob96.network.models

data class PostWithCommentsResponse(
    val post: PostDTO,
    val comments: ListingResponse<CommentResponseDTO>?
)