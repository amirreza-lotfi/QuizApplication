package com.amirreza.quizapplication.feature_quiz.presentation.fragment_quiz;

import androidx.lifecycle.ViewModel;

import com.amirreza.quizapplication.feature_quiz.domain.use_case.QuizUseCase;

public class QuizViewModel extends ViewModel {

    private final QuizUseCase quizUseCase;
    public QuizViewModel(QuizUseCase quizUseCase){
        this.quizUseCase = quizUseCase;
    }

}
