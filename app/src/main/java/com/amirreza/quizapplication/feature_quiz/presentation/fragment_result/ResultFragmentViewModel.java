package com.amirreza.quizapplication.feature_quiz.presentation.fragment_result;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult;
import com.amirreza.quizapplication.util.base.QuizBaseViewModel;

public class ResultFragmentViewModel extends QuizBaseViewModel {
    private Bundle bundle;

    private final MutableLiveData<QuizResult> _quizResultMutableLiveData = new MutableLiveData<>();
    public LiveData<QuizResult> quizResult = _quizResultMutableLiveData;

    public ResultFragmentViewModel(Bundle bundle) {
        QuizResult quizResult = bundle.getParcelable("quizResult");
        _quizResultMutableLiveData.setValue(quizResult);
    }
}
