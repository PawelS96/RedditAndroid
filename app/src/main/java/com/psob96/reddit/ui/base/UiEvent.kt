package com.psob96.reddit.ui.base

import com.psob96.common_utils.AppError

interface UiEvent

object Events {
    class ShowToast(val message: String) : UiEvent
    class ShowLongToast(val message: String) : UiEvent
    class ShowError(val error: AppError) : UiEvent
    class OpenUrl(val url: String) : UiEvent
}
