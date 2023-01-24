package com.amirreza.quizapplication.feature_authentication.data.source.local_data_source

interface AuthenticationLocalDataSource {
    fun loadToken()
    fun saveToken(token: String, refreshToken: String)
    fun saveUserName(username: String)
}