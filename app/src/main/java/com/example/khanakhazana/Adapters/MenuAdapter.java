package com.example.khanakhazana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khanakhazana.Model.FoodModel;
import com.example.khanakhazana.databinding.MenuItemBinding;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.viewHolder> {
    ArrayList<FoodModel> list;
    Context context;

    public MenuAdapter(ArrayList<FoodModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MenuItemBinding binding = MenuItemBinding.inflate(inflater, parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.viewHolder holder, int position) {
        FoodModel foodModel = list.get(position);
        holder.binding.menuFoodImg.setImageResource(foodModel.getFoodImg());
        holder.binding.menuFoodName.setText(foodModel.getFoodName());
        holder.binding.menuFoodPrice.setText(foodModel.getFoodPrice());

        holder.binding.menuAddToCartBtn.setOnClickListener(v -> Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        private final MenuItemBinding binding;

        public viewHolder(@NonNull MenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
