package com.amirreza.quizapplication.feature_quiz.data.source;

import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;

import java.util.List;

public interface QuizDataSourceI {
    List<Quiz> getQuizzes();
}
