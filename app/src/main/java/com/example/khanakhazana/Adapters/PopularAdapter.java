package com.example.khanakhazana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khanakhazana.Model.FoodModel;
import com.example.khanakhazana.databinding.PopularItemBinding;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.viewHolder> {
    ArrayList<FoodModel> list;
    Context context;

    public PopularAdapter(ArrayList<FoodModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PopularAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PopularItemBinding binding = PopularItemBinding.inflate(inflater, parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.viewHolder holder, int position) {
        FoodModel popularModel = list.get(position);
        /*Change this image into String if image come from internet*/
        holder.binding.foodImg.setImageResource(popularModel.getFoodImg());
        holder.binding.foodName.setText(popularModel.getFoodName());
        holder.binding.foodPrice.setText(popularModel.getFoodPrice());

        holder.binding.addToCartBtn.setOnClickListener(v -> Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
            private  PopularItemBinding binding;

        public viewHolder(@NonNull PopularItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
