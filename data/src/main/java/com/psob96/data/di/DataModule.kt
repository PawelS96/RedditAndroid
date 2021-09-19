package com.psob96.data.di

import android.content.Context
import android.content.SharedPreferences
import com.psob96.data.repositories.Authenticator
import com.psob96.data.repositories.CommentRepository
import com.psob96.domain.repository.IAuthenticator
import com.psob96.domain.repository.IPostRepo
import com.psob96.data.repositories.PostRepo
import com.psob96.data.repositories.SubredditRepository
import com.psob96.domain.repository.ICommentRepository
import com.psob96.domain.repository.ISubredditRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DataModule {

    @Provides
    @Singleton
    fun sharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("redditclientprefs", Context.MODE_PRIVATE)
    }
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun userRepo(authenticator: Authenticator): IAuthenticator

    @Binds
    abstract fun postRepo(repo: PostRepo): IPostRepo

    @Binds
    abstract fun subredditRepo(repo: SubredditRepository) : ISubredditRepository

    @Binds
    abstract fun commentRepo(repo: CommentRepository) : ICommentRepository

}
