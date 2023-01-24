package com.amirreza.quizapplication.feature_quiz.domain.repository;

import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;

import io.reactivex.Single;

public interface QuizRepository {
    public Single<Quiz> getQuizzes();
}
