package com.darksun.rentalhub;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.darksun.rentalhub.registration.signUpActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();


        firebaseAuth = FirebaseAuth.getInstance();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser curruntUser = firebaseAuth.getCurrentUser();
                if (curruntUser == null)
                {
                    Toast.makeText(SplashActivity.this, "Normal text", Toast.LENGTH_SHORT).show();
                    Intent registerIntent = new Intent(SplashActivity.this, signUpActivity.class);
                    startActivity(registerIntent);
                }
                else
                {
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }
            }
        },2000);
    }
}