package com.amirreza.quizapplication.feature_authentication.data.source.remote_data_source;

import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenResponse;
import com.amirreza.quizapplication.util.http.ApiService;
import io.reactivex.Single;

public class AuthenticationRemoteDataSourceImpl implements AuthenticationRemoteDataSource {
    private final ApiService apiService;

    public AuthenticationRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<TokenResponse> login(String username, String password) {
        return apiService.login(username,password);
    }

    @Override
    public Single<String> signUp(String username, String password) {
        return apiService.signUp(username, password);
    }
}