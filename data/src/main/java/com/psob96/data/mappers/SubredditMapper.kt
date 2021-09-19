package com.psob96.data.mappers

import com.psob96.database.entity.SubredditEntity
import com.psob96.domain.model.Subreddit
import com.psob96.network.models.SubredditAboutDTO

internal fun SubredditAboutDTO.toDomainSubreddit(): Subreddit? {
    return Subreddit(
        name = name ?: "",
        description = description.orEmpty(),
        subscriptions = subs ?: 0,
        activeUsers = activeUsers ?: 0,
        icon = image.url() ?: icon?.url(),
        backgroundImage = backgroundImage?.url() ?: bannerImage?.url(),
        keyColor = keyColor?.takeIf { it.isNotEmpty() }
    )
}

internal fun Subreddit.mapToEntity() : SubredditEntity {
    return SubredditEntity(
        name = name,
        description = description,
        subscriptions = subscriptions,
        activeUsers = activeUsers,
        backgroundImage = backgroundImage,
        keyColor = keyColor,
        iconUrl = icon,
        dateModified = System.currentTimeMillis(),
    )
}

internal fun SubredditEntity.mapToDomain() : Subreddit {
    return Subreddit(
        name = name,
        description = description,
        subscriptions = subscriptions,
        activeUsers = activeUsers,
        backgroundImage = backgroundImage,
        keyColor = keyColor,
        icon = iconUrl
    )
}

private fun String?.url(): String? = takeIf { this?.isNotEmpty() == true }?.substringBefore("?")
