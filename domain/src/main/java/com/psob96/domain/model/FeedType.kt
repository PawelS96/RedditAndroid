package com.psob96.domain.model

sealed class FeedType {
    object Popular : FeedType()
    class Subreddit(val name: String) : FeedType()
    class PostDetails(val postId: String) : FeedType()
}