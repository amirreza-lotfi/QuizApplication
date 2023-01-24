package com.amirreza.quizeapplication.feature_quize.data.source;

import com.amirreza.quizeapplication.feature_quize.domain.model.Quiz;

import java.util.List;

public interface QuizDataSourceI {
    List<Quiz> getQuizzes();
}
