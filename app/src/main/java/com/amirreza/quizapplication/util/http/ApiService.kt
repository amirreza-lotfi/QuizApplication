package com.amirreza.quizapplication.util.http

import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenResponse
import com.amirreza.quizapplication.feature_authentication.domain.entitiy.User
import com.amirreza.quizapplication.util.Constant
import io.reactivex.Single

interface ApiService {

    fun login(username: String, password: String): Single<TokenResponse>{
        /*
         * Its Just For Test
         * */
        return if(User(username, password) in userListSimulator){
            Single.just(
                TokenResponse(
                    Constant.TOKEN_NAME,
                    Integer.MAX_VALUE,
                    Constant.ACCESS_TOKEN,
                    Constant.REFRESH_TOKEN
                )
            )
        }else{
            Single.error(Exception("Login not succeed!!"))
        }

    }

    fun signUp(username: String, password: String): Single<String> {
        /*
         * Its Just For Test
         * */
        userListSimulator.add(User(username,password))
        return Single.just(
            Constant.ACCESS_TOKEN
        )
    }
}
val userListSimulator = mutableListOf<User>()

