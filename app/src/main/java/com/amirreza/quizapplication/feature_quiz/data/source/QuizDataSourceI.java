package com.amirreza.quizapplication.feature_quiz.data.source;

import com.amirreza.quizapplication.feature_authentication.data.repository.model.Answer;
import com.amirreza.quizapplication.feature_authentication.data.repository.model.ExamHistory;
import com.amirreza.quizapplication.feature_authentication.data.repository.model.Quiz;
import com.amirreza.quizapplication.feature_authentication.data.repository.model.QuizResult;

import java.util.List;

import io.reactivex.Single;

public interface QuizDataSourceI {
    Single<Quiz> getQuizzes();
    Single<QuizResult> getResult(Answer[] answers);
    Single<List<QuizResult>> getExamHistory();
}
