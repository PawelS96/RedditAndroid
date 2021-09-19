package com.psob96.reddit.ui.feature_posts.post_list

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.psob96.domain.model.PostSortMode
import com.psob96.reddit.R
import com.psob96.reddit.ui.common.composables.GenericItemSelector
import com.psob96.reddit.ui.common.composables.SelectorItem

@Composable
fun PostSortModeSelector(
    selectedMode: PostSortMode,
    onSelect: (PostSortMode) -> Unit
) {
    val values = PostSortMode.values()
    GenericItemSelector(
        items = values.map {
            SelectorItem(
                name = stringResource(it.displayNameResId),
                icon = it.icon
            )
        },
        selectedIndex = values.indexOfFirst { it == selectedMode },
        selectorText = stringResource(
            R.string.posts_sorted_by,
            stringResource(selectedMode.displayNameResId)
        ),
        dialogText = stringResource(R.string.posts_sort_by),
        onSelect = { index -> onSelect(values[index]) }
    )
}

private val PostSortMode.icon: ImageVector
    get() {
        return when (this) {
            PostSortMode.BEST -> Icons.Outlined.Favorite
            PostSortMode.HOT -> Icons.Outlined.Fireplace
            PostSortMode.NEW -> Icons.Outlined.NewReleases
            PostSortMode.TOP -> Icons.Outlined.BarChart
            PostSortMode.CONTROVERSIAL -> Icons.Outlined.Dangerous
            PostSortMode.RISING -> Icons.Outlined.Timeline
        }
    }

private val PostSortMode.displayNameResId: Int
    get() {
        return when (this) {
            PostSortMode.BEST -> R.string.sort_mode_best
            PostSortMode.HOT -> R.string.sort_mode_hot
            PostSortMode.NEW -> R.string.sort_mode_new
            PostSortMode.TOP -> R.string.sort_mode_top
            PostSortMode.CONTROVERSIAL -> R.string.sort_mode_controversial
            PostSortMode.RISING -> R.string.sort_mode_rising
        }
    }

@Composable
@Preview
fun SortPreviews() {
    Column {
        for (sort in PostSortMode.values())
            PostSortModeSelector(selectedMode = sort) {}
    }
}