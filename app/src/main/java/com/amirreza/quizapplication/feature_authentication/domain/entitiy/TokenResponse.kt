package com.amirreza.quizapplication.feature_authentication.domain.entitiy

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    val tokenName:String,
    val expiresTime:Int,
    val accessToken:String,
    val refreshToken:String
)
