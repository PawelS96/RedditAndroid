package com.psob96.reddit.ui.feature_comments

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.psob96.domain.model.CommentSortMode
import com.psob96.reddit.R
import com.psob96.reddit.ui.common.composables.GenericItemSelector
import com.psob96.reddit.ui.common.composables.SelectorItem

@Composable
fun CommentSortModeSelector(
    selectedMode: CommentSortMode,
    onSelect: (CommentSortMode) -> Unit
) {
    val values = CommentSortMode.values()
    GenericItemSelector(
        items = values.map {
            SelectorItem(
                name = stringResource(it.displayNameResId),
                icon = it.icon
            )
        },
        selectedIndex = values.indexOfFirst { it == selectedMode },
        selectorText = stringResource(
            R.string.comments_sorted_by,
            stringResource(selectedMode.displayNameResId)
        ),
        dialogText = stringResource(R.string.comments_sort_by),
        onSelect = { index -> onSelect(values[index]) }
    )
}

private val CommentSortMode.icon: ImageVector
    get() {
        return when (this) {
            CommentSortMode.BEST -> Icons.Outlined.Favorite
            CommentSortMode.NEW -> Icons.Outlined.NewReleases
            CommentSortMode.TOP -> Icons.Outlined.BarChart
            CommentSortMode.CONTROVERSIAL -> Icons.Outlined.Dangerous
            CommentSortMode.OLD -> Icons.Outlined.Timer
            CommentSortMode.QA -> Icons.Outlined.QuestionAnswer
        }
    }

private val CommentSortMode.displayNameResId: Int
    get() {
        return when (this) {
            CommentSortMode.BEST -> R.string.sort_mode_best
            CommentSortMode.NEW -> R.string.sort_mode_new
            CommentSortMode.TOP -> R.string.sort_mode_top
            CommentSortMode.CONTROVERSIAL -> R.string.sort_mode_controversial
            CommentSortMode.OLD -> R.string.sort_mode_old
            CommentSortMode.QA -> R.string.sort_mode_qa
        }
    }

@Composable
@Preview
fun SortPreviews() {
    Column {
        for (sort in CommentSortMode.values())
            CommentSortModeSelector(selectedMode = sort) {}
    }
}