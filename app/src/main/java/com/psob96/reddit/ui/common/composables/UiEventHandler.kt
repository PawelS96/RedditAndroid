package com.psob96.reddit.ui.common.composables

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.psob96.reddit.ui.base.BaseViewModel
import com.psob96.reddit.ui.base.Events
import com.psob96.reddit.ui.common.utils.messageResId
import com.psob96.reddit.ui.common.utils.toast
import com.psob96.reddit.ui.feature_posts.PostViewEvents
import com.psob96.reddit.ui.nav.Screen
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun UiEventHandler(
    model: BaseViewModel,
    navController: NavController,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current as? AppCompatActivity
    LaunchedEffect(key1 = "") {
        scope.launch {
            model.eventFLow.collect {
                when (it) {
                    is PostViewEvents.ShowSubreddit -> navController.navigate(
                        Screen.SubredditDetails.withArgs(
                            it.subredditName
                        )
                    )
                    is PostViewEvents.ShowPostDetails -> navController.navigate(
                        Screen.PostDetails.withArgs(
                            it.post.id,
                            it.post.subreddit
                        )
                    )
                  /*  is PostViewEvents.ShowPostImage -> navController.navigate(
                        Screen.PostImage.withArgs(
                            it.post.id
                        )
                    )*/

                    is Events.ShowError -> context?.toast(it.error.messageResId)
                }
            }
        }
    }

    content()
}