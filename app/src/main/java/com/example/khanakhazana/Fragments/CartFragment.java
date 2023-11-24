package com.example.khanakhazana.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khanakhazana.Adapters.CartAdapter;
import com.example.khanakhazana.Model.FoodModel;
import com.example.khanakhazana.R;
import com.example.khanakhazana.databinding.FragmentCartBinding;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    private FragmentCartBinding fragmentCartBinding;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false);
        View root = fragmentCartBinding.getRoot();
        setCartRecyclerView();
        return root;
    }

    public void setCartRecyclerView() {
        ArrayList<FoodModel> list = generatePopularItem();
        RecyclerView recyclerView = fragmentCartBinding.rvCart;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Sample data for the RecyclerView
        CartAdapter cartAdapter = new CartAdapter(list, getContext());
        fragmentCartBinding.rvCart.setAdapter(cartAdapter);
    }

    private ArrayList<FoodModel> generatePopularItem() {
        ArrayList<FoodModel> popularModels = new ArrayList<>();
        popularModels.add(new FoodModel(R.drawable.menu1, "Herbal Pancake", "₹ 99"));
        popularModels.add(new FoodModel(R.drawable.menu2, "Fruit Salad", "₹ 129"));
        popularModels.add(new FoodModel(R.drawable.menu3, "Ice Cream", "₹ 149"));
        return popularModels;
    }
}