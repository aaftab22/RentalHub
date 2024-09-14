package com.darksun.rentalhub.registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.darksun.rentalhub.MainActivity;
import com.darksun.rentalhub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class signUpActivity extends AppCompatActivity {
    EditText fullname, email , password, confirmPassword;
    TextView alreadyHaveAnAccount, skip_to_main;
    Button signupBtn;
    FirebaseAuth firebaseAuth;

    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        fullname = findViewById(R.id.signUp_name_ID);
        email = findViewById(R.id.signUp_email_ID);
        password = findViewById(R.id.signUp_password_ID);
        confirmPassword = findViewById(R.id.signUp_confirmPassword_ID);
        signupBtn = findViewById(R.id.signUp_submitBtn_ID);
        alreadyHaveAnAccount = findViewById(R.id.already_have_account_ID);
        skip_to_main = findViewById(R.id.skip_to_main_ID);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        skip_to_main.setOnClickListener(v -> startActivity(new Intent(signUpActivity.this, MainActivity.class)));


        signupBtn.setOnClickListener(v -> firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful())
                    {
                        Map<Object,String> userdata = new HashMap<>();
                        userdata.put("fullName",fullname.getText().toString());
                        firebaseFirestore.collection("USERS")
                                .add(userdata)
                                .addOnCompleteListener(task1 -> {
                                    if (task1.isSuccessful())
                                    {
                                        Intent mainIntent = new Intent(signUpActivity.this,MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    }else {
                                        String err = Objects.requireNonNull(task1.getException()).getMessage();
                                        Toast.makeText(signUpActivity.this, err, Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                    else
                    {
                        String err = Objects.requireNonNull(task.getException()).getMessage();
                        Toast.makeText(signUpActivity.this, err, Toast.LENGTH_SHORT).show();
                    }
                }));
        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(signUpActivity.this, signInActivity.class);
                startActivity(loginIntent);
            }
        });


    }
}