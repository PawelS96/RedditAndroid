package com.psob96.domain.model

data class Listing<T> (
    val items: MutableList<T>,
    val after: String?,
    val before: String?
) : MutableList<T> by items