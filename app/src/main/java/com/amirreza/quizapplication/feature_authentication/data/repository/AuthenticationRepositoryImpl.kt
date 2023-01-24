package com.amirreza.quizapplication.feature_authentication.data.repository

import com.amirreza.quizapplication.feature_authentication.data.source.remote_data_source.AuthenticationRemoteDataSource

class AuthenticationRepositoryImpl(
    val remoteDataSource: AuthenticationRemoteDataSource,
    val localDataSource: AuthenticationRemoteDataSource
) {
}