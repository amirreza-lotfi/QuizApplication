package com.amirreza.quizapplication.feature_authentication.presentation.fragment_signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.amirreza.quizeapplication.R;
import com.amirreza.quizeapplication.databinding.FragmentLoginBinding;
import com.amirreza.quizeapplication.databinding.FragmentSignUpBinding;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding =  FragmentSignUpBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        binding.logInButton.setOnClickListener(btn -> {
            navController.navigate(R.id.loginFragment);
        });

        binding.signUpButton.setOnClickListener(btn->{
        });
    }

}