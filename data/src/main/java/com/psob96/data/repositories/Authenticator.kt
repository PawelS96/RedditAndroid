package com.psob96.data.repositories

import com.psob96.domain.repository.IAuthenticator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class Authenticator @Inject constructor() : IAuthenticator {

    // TODO add real authentication

    private var isLoggedIn = false

    override fun isLoggedIn(): Boolean {
        return isLoggedIn
    }

    override fun signIn(): Boolean {
        isLoggedIn = true
        return true
    }
}