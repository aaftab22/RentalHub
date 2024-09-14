package com.darksun.rentalhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class not_found_error extends AppCompatActivity {
    Button gobackbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_found_error);

        gobackbtn = findViewById(R.id.go_back_btn_ID);
        gobackbtn.setOnClickListener(v -> startActivity(new Intent(not_found_error.this,MainActivity.class)));

    }
}