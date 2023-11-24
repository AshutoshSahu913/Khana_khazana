package com.example.khanakhazana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khanakhazana.Model.FoodModel;
import com.example.khanakhazana.databinding.CartItemBinding;
import com.example.khanakhazana.databinding.PopularItemBinding;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder> {
    ArrayList<FoodModel> list;
    Context context;

    public CartAdapter(ArrayList<FoodModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CartItemBinding binding = CartItemBinding.inflate(inflater, parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.viewHolder holder, int position) {
        FoodModel foodModel = list.get(position);
        /*Change this image into String if image come from internet*/
        holder.binding.cartFoodImg.setImageResource(foodModel.getFoodImg());
        holder.binding.cartFoodName.setText(foodModel.getFoodName());
        holder.binding.cartFoodPrice.setText(foodModel.getFoodPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private  CartItemBinding binding;

        public viewHolder(@NonNull CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
