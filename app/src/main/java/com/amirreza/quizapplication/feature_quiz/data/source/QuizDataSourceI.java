package com.amirreza.quizapplication.feature_quiz.data.source;

import com.amirreza.quizapplication.feature_quiz.domain.model.Answer;
import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;
import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult;

import io.reactivex.Single;

public interface QuizDataSourceI {
    Single<Quiz> getQuizzes();
    Single<QuizResult> getResult(Answer[] answers);
}
