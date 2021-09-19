package com.psob96.domain.repository

interface IAuthenticator {

    fun isLoggedIn(): Boolean

    fun signIn(): Boolean
}