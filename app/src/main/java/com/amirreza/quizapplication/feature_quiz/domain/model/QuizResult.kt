package com.amirreza.quizapplication.feature_quiz.domain.model

import android.os.Parcelable
import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenHolder
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuizResult(
    var username:String? = TokenHolder.username,
    var wrongAnswer: Int,
    var correctAnswer: Int
):Parcelable

