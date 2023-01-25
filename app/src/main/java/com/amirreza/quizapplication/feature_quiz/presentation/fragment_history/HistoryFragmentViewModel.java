package com.amirreza.quizapplication.feature_quiz.presentation.fragment_history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult;
import com.amirreza.quizapplication.feature_quiz.domain.use_case.QuizUseCase;
import com.amirreza.quizapplication.util.base.QuizBaseViewModel;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HistoryFragmentViewModel extends QuizBaseViewModel {
    private QuizUseCase quizUseCase;

    private MutableLiveData<List<QuizResult>> _examHistory = new MutableLiveData<>();
    public LiveData<List<QuizResult>> examHistory = _examHistory;


    public HistoryFragmentViewModel(QuizUseCase quizUseCase) {
        this.quizUseCase = quizUseCase;
        showProgressBar(true);
        quizUseCase.getGetExamHistory().getValue()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<QuizResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<QuizResult> quizResults) {
                        _examHistory.setValue(quizResults);
                        showProgressBar(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
