package com.amirreza.quizapplication.feature_quiz.domain.use_case

import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz
import com.amirreza.quizapplication.feature_quiz.domain.repository.QuizRepository
import io.reactivex.Single

data class GetQuizzes(
    val quizRepository: QuizRepository
){
    operator fun invoke(): Single<Quiz> {
        return quizRepository.quizzes;
    }
}
