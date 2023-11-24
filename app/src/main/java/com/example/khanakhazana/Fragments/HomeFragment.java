package com.example.khanakhazana.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.khanakhazana.Adapters.PopularAdapter;
import com.example.khanakhazana.Model.FoodModel;
import com.example.khanakhazana.R;
import com.example.khanakhazana.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding fragmentHomeBinding;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        View root = fragmentHomeBinding.getRoot();
        setPopularRecyclerView();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*Add slider image into arraylist*/
        ArrayList<SlideModel> arrayList = new ArrayList<SlideModel>();
        arrayList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));

        /*Set arraylist into imageSlider */
        ImageSlider imageSlider = fragmentHomeBinding.imageSlider;
        imageSlider.setImageList(arrayList);
        imageSlider.setImageList(arrayList, ScaleTypes.FIT);

        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void doubleClick(int position) {
                // TODO: Implement doubleClick functionality
            }

            @Override
            public void onItemSelected(int position) {
                String itemPosition = String.valueOf(arrayList.get(position));
                String itemMessage = "Selected Image " + position;
                Toast.makeText(getContext(), itemMessage, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void setPopularRecyclerView() {
        ArrayList<FoodModel> list = generatePopularItem();
        RecyclerView recyclerView = fragmentHomeBinding.rvPopularItem;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Sample data for the RecyclerView
        PopularAdapter popularAdapter = new PopularAdapter(list, getContext());
        fragmentHomeBinding.rvPopularItem.setAdapter(popularAdapter);
    }

    private ArrayList<FoodModel> generatePopularItem() {
        ArrayList<FoodModel> popularModels = new ArrayList<>();
        popularModels.add(new FoodModel(R.drawable.menu1, "Burger", "₹ 89"));
        popularModels.add(new FoodModel(R.drawable.menu2, "Burger", "₹ 89"));
        popularModels.add(new FoodModel(R.drawable.menu3, "Burger", "₹ 89"));
        popularModels.add(new FoodModel(R.drawable.menu4, "Burger", "₹ 89"));
        popularModels.add(new FoodModel(R.drawable.menu5, "Burger", "₹ 89"));
        popularModels.add(new FoodModel(R.drawable.menu6, "Burger", "₹ 89"));
        popularModels.add(new FoodModel(R.drawable.menu7, "Burger", "₹ 89"));
        return popularModels;
    }
}