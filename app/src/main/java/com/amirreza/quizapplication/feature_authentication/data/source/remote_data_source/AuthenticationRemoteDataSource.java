package com.amirreza.quizapplication.feature_authentication.data.source.remote_data_source;

import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenResponse;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface AuthenticationRemoteDataSource {
    Single<TokenResponse> login(String username, String password);
    Single<String> signUp(String username, String password);
}
