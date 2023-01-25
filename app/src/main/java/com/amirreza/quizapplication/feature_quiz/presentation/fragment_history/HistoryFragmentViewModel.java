package com.amirreza.quizapplication.feature_quiz.presentation.fragment_history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.amirreza.quizapplication.feature_authentication.data.repository.model.ExamHistory;
import com.amirreza.quizapplication.util.base.QuizBaseViewModel;

import java.util.List;

public class HistoryFragmentViewModel extends QuizBaseViewModel {
    private MutableLiveData<List<ExamHistory>> _examHistory = new MutableLiveData<>();
    public LiveData<List<ExamHistory>> examHistory = _examHistory;

    His

}
