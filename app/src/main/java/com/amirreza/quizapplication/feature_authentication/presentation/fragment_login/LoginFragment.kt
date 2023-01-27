package com.amirreza.quizapplication.feature_authentication.presentation.fragment_login

import androidx.navigation.Navigation.findNavController
import com.amirreza.quizapplication.util.base.QuizBaseFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.amirreza.quizeapplication.R
import com.amirreza.quizeapplication.databinding.FragmentLoginBinding
import io.reactivex.CompletableObserver
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

class LoginFragment : QuizBaseFragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel:LoginViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logInBtn.setOnClickListener { btn: View ->
            val username = binding.usernameValue.text.toString()
            val password = binding.passwordValue.text.toString()

            viewModel.login(username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CompletableObserver{
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onComplete() {
                        showToast("Login was successful !!")
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }

                    override fun onError(e: Throwable) {
                        showToast("Login encountered an error !!")
                    }

                })
        }
        binding.signUpBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }
}