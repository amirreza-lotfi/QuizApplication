package com.amirreza.quizapplication.util.di

import android.app.Application
import android.content.SharedPreferences
import android.os.Bundle
import com.amirreza.quizapplication.feature_authentication.data.repository.AuthenticationRepositoryImpl
import com.amirreza.quizapplication.feature_authentication.data.source.local_data_source.AuthenticationLocalDataSource
import com.amirreza.quizapplication.feature_authentication.data.source.local_data_source.AuthenticationLocalDataSourceImpl
import com.amirreza.quizapplication.feature_authentication.data.source.remote_data_source.AuthenticationRemoteDataSource
import com.amirreza.quizapplication.feature_authentication.data.source.remote_data_source.AuthenticationRemoteDataSourceImpl
import com.amirreza.quizapplication.feature_authentication.domain.repository.AuthenticationRepository
import com.amirreza.quizapplication.feature_authentication.domain.usecases.AuthUseCases
import com.amirreza.quizapplication.feature_authentication.domain.usecases.LoginUseCase
import com.amirreza.quizapplication.feature_authentication.domain.usecases.SignUpUseCase
import com.amirreza.quizapplication.feature_authentication.presentation.fragment_login.LoginViewModel
import com.amirreza.quizapplication.feature_authentication.presentation.fragment_signup.SignUpViewModel
import com.amirreza.quizapplication.feature_quiz.data.repository.QuizRepositoryImpl
import com.amirreza.quizapplication.feature_quiz.data.source.QuizDataSourceI
import com.amirreza.quizapplication.feature_quiz.data.source.QuizRemoteDataSource
import com.amirreza.quizapplication.feature_quiz.domain.repository.QuizRepository
import com.amirreza.quizapplication.feature_quiz.domain.use_case.GetExamHistory
import com.amirreza.quizapplication.feature_quiz.domain.use_case.GetQuizResult
import com.amirreza.quizapplication.feature_quiz.domain.use_case.GetQuizzes
import com.amirreza.quizapplication.feature_quiz.domain.use_case.QuizUseCase
import com.amirreza.quizapplication.feature_quiz.presentation.fragment_history.HistoryFragmentViewModel
import com.amirreza.quizapplication.feature_quiz.presentation.fragment_quiz.QuizViewModel
import com.amirreza.quizapplication.feature_quiz.presentation.fragment_result.ResultFragmentViewModel
import com.amirreza.quizapplication.util.http.ApiService
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import java.security.AuthProvider

class QuizApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        val module = module {
            single {
                ApiService()
            }
            factory<QuizDataSourceI>{
                QuizRemoteDataSource(get())
            }

            single<QuizRepository> {
                QuizRepositoryImpl(get())
            }

            factory<AuthenticationRemoteDataSource> {
                AuthenticationRemoteDataSourceImpl(get())
            }
            single<SharedPreferences>{
                this@QuizApplication.getSharedPreferences("appAuth", MODE_PRIVATE)
            }
            factory<AuthenticationLocalDataSource> {
                AuthenticationLocalDataSourceImpl(get())
            }
            single<AuthenticationRepository> {
                AuthenticationRepositoryImpl(get(),get())
            }
            single {
                QuizUseCase(
                    GetQuizzes(get()),
                    GetQuizResult(get()),
                    GetExamHistory(get())
                )
            }
            single{
                AuthUseCases(LoginUseCase(get()), SignUpUseCase(get()))
            }
        }

        val viewModelModule = module{
            viewModel {
                QuizViewModel(get());
            }
            viewModel { (bundle:Bundle)->
                ResultFragmentViewModel(bundle)
            }
            viewModel{
                LoginViewModel(get())
            }
            viewModel {
                SignUpViewModel(get())
            }
            viewModel{
                HistoryFragmentViewModel(get())
            }
        }
        startKoin {
            androidContext(this@QuizApplication)
            modules(listOf(module, viewModelModule))
        }
    }

}