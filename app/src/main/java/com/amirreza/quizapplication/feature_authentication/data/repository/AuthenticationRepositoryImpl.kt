package com.amirreza.quizapplication.feature_authentication.data.repository

import android.media.session.MediaSession
import com.amirreza.quizapplication.feature_authentication.data.source.local_data_source.AuthenticationLocalDataSource
import com.amirreza.quizapplication.feature_authentication.data.source.remote_data_source.AuthenticationRemoteDataSource
import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenHolder
import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenResponse
import com.amirreza.quizapplication.feature_authentication.domain.repository.AuthenticationRepository
import io.reactivex.Completable

class AuthenticationRepositoryImpl(
    private val remoteDataSource: AuthenticationRemoteDataSource,
    private val localDataSource: AuthenticationLocalDataSource
) : AuthenticationRepository{
    override fun login(username: String, password: String): Completable {
        return remoteDataSource.login(username, password).doOnSuccess {
            onSuccessLogin(username,it)
        }.ignoreElement()
    }

    override fun signUp(username: String, password: String): Completable {
        return remoteDataSource.signUp(username,password)
            .flatMap {
                remoteDataSource.login(username, password)
            }.doOnSuccess {
                onSuccessLogin(username,it)
            }.ignoreElement()
    }

    override fun loadToken() {
        return localDataSource.loadToken()
    }

    override fun saveToken(token: String, refreshToken: String) {
        return localDataSource.saveToken(token,refreshToken)
    }

    override fun saveUserName(username: String) {
        return localDataSource.saveUserName(username)
    }

    private fun onSuccessLogin(username: String,tokenResponse: TokenResponse){
        TokenHolder.updateTokens(tokenResponse.accessToken,tokenResponse.refreshToken)
        localDataSource.saveToken(tokenResponse.accessToken,tokenResponse.refreshToken)
        localDataSource.saveUserName(username)
    }

}