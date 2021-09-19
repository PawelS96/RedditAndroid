package com.psob96.common_utils

import java.util.*

sealed class AppError : Throwable() {
    object Unauthenticated : AppError()
    object Offline : AppError()
    object NotFound : AppError()
    object ServerError : AppError()

    companion object {
        fun of(throwable: Throwable) : AppError {
            return Offline
        }
    }
}

