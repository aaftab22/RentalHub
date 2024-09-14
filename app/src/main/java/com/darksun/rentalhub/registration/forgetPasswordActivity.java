package com.darksun.rentalhub.registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.darksun.rentalhub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class forgetPasswordActivity extends AppCompatActivity {
    TextView forgetEmail;
    Button resetPasswordButton;
    TextView gobackTV;
    FirebaseAuth auth;
    TextView confirmMsgTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forgetEmail = findViewById(R.id.forget_password_email_ID);
        forgetEmail.setText(getIntent().getStringExtra("emailid"));
        resetPasswordButton = findViewById(R.id.reset_password_btn_ID);
        confirmMsgTV = findViewById(R.id.confimation_msg_ID);
        auth = FirebaseAuth.getInstance();
        forgetEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkinputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        resetPasswordButton.setOnClickListener(v -> auth.sendPasswordResetEmail(forgetEmail.getText().toString())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful())
                    {
                        confirmMsgTV.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        String err = Objects.requireNonNull(task.getException()).getMessage();
                        Toast.makeText(forgetPasswordActivity.this, err, Toast.LENGTH_SHORT).show();
                    }
                }));

    }
    private void checkinputs()
    {
        resetPasswordButton.setEnabled(!TextUtils.isEmpty(forgetEmail.getText().toString()));
    }
}