package com.darksun.rentalhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.darksun.rentalhub.registration.signUpActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    ImageView imageView;
    RelativeLayout loginLayout, readMoreLayout, contactUsLayout, manageAddressLayout;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        loginLayout = view.findViewById(R.id.login_signup_layout);
        readMoreLayout = view.findViewById(R.id.readMore_ID);
        imageView = view.findViewById(R.id.edit_sign);
        contactUsLayout = view.findViewById(R.id.contact_us_ID);
        manageAddressLayout = view.findViewById(R.id.address_lable_ID);


        FirebaseUser curruntUser = firebaseAuth.getCurrentUser();
        if (curruntUser != null)
        {
            loginLayout.setVisibility(View.GONE);
        }

        imageView.setOnClickListener(v -> startActivity(new Intent(view.getContext(), editProfile.class)));

        loginLayout.setOnClickListener(v -> {
            Intent loginIntent = new Intent(getActivity(), signUpActivity.class);
            startActivity(loginIntent);

            requireActivity().finish();
        });

        readMoreLayout.setOnClickListener(v -> getFragmentManager().beginTransaction().replace(R.id.framelayout_id,new ReadMoreFragment()).commit());

        contactUsLayout.setOnClickListener(v -> getFragmentManager().beginTransaction().replace(R.id.framelayout_id,new ContactUsFragment()).commit());

        manageAddressLayout.setOnClickListener(v -> getFragmentManager().beginTransaction().replace(R.id.framelayout_id,new ManageAddress()).commit());

        return view;
    }
}