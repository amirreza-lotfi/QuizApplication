package com.amirreza.quizapplication.feature_quiz.presentation.fragment_history

import com.amirreza.quizapplication.util.base.QuizBaseFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import com.amirreza.quizeapplication.databinding.FragmentHistoryBinding
import org.koin.android.ext.android.inject

class HistoryFragment : QuizBaseFragment() {
    private lateinit var binding: FragmentHistoryBinding
    private val viewModel:HistoryFragmentViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.examHistory.observe(viewLifecycleOwner){
            //todo show data
        }
    }
}