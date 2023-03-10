package com.amirreza.quizapplication.feature_quiz.domain.use_case

data class QuizUseCase(
    val getQuizUseCase: GetQuizzes,
    val getQuizResult: GetQuizResult,
    val getExamHistory: GetExamHistory
)