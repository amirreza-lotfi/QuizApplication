package com.amirreza.quizapplication.feature_authentication.data.repository.model

data class ExamHistory(
    val quizId:Int,
    val wrongAnswer:Int,
    val CorrectAnswer:Int
)
