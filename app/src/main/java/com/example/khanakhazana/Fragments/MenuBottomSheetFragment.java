package com.example.khanakhazana.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khanakhazana.R;
import com.example.khanakhazana.databinding.FragmentMenuBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MenuBottomSheetFragment extends BottomSheetDialogFragment {


    public MenuBottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMenuBottomSheetBinding menuBottomSheetFragment;
        // Inflate the layout for this fragment
        menuBottomSheetFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_menu_bottom_sheet, container, false);
        return menuBottomSheetFragment.getRoot();
    }
}