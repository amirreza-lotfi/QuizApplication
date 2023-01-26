package com.amirreza.quizapplication.feature_authentication.domain.usecases

data class AuthUseCases(
    val loginUseCase: LoginUseCase,
    val signUpUseCase: SignUpUseCase,
)
