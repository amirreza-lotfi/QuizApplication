package com.amirreza.quizapplication.feature_authentication.data.source.remote_data_source

import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenResponse

import com.amirreza.quizapplication.util.http.ApiService
import io.reactivex.Single

class AuthenticationRemoteDataSourceImpl(private val apiService: ApiService):AuthenticationRemoteDataSource {
    override fun login(username: String, password: String): Single<TokenResponse> {
        return apiService.login(username,password)
    }

    override fun signUp(username: String, password: String): Single<String> {
        return apiService.signUp(username,password)
    }
}