package com.amirreza.quizapplication.feature_quiz.domain.use_case

import com.amirreza.quizapplication.feature_authentication.data.repository.model.ExamHistory
import com.amirreza.quizapplication.feature_authentication.data.repository.model.QuizResult
import com.amirreza.quizapplication.feature_quiz.domain.repository.QuizRepository
import io.reactivex.Single

data class GetExamHistory(
    private val quizRepository: QuizRepository
){
    fun getValue(): Single<List<QuizResult>> {
        return quizRepository.examHistory;
    }
}