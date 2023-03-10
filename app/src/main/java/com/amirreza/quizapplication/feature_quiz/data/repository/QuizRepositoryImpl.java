package com.amirreza.quizapplication.feature_quiz.data.repository;

import com.amirreza.quizapplication.feature_quiz.data.source.QuizDataSourceI;
import com.amirreza.quizapplication.feature_quiz.domain.model.Answer;
import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;
import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult;
import com.amirreza.quizapplication.feature_quiz.domain.repository.QuizRepository;

import java.util.List;

import io.reactivex.Single;

public class QuizRepositoryImpl implements QuizRepository {

    private final QuizDataSourceI quizDataSource;

    public QuizRepositoryImpl(QuizDataSourceI quizDataSource){
        this.quizDataSource = quizDataSource;
    }

    @Override
    public Single<Quiz> getQuizzes() {
        return quizDataSource.getQuizzes();
    }

    @Override
    public Single<QuizResult> getResult(Answer[] answers) {
        return quizDataSource.getResult(answers);
    }

    @Override
    public Single<List<QuizResult>> getExamHistory() {
        return quizDataSource.getExamHistory();
    }
}
