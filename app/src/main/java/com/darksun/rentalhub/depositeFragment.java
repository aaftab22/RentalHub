package com.darksun.rentalhub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link depositeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class depositeFragment extends Fragment {

    public depositeFragment() {
        // Required empty public constructor
    }

    public static depositeFragment newInstance(String param1, String param2) {
        depositeFragment fragment = new depositeFragment();
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
        return inflater.inflate(R.layout.fragment_deposite, container, false);
    }
}