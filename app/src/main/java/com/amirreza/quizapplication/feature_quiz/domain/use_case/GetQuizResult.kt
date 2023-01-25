package com.amirreza.quizapplication.feature_quiz.domain.use_case

import com.amirreza.quizapplication.feature_quiz.domain.model.Awnser
import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult
import com.amirreza.quizapplication.feature_quiz.domain.repository.QuizRepository
import io.reactivex.Single

data class GetQuizResult(
    private val quizRepository: QuizRepository
){
    fun getResult(answers: Array<Awnser>): Single<QuizResult> {
        return quizRepository.getResult(answers);
    }
}
