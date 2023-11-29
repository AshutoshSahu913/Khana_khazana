package com.example.khanakhazana.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khanakhazana.Model.FoodModel;
import com.example.khanakhazana.databinding.CartItemBinding;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder> {
    ArrayList<FoodModel> list;
    Context context;
    private final int[] itemQuantities;


    public CartAdapter(ArrayList<FoodModel> list, Context context) {
        this.list = list != null ? list : new ArrayList<>(); // Check for null and provide an empty list if needed
        this.context = context;
        this.itemQuantities = new int[this.list.size()]; // Initialize itemQuantities based on the size of the list

    }


    @NonNull
    @Override
    public CartAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CartItemBinding binding = CartItemBinding.inflate(inflater, parent, false);
        return new viewHolder(binding);
    }


    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull CartAdapter.viewHolder holder, int position) {
        FoodModel foodModel = list.get(position);
        /*Change this image into String if image come from internet*/
        holder.binding.cartFoodImg.setImageResource(foodModel.getFoodImg());
        holder.binding.cartFoodName.setText(foodModel.getFoodName());
        holder.binding.cartFoodPrice.setText(foodModel.getFoodPrice());

        holder.binding.minusBtn.setOnClickListener(v -> {

            if (itemQuantities[position] > 1) {
                itemQuantities[position]--;
                holder.binding.itemQuantity.setText(String.valueOf(itemQuantities[position]));
            }
        });

        holder.binding.plusBtn.setOnClickListener(v -> {
            itemQuantities[position]++;
            holder.binding.itemQuantity.setText(String.valueOf(itemQuantities[position]));
        });

        holder.binding.deleteBtn.setOnClickListener(v -> {
            // Remove the item from the list
            list.remove(position);

            // Notify the adapter that an item has been removed
            notifyItemRemoved(position);

            // Optionally, you may want to update other items' positions if needed
            notifyItemRangeChanged(position, getItemCount());
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        private final CartItemBinding binding;

        public viewHolder(@NonNull CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
