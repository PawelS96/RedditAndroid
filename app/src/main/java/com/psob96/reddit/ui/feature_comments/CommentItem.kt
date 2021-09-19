package com.psob96.reddit.ui.feature_comments

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.psob96.domain.model.Comment
import com.psob96.domain.model.CommentItem
import com.psob96.domain.model.MoreComments
import com.psob96.domain.model.UserProfileImage
import com.psob96.reddit.R
import com.psob96.reddit.ui.common.composables.VoteBarSize
import com.psob96.reddit.ui.common.composables.VoteButtons
import com.psob96.reddit.ui.common.utils.formatPostDate
import com.psob96.reddit.ui.common.utils.formatPostScore

@Composable
fun CommentListItem(
    item: CommentItem,
    onVote: (Boolean) -> Unit,
    onClickShowMore: (MoreComments) -> Unit
) {
    Row(Modifier.height((IntrinsicSize.Max))) {
        repeat(item.depth) { depth ->
            val isLastBar = depth == item.depth - 1
            val colorValue = 64 + 16 * depth
            val lineColor = Color(red = colorValue, green = colorValue, blue = colorValue)
            val isFirstReply = when (item) {
                is Comment -> item.isFirstReply
                is MoreComments -> false
            }

            val isLastReply = when (item) {
                is Comment -> item.isLastReply
                is MoreComments -> false
            }

            Box(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = if (isFirstReply && isLastBar) 4.dp else 0.dp,
                        bottom = if (isLastReply && isLastBar) 4.dp else 0.dp,
                    )
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(color = lineColor)
            )
        }

        when (item) {
            is Comment -> {
                Card(
                    Modifier.padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    ),
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                    ) {
                        CommentHeader(comment = item)
                        Spacer(modifier = Modifier.size(width = 0.dp, height = 8.dp))
                        Text(
                            item.text,
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = MaterialTheme.colors.onBackground
                            )
                        )
                        Spacer(modifier = Modifier.size(width = 0.dp, height = 8.dp))
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                            VoteButtons(
                                score = formatPostScore(item.score),
                                vote = item.myVote,
                                canVote = !item.isArchived,
                                size = VoteBarSize.SMALL,
                                onVote = onVote
                            )
                        }
                    }
                }
            }
            is MoreComments -> {
                val replyCount = item.count
                val text = when {
                    replyCount > 1 -> stringResource(R.string.comments_replies_many, replyCount)
                    replyCount == 1 -> stringResource(R.string.comments_replies_one)
                    else -> stringResource(R.string.comments_replies_continue)
                }

                Row(
                    Modifier
                        .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                        .clickable { onClickShowMore(item) }
                ) {
                    Text(
                        text = text, style = TextStyle(
                            fontSize = 14.sp,
                            color = MaterialTheme.colors.primary
                        )
                    )
                }
            }
        }
    }
}


@Composable
fun UserProfilePic(image: UserProfileImage) {

    when (image) {
        is UserProfileImage.CustomImage -> {

        }
        is UserProfileImage.DefaultImage -> {
            Icon(
                imageVector = Icons.Filled.Person,
                tint = Color(image.color),
                modifier = Modifier.size(20.dp),
                contentDescription = ""
            )
        }
    }
}

@Composable
private fun CommentHeader(comment: Comment) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        UserProfilePic(image = comment.authorImage)
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            comment.authorName,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = if (comment.isPostAuthor) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
            )
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            formatPostDate(comment.date),
            style = TextStyle(
                fontSize = 10.sp,
                color = MaterialTheme.colors.onBackground
            )
        )
    }
}

