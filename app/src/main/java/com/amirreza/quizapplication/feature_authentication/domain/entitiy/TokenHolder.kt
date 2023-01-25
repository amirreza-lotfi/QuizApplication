package com.amirreza.quizapplication.feature_authentication.domain.entitiy

object TokenHolder {
    var token:String? = null
        private set
    var refreshToken:String? = null
        private set
    var username:String? = null
        private set

    fun setUsername(username:String){
        this.username = username
    }

    fun updateTokens(token: String?, refreshToken: String?){
        TokenHolder.token = token
        TokenHolder.refreshToken = refreshToken
    }
    fun userLogOut(){
        updateTokens(null,null)
    }
    fun isTokenAvailable():Boolean = !token.isNullOrEmpty()
}