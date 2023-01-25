package com.amirreza.quizapplication.util.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class QuizBaseViewModel : ViewModel() {
    private val progressBarIndicatorLiveData = MutableLiveData<Boolean>()
    fun showProgressBar(b: Boolean) {
        progressBarIndicatorLiveData.postValue(b)
    }
}