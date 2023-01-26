package com.amirreza.quizapplication.feature_quiz.data.source;

import com.amirreza.quizapplication.feature_quiz.domain.model.Answer;
import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;
import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult;
import com.amirreza.quizapplication.util.http.ApiService;

import java.util.List;

import io.reactivex.Single;

public class QuizRemoteDataSource implements QuizDataSourceI {

    //It is just for test. in real app, this is retrofit api Service
    private ApiService apiService;

    public QuizRemoteDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<Quiz> getQuizzes() {
        return apiService.getQuizzes();
    }

    @Override
    public Single<QuizResult> getResult(Answer[] answers) {
        return apiService.getResultOfExam(answers);
    }

    @Override
    public Single<List<QuizResult>> getExamHistory() {
        return apiService.getExamHistory();
    }
}
