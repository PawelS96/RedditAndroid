package com.psob96.reddit.ui.feature_comments

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.psob96.reddit.R
import com.psob96.reddit.ui.common.FontsSizes
import com.psob96.reddit.ui.theme.AppTheme
import com.psob96.reddit.ui.theme.inputBackground
import com.psob96.reddit.ui.theme.isDark
import com.psob96.reddit.ui.theme.onInputBackground

@Composable
fun CommentInput(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.comments_add),
            fontSize = FontsSizes.small,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(MaterialTheme.colors.inputBackground)
                .clickable { }
                .padding(8.dp),
            color = MaterialTheme.colors.onInputBackground
        )
    }
}

@Preview
@Composable
fun CommentInputPreviewDark() {
    isDark.value = true
    AppTheme {
        CommentInput()
    }
}

@Preview
@Composable
fun CommentInputPreviewLight() {
    isDark.value = false
    AppTheme {
        CommentInput()
    }
}