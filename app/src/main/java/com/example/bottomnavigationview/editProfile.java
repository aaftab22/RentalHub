package com.example.bottomnavigationview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class editProfile extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        button = findViewById(R.id.edit_pro_submit_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(editProfile.this, "Data submitted successfully", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(editProfile.this,MainActivity.class));
            }
        });
    }
}