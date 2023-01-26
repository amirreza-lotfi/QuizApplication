package com.amirreza.quizapplication.feature_quiz.presentation.fragment_home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenHolder;
import com.amirreza.quizapplication.util.base.QuizBaseFragment;
import com.amirreza.quizeapplication.R;
import com.amirreza.quizeapplication.databinding.FragmentHomeBinding;


public class HomeFragment extends QuizBaseFragment {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        checkIsItNeedToNavigateToAuthenticationScreen(view);
        NavController navController = Navigation.findNavController(view);

        binding.startNewExamBtn.setOnClickListener(view1->{
            navController.navigate(R.id.action_homeFragment_to_quizFragment);
        });

        binding.examHistoryBtn.setOnClickListener(view1 -> {
            navController.navigate(R.id.action_homeFragment_to_historyFragment);
        });
    }

    public void checkIsItNeedToNavigateToAuthenticationScreen(View view){
        NavController navController = Navigation.findNavController(view);
        boolean hasUserLoggedIn = TokenHolder.INSTANCE.isTokenAvailable();

        if(!hasUserLoggedIn){
            navController.navigate(R.id.loginFragment);
        }
    }
}