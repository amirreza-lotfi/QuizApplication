package com.amirreza.quizapplication.feature_authentication.data.source.remote_data_source

import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenResponse
import com.amirreza.quizapplication.util.ApiService
import io.reactivex.Single

class AuthenticationRemoteDataSourceImpl(private val apiService: ApiService):AuthenticationRemoteDataSource {
    override fun login(username: String?, password: String?): Single<TokenResponse> {
        TODO("Not yet implemented")
    }

    override fun signUp(username: String?, password: String?): Single<String> {
        TODO("Not yet implemented")
    }
}