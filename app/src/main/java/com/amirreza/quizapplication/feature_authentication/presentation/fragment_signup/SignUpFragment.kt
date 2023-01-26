package com.amirreza.quizapplication.feature_authentication.presentation.fragment_signup

import androidx.navigation.Navigation.findNavController
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.amirreza.quizapplication.util.base.QuizBaseFragment
import com.amirreza.quizeapplication.R
import com.amirreza.quizeapplication.databinding.FragmentSignUpBinding
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

class SignUpFragment : QuizBaseFragment() {
    private lateinit var binding: FragmentSignUpBinding
    private val viewModel:SignUpViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logInButton.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        binding.signUpButton.setOnClickListener {
            val username = binding.usernameValue.text.toString()
            val password = binding.passwordValue.text.toString()

            viewModel.signUp(username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CompletableObserver {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onComplete() {
                        showToast("Sign Up was successful !!")
                        findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
                    }

                    override fun onError(e: Throwable) {
                        showToast("Sign Up encountered an error !!")
                    }

                })

        }
    }
}