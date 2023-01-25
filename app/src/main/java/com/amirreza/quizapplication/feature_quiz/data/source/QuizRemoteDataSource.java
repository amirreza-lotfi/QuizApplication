package com.amirreza.quizapplication.feature_quiz.data.source;

import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;

import java.util.List;

import io.reactivex.Single;

public class QuizRemoteDataSource implements QuizDataSourceI {

    @Override
    public Single<Quiz> getQuizzes() {
        return null;
    }
}
