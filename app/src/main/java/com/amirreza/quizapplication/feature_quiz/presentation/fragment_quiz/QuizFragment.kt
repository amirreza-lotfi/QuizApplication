package com.amirreza.quizapplication.feature_quiz.presentation.fragment_quiz

import org.koin.android.ext.android.inject
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.amirreza.quizapplication.util.base.QuizBaseFragment
import com.amirreza.quizeapplication.R
import com.amirreza.quizeapplication.databinding.FragmentQuizBinding

class QuizFragment : QuizBaseFragment() {
    private lateinit var binding: FragmentQuizBinding
    private val quizViewModel:QuizViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quizViewModel.currentquestion.observe(viewLifecycleOwner){ question->
            question?.let {
                binding.btn1.text = it.options[0]
                binding.btn2.text = it.options[1]
                binding.btn3.text = it.options[2]
                binding.btn4.text = it.options[3]
                binding.questionText.text = it.questionText
            }
        }

        quizViewModel.navigateToResultFragment.observe(viewLifecycleOwner){
            it?.let{
                val bundle = Bundle()
                bundle.putParcelable("quizResult", it)
                findNavController().navigate(R.id.action_quizFragment_to_resultFragment,bundle)
            }
        }


        quizViewModel.actionButtonText.observe(viewLifecycleOwner){
            binding.actionButton.text = it
            clearRadioButton()
            setActionButtonDisable()
        }

        binding.radioGroup.setOnCheckedChangeListener{ radioGroup,_->
            setActionButtonEnable()
            val answer = when(radioGroup.checkedRadioButtonId){
                R.id.btn1 -> binding.btn1.text
                R.id.btn2 -> binding.btn2.text
                R.id.btn3 -> binding.btn3.text
                R.id.btn4 -> binding.btn4.text
                else -> {""}
            }
            quizViewModel.onAnswerSelected(answer.toString())
        }

        binding.actionButton.setOnClickListener {
            quizViewModel.onActionButtonClicked()
        }
    }

    private fun setActionButtonDisable() {
        binding.actionButton.isEnabled = false
    }

    private fun setActionButtonEnable() {
        binding.actionButton.isEnabled = true
    }

    private fun clearRadioButton() {
        binding.radioGroup.clearCheck();
    }
}