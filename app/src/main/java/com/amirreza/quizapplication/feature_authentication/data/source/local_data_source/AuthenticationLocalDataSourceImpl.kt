package com.amirreza.quizapplication.feature_authentication.data.source.local_data_source

import android.content.SharedPreferences
import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenHolder

class AuthenticationLocalDataSourceImpl(private val sharedPreferences: SharedPreferences):AuthenticationLocalDataSource {
    override fun loadToken() {
        TokenHolder.updateTokens(
            sharedPreferences.getString("access_token", null),
            sharedPreferences.getString("refresh_token", null),
        )
    }

    override fun saveToken(token: String, refreshToken: String) {
        sharedPreferences.edit().apply{
            putString("access_token",token)
            putString("refresh_token",refreshToken)
        }.apply()
    }

    override fun saveUserName(username: String) {
        TokenHolder.setUsername(username)
        sharedPreferences.edit().apply{
            putString("username",username)
        }.apply()
    }
}