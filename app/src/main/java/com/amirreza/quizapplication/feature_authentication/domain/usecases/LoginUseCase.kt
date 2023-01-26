package com.amirreza.quizapplication.feature_authentication.domain.usecases

import com.amirreza.quizapplication.feature_authentication.domain.repository.AuthenticationRepository
import io.reactivex.Completable

data class LoginUseCase(
    private val authenticationRepository: AuthenticationRepository
) {
    fun doLogin(username:String, password:String):Completable{
        return authenticationRepository.login(username, password)
    }
}
