package com.amirreza.quizapplication.util.di

import android.app.Application
import com.amirreza.quizapplication.feature_quiz.data.repository.QuizRepositoryImpl
import com.amirreza.quizapplication.feature_quiz.data.source.QuizDataSourceI
import com.amirreza.quizapplication.feature_quiz.data.source.QuizRemoteDataSource
import com.amirreza.quizapplication.feature_quiz.domain.repository.QuizRepository
import com.amirreza.quizapplication.feature_quiz.domain.use_case.GetQuizzes
import com.amirreza.quizapplication.feature_quiz.domain.use_case.QuizUseCase
import com.amirreza.quizapplication.feature_quiz.presentation.fragment_quiz.QuizViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class QuizApplication : Application(){
    val module = module {
        single<QuizDataSourceI>{
            QuizRemoteDataSource()
        }
        single<QuizRepository> {
            QuizRepositoryImpl(get())
        }
        single {
            QuizUseCase(GetQuizzes(get()))
        }
    }

    val viewModelModule = module{
        viewModel {
            QuizViewModel(get());
        }
    }
}