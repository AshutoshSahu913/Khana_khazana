package com.example.khanakhazana;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.khanakhazana.databinding.ActivitySignUpPageBinding;

public class SignUpPage extends AppCompatActivity {

    ActivitySignUpPageBinding activitySignUpPageBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignUpPageBinding = ActivitySignUpPageBinding.inflate(getLayoutInflater());
        setContentView(activitySignUpPageBinding.getRoot());

        activitySignUpPageBinding.alreadyHaveBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), LoginPage.class)));

        activitySignUpPageBinding.createAccountBtn.setOnClickListener(v -> startActivity(new Intent(SignUpPage.this, LocationActivity.class)));

    }
}