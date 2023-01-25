package com.amirreza.quizapplication.feature_quiz.presentation.fragment_history;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amirreza.quizapplication.util.base.QuizBaseFragment;
import com.amirreza.quizeapplication.R;
import com.amirreza.quizeapplication.databinding.FragmentHistoryBinding;
import com.amirreza.quizeapplication.databinding.FragmentHomeBinding;


public class HistoryFragment extends QuizBaseFragment {
    private FragmentHistoryBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}