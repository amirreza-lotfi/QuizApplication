package com.amirreza.quizapplication.feature_quiz.domain.repository;

import com.amirreza.quizapplication.feature_quiz.domain.model.Awnser;
import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;
import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult;

import io.reactivex.Single;

public interface QuizRepository {
    Single<Quiz> getQuizzes();
    Single<QuizResult> getResult(Awnser[] awnsers);
}
