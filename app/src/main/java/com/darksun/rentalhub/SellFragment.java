package com.darksun.rentalhub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.darksun.rentalhub.Adapters.sellProductAdapter;
import com.darksun.rentalhub.DataClass.sellProductModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SellFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SellFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    sellProductAdapter sellCategoryAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SellFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SellFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SellFragment newInstance(String param1, String param2) {
        SellFragment fragment = new SellFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sell, container, false);

        recyclerView = view.findViewById(R.id.sell_categoryRecycleID);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        FirebaseRecyclerOptions<sellProductModel> options = new FirebaseRecyclerOptions.Builder<sellProductModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Master_Category"), sellProductModel.class)
                .build();
        sellCategoryAdapter = new sellProductAdapter(options);
        recyclerView.setAdapter(sellCategoryAdapter);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        sellCategoryAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        sellCategoryAdapter.stopListening();
    }
}