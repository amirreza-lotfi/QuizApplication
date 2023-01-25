package com.amirreza.quizapplication.feature_quiz.domain.repository;

import com.amirreza.quizapplication.feature_quiz.domain.model.Answer;
import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;
import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult;

import java.util.List;

import io.reactivex.Single;

public interface QuizRepository {
    Single<Quiz> getQuizzes();
    Single<QuizResult> getResult(Answer[] answers);
    Single<List<QuizResult>> getExamHistory();
}
