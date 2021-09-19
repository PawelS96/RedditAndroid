package com.psob96.reddit.ui.feature_comments

import com.psob96.domain.model.Comment
import com.psob96.domain.repository.ICommentRepository
import com.psob96.reddit.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val repo: ICommentRepository
) : BaseViewModel() {

    private val _comments = MutableStateFlow<List<Comment>>(listOf())
    val comments = _comments.asStateFlow()

    fun setPostId(id: String) {

    }

    fun addComment(text: String, replyTo: Comment) {

    }
}