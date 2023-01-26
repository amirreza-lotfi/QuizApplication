package com.amirreza.quizapplication.feature_authentication.domain.usecases

import com.amirreza.quizapplication.feature_authentication.domain.repository.AuthenticationRepository
import io.reactivex.Completable

data class SignUpUseCase(
    private val authenticationRepository: AuthenticationRepository
) {
    fun doSignUp(username:String, password:String): Completable {
        return authenticationRepository.signUp(username, password)
    }
}