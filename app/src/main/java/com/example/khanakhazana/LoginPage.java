package com.example.khanakhazana;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.khanakhazana.databinding.ActivityLoginPageBinding;

public class LoginPage extends AppCompatActivity {

ActivityLoginPageBinding activityLoginPageBinding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginPageBinding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        View view=activityLoginPageBinding.getRoot();
        setContentView(view);

        activityLoginPageBinding.goSignUp.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), SignUpPage.class));
        });

        activityLoginPageBinding.loginBtn.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), LocationActivity.class));
        });

    }
}