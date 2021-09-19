package com.psob96.data.mappers

import com.psob96.network.models.ListingResponse
import com.psob96.domain.model.Listing

internal fun <T,R> ListingResponse<T>.toDomainListing(mapper: (T) -> R) : Listing<R> {

    return Listing(
        this.children.mapNotNull { it.data?.let { data -> mapper(data) } }.toMutableList(),
        this.after,
        this.before
    )
}

