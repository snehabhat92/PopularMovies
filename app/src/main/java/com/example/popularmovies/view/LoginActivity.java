package com.example.popularmovies.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.popularmovies.R;
import com.example.popularmovies.databinding.ActivityLoginBinding;
import com.example.popularmovies.model.LoginUser;
import com.example.popularmovies.viewModel.LoginViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        if (savedInstanceState == null) {
            loginViewModel.init();
        }
        binding.setLifecycleOwner(this);

        binding.setLoginViewModel(loginViewModel);
        submitButtonClicked();

    }
    private void submitButtonClicked() {
        loginViewModel.getLoginFields().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(LoginUser loginModel) {
                Toast.makeText(LoginActivity.this, "Login successful with email " + loginModel.getUserEmail(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MovieActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}