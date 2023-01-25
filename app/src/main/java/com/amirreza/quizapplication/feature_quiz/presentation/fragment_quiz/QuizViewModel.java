package com.amirreza.quizapplication.feature_quiz.presentation.fragment_quiz;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.amirreza.quizapplication.feature_quiz.domain.model.Awnser;
import com.amirreza.quizapplication.feature_quiz.domain.model.Question;
import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;
import com.amirreza.quizapplication.feature_quiz.domain.use_case.QuizUseCase;

import org.jetbrains.annotations.Nullable;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class QuizViewModel extends ViewModel {

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

    private final MutableLiveData<Awnser[]> _awnsers = new MutableLiveData<>();

    public QuizViewModel(QuizUseCase quizUseCase) {
        this.quizUseCase = quizUseCase;
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
                        _awnsers.setValue(new Awnser[quiz.getQuestionSize()]);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void onActionButtonClicked() {
        if (isCurrentQuestionLast()) {
            finishExam();
        } else {
            saveAnswer();
            showNextQuestion();
        }
    }

    private void saveAnswer() {
        _awnsers.getValue()[_indexOfQuestion.getValue()] = new Awnser(_currnetquestion.getValue().getQuestionId(),_selectedAnswer.getValue());
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

    }

    public void onAnswerSelected(String text) {
        _selectedAnswer.setValue(text);
    }
}
