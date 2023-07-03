package com.example.rentalhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signInActivity extends AppCompatActivity {
    private EditText email, password;
    private Button signInBtn;
    FirebaseAuth firebaseAuth;
    private TextView forgetpasswordTV, skip_to_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        email = findViewById(R.id.signIn_email_ID);
        password = findViewById(R.id.signIn_password_ID);
        signInBtn = findViewById(R.id.signIn_btn_ID);
        forgetpasswordTV = findViewById(R.id.forget_password_id);
        skip_to_main = findViewById(R.id.skip_to_main_ID);
        firebaseAuth = FirebaseAuth.getInstance();

        skip_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signInActivity.this,MainActivity.class));
            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Intent mainIntent = new Intent(signInActivity.this,MainActivity.class);
                                    startActivity(mainIntent);
                                    finish();
                                }
                                else{
                                    String err = task.getException().getMessage();
                                    Toast.makeText(signInActivity.this, err, Toast.LENGTH_SHORT).show();
                                }
                            }
                });
            }
        });
       forgetpasswordTV.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               TextView textView = findViewById(R.id.signIn_email_ID);
               String emailid = textView.getText().toString();
               Intent forgetpassIntent = new Intent(signInActivity.this,forgetPasswordActivity.class);
               forgetpassIntent.putExtra("emailid",emailid);
               startActivity(forgetpassIntent);
           }
       });
    }

}