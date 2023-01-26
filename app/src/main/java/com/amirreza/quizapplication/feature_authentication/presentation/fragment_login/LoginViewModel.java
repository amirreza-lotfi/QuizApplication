package com.amirreza.quizapplication.feature_authentication.presentation.fragment_login;

import com.amirreza.quizapplication.feature_authentication.domain.usecases.AuthUseCases;
import com.amirreza.quizapplication.util.base.QuizBaseViewModel;

import io.reactivex.Completable;
import io.reactivex.functions.Action;

public class LoginViewModel extends QuizBaseViewModel {
    private AuthUseCases authUseCases;

    public LoginViewModel(AuthUseCases authUseCases) {
        this.authUseCases = authUseCases;
    }

    public Completable login(String username, String password){
        showProgressBar(true);
        return authUseCases.getLoginUseCase().doLogin(username,password).doFinally(() -> showProgressBar(false));

    }
}
