package com.amirreza.quizapplication.feature_authentication.data.repository;

import android.media.session.MediaSession;
import com.amirreza.quizapplication.feature_authentication.data.source.local_data_source.AuthenticationLocalDataSource;
import com.amirreza.quizapplication.feature_authentication.data.source.remote_data_source.AuthenticationRemoteDataSource;
import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenHolder;
import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenResponse;
import com.amirreza.quizapplication.feature_authentication.domain.repository.AuthenticationRepository;
import io.reactivex.Completable;
import io.reactivex.functions.Consumer;


public class AuthenticationRepositoryImpl implements AuthenticationRepository{
    private final AuthenticationRemoteDataSource remoteDataSource;
    private final AuthenticationLocalDataSource localDataSource;

    public AuthenticationRepositoryImpl(AuthenticationRemoteDataSource remoteDataSource, AuthenticationLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Completable login(String username, String password) {
        return remoteDataSource.login(username,password).doOnSuccess(new Consumer<TokenResponse>() {
            @Override
            public void accept(TokenResponse tokenResponse) throws Exception {
                onSuccessLogin(username,tokenResponse);
            }
        }).ignoreElement();
    }

    @Override
    public Completable signUp(String username, String password) {
        return remoteDataSource.signUp(username,password)
                .flatMap(s -> remoteDataSource.login(username, password))
                .doOnSuccess(tokenResponse -> {
                    onSuccessLogin(username,tokenResponse);
                }).ignoreElement();
    }

    @Override
    public void loadToken() {
        localDataSource.loadToken();
    }

    @Override
    public void saveToken(String token, String refreshToken) {
        localDataSource.saveToken(token,refreshToken);
    }

    @Override
    public void saveUserName(String username) {
        localDataSource.saveUserName(username);
    }

    private void onSuccessLogin(String username , TokenResponse tokenResponse){
        TokenHolder.INSTANCE.updateTokens(tokenResponse.getAccessToken(), tokenResponse.getRefreshToken());
        localDataSource.saveToken(tokenResponse.getAccessToken(), tokenResponse.getRefreshToken());
        localDataSource.saveUserName(username);
    }
}