package com.amirreza.quizapplication.feature_authentication.domain.repository;

import io.reactivex.Completable;

public interface AuthenticationRepository {
    public Completable login(String username, String password);
    public Completable signUp(String username, String password);
    public void loadToken();
    public void saveToken(String token, String refreshToken);
    public void saveUserName(String username);
}
