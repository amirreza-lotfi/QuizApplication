package com.amirreza.quizapplication.feature_quiz.presentation.fragment_quiz;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.amirreza.quizapplication.feature_quiz.domain.model.Answer;
import com.amirreza.quizapplication.feature_quiz.domain.model.Question;
import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;
import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult;
import com.amirreza.quizapplication.feature_quiz.domain.use_case.QuizUseCase;
import com.amirreza.quizapplication.util.base.QuizBaseViewModel;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class QuizViewModel extends QuizBaseViewModel {

    private final QuizUseCase quizUseCase;

    private final MutableLiveData<Integer> _indexOfQuestion = new MutableLiveData<>(0);
    public LiveData<Integer> indexOfQuestion = _indexOfQuestion;

    private final MutableLiveData<Quiz> _quizLiveData = new MutableLiveData<>();
    public LiveData<Quiz> quizLiveData = _quizLiveData;

    private final MutableLiveData<Question> _currnetquestion = new MutableLiveData<>();
    public LiveData<Question> currentquestion = _currnetquestion;

    private final MutableLiveData<String> _actionButtonText = new MutableLiveData<>("Next");
    public LiveData<String> actionButtonText = _actionButtonText;

    private final MutableLiveData<String> _selectedAnswer = new MutableLiveData<>();
    public LiveData<String> selectedAnswer = _selectedAnswer;

    private final MutableLiveData<QuizResult> _navigateToResultFragment = new MutableLiveData<>();
    public LiveData<QuizResult> navigateToResultFragment = _navigateToResultFragment;


    private final MutableLiveData<Answer[]> _awnsers = new MutableLiveData<>();


    public QuizViewModel(QuizUseCase quizUseCase) {
        this.quizUseCase = quizUseCase;
        showProgressBar(true);
        quizUseCase.getGetQuizUseCase().getValue()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Quiz quiz) {
                        _quizLiveData.setValue(quiz);
                        _currnetquestion.setValue(quiz.getQuestionAt(_indexOfQuestion.getValue()));
                        _awnsers.setValue(new Answer[quiz.getQuestionSize()]);
                        showProgressBar(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void onActionButtonClicked() {
        saveAnswer();
        if (isCurrentQuestionLast()) {
            finishExam();
        } else {
            showNextQuestion();
        }
    }

    private void saveAnswer() {
        _awnsers.getValue()[_indexOfQuestion.getValue()] = new Answer(_currnetquestion.getValue().getQuestionId(),_selectedAnswer.getValue());
    }

    private void showNextQuestion() {
        _indexOfQuestion.setValue(_indexOfQuestion.getValue() + 1);
        _currnetquestion.setValue(_quizLiveData.getValue().getQuestionAt(_indexOfQuestion.getValue()));
        setActionButtonText();
    }

    private boolean isCurrentQuestionLast() {
        return _indexOfQuestion.getValue() + 1 == _quizLiveData.getValue().getQuestionSize();
    }

    public void setActionButtonText() {
        if (isCurrentQuestionLast()) {
            _actionButtonText.setValue("Finish");
        } else {
            _actionButtonText.setValue("Next");
        }
    }

    private void finishExam() {
        showProgressBar(true);
        quizUseCase.getGetQuizResult().getResult(_awnsers.getValue())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<QuizResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(QuizResult quizResult) {
                        _navigateToResultFragment.setValue(quizResult);

                        showProgressBar(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void onAnswerSelected(String text) {
        _selectedAnswer.setValue(text);
    }
}
