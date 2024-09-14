package com.darksun.rentalhub;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.bnv_id);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new HomeFragment()).commit();
        getSupportActionBar().hide();


        view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fr = null;
                switch (item.getItemId()) {
                    case R.id.home_id:
                        fr = new HomeFragment();
                        break;
                    case R.id.chat_id:
                        fr = new ChatsFragment();
                        break;
                    case R.id.ads_id:
                        fr = new SellFragment();
                        break;
                    case R.id.myads_id:
                        fr = new myAds();
                        break;
                    case R.id.profile_id:
                        fr = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, fr).commit();
                return true;
            }
        });
    }
}