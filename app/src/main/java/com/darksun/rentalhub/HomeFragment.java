package com.darksun.rentalhub;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.darksun.rentalhub.Adapters.categoryAdapter;
import com.darksun.rentalhub.Adapters.product_adapter;
import com.darksun.rentalhub.DataClass.Product_Model;
import com.darksun.rentalhub.DataClass.categoryModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {

    RecyclerView productRecyclerView,cateogryRecycleView;
    com.darksun.rentalhub.Adapters.product_adapter product_adapter;
    com.darksun.rentalhub.Adapters.categoryAdapter categoryAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        cateogryRecycleView = view.findViewById(R.id.categoryRecycleHome_ID);
        productRecyclerView = view.findViewById(R.id.product_recycle_id);


        productRecyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        FirebaseRecyclerOptions<Product_Model> options = new FirebaseRecyclerOptions.Builder<Product_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Products"), Product_Model.class)
                .build();
        product_adapter = new product_adapter(options);
        productRecyclerView.setAdapter(product_adapter);

        cateogryRecycleView.setLayoutManager(new GridLayoutManager(view.getContext(), 12));
        FirebaseRecyclerOptions<categoryModel> options2 = new FirebaseRecyclerOptions.Builder<categoryModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Master_Category"), categoryModel.class)
                .build();
        categoryAdapter = new categoryAdapter(options2);
        cateogryRecycleView.setAdapter(categoryAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        product_adapter.startListening();
        categoryAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        product_adapter.stopListening();
        categoryAdapter.stopListening();
    }


}