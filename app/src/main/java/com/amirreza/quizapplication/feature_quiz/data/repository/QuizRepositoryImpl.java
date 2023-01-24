package com.amirreza.quizapplication.feature_quiz.data.repository;

import com.amirreza.quizapplication.feature_quiz.data.source.QuizDataSourceI;
import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;
import com.amirreza.quizapplication.feature_quiz.domain.repository.QuizRepository;

import io.reactivex.Single;

public class QuizRepositoryImpl implements QuizRepository {

    private QuizDataSourceI quizDataSource;

    @Override
    public Single<Quiz> getQuizzes() {
        return null;
    }
}
