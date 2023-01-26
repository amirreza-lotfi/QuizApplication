package com.amirreza.quizapplication.feature_quiz.presentation.fragment_result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.amirreza.quizapplication.util.base.QuizBaseFragment
import com.amirreza.quizeapplication.R
import com.amirreza.quizeapplication.databinding.FragmentResultBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class ResultFragment : QuizBaseFragment() {
    private val viewModel:ResultFragmentViewModel by inject { parametersOf(this.arguments) }
    private lateinit var binding:FragmentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.quizResult.observe(viewLifecycleOwner){
            val correct: Int = it.correctAnswer
            val wrong: Int = it.wrongAnswer
            val score = (correct * 1.0 / (correct + wrong)).toFloat()

            binding.correctValue.setText(correct)
            binding.wrongValue.setText(wrong)
            binding.scoreValue.text = score.toString()
        }

        binding.backToHome.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }
    }


}