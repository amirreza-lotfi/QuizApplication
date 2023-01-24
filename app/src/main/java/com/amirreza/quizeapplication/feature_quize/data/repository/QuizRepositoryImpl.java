package com.amirreza.quizeapplication.feature_quize.data.repository;

import com.amirreza.quizeapplication.feature_quize.data.source.QuizDataSourceI;
import com.amirreza.quizeapplication.feature_quize.domain.model.Quiz;
import com.amirreza.quizeapplication.feature_quize.domain.repository.QuizRepository;

public class QuizRepositoryImpl implements QuizRepository {

    private QuizDataSourceI quizDataSource;

    @Override
    public Quiz getQuizzes() {
        return null;
    }
}
