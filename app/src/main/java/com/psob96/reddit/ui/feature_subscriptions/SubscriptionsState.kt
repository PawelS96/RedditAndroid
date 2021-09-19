package com.psob96.reddit.ui.feature_subscriptions

import com.psob96.domain.model.Subreddit

data class SubscriptionsState(
    private val key: Int = 0,
    val favorites: MutableList<Subreddit> = mutableListOf(),
    val all: MutableList<Subreddit> = mutableListOf(),
    val recent: List<Subreddit> = mutableListOf()
)