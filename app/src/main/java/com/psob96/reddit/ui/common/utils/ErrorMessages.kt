package com.psob96.reddit.ui.common.utils

import com.psob96.common_utils.AppError
import com.psob96.reddit.R

val AppError.messageResId: Int
    get() {
        return when (this) {
            AppError.NotFound -> R.string.error_no_result
            AppError.Offline -> R.string.error_offline
            AppError.ServerError -> R.string.error_server
            AppError.Unauthenticated -> R.string.error_unauthenticated
        }
    }
