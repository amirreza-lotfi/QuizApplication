package com.amirreza.quizapplication.feature_authentication.data.repository

import com.amirreza.quizapplication.feature_authentication.data.source.remote_data_source.AuthenticationRemoteDataSource
import com.amirreza.quizapplication.feature_authentication.domain.repository.AuthenticationRepository
import io.reactivex.Completable

class AuthenticationRepositoryImpl(
    val remoteDataSource: AuthenticationRemoteDataSource,
    val localDataSource: AuthenticationRemoteDataSource
) : AuthenticationRepository{
    override fun login(username: String?, password: String?): Completable {
        TODO("Not yet implemented")
    }

    override fun signUp(username: String?, password: String?): Completable {
        TODO("Not yet implemented")
    }

    override fun loadToken() {
        TODO("Not yet implemented")
    }

    override fun saveToken(token: String?, refreshToken: String?) {
        TODO("Not yet implemented")
    }

    override fun saveUserName(username: String?) {
        TODO("Not yet implemented")
    }


}