package com.amirreza.quizapplication.feature_quiz.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuizResult(
    var wrongAnswer: Int,
    var correctAnswer: Int
):Parcelable

