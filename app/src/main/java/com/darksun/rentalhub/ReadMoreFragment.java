package com.darksun.rentalhub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReadMoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReadMoreFragment extends Fragment {


    public ReadMoreFragment() {
        // Required empty public constructor
    }

    public static ReadMoreFragment newInstance(String param1, String param2) {
        ReadMoreFragment fragment = new ReadMoreFragment();
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
        View view = inflater.inflate(R.layout.fragment_read_more, container, false);



        return view;
    }
}