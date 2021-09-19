package com.psob96.network.di

import com.psob96.network.endpoints.PostsEndpoint
import com.psob96.network.endpoints.SubredditsEndpoint
import com.psob96.network.endpoints.PostsEndpointImpl
import com.psob96.network.endpoints.SubredditsEndpointImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class EndpointModule {

    @Binds
    abstract fun bindPostsEndpoint(impl: PostsEndpointImpl): PostsEndpoint

    @Binds
    abstract fun bindSubredditsEndpoint(impl: SubredditsEndpointImpl): SubredditsEndpoint
}