package com.example.khanakhazana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.khanakhazana.databinding.ActivityLocationBinding;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity {

    ActivityLocationBinding activityLocationBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLocationBinding=ActivityLocationBinding.inflate(getLayoutInflater());
        setContentView(activityLocationBinding.getRoot());

        String[] locationList = {"Bhopal", "Indore", "Ujjain", "Gwalior", "Jabalpur", "Rewa", "Satna", "Sagar", "Katni", "Chhindwara"};
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,locationList);
        AutoCompleteTextView autoCompleteTextView=activityLocationBinding.listOfLocation;
        autoCompleteTextView.setAdapter(adapter);
    }
}