package com.amirreza.quizapplication.feature_authentication.data.source.local_data_source

import android.content.SharedPreferences

class AuthenticationLocalDataSourceImpl(private val sharedPreferences: SharedPreferences):AuthenticationLocalDataSource {
    override fun loadToken() {
        TODO("Not yet implemented")
    }

    override fun saveToken(token: String, refreshToken: String) {
        TODO("Not yet implemented")
    }

    override fun saveUserName(username: String) {
        TODO("Not yet implemented")
    }
}