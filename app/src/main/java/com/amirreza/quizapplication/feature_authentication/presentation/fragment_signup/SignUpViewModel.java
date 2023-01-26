package com.amirreza.quizapplication.feature_authentication.presentation.fragment_signup;

import com.amirreza.quizapplication.feature_authentication.domain.usecases.AuthUseCases;
import com.amirreza.quizapplication.util.base.QuizBaseViewModel;

import io.reactivex.Completable;

public class SignUpViewModel extends QuizBaseViewModel {
    private AuthUseCases authUseCases;

    public SignUpViewModel(AuthUseCases authUseCases) {
        this.authUseCases = authUseCases;
    }

    public Completable signUp(String username, String password){
        showProgressBar(true);
        return authUseCases.getSignUpUseCase().doSignUp(username,password).doFinally(() -> showProgressBar(false));
    }
}
