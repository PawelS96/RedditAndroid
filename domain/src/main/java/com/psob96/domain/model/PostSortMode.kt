package com.psob96.domain.model

enum class PostSortMode {
    BEST,
    HOT,
    NEW,
    TOP,
    CONTROVERSIAL,
    RISING;

    companion object {
        val DEFAULT_MODE = HOT
    }
}