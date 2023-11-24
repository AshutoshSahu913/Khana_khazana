package com.example.khanakhazana;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class FirstActivity extends AppCompatActivity {

    AppCompatButton nextBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), LoginPage.class)));
    }
}