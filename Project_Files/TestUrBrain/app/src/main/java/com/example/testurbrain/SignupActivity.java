package com.example.testurbrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText etEmailSUP, etPasswordSUP, etNameSUP, etPasswordSUP2;
    Button btnSignup;
    ImageButton ibtnPwdSUP, ibtnPwdSUP2;
    TextView tvGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etEmailSUP = findViewById(R.id.etEmailSUP);
        etPasswordSUP = findViewById(R.id.etPasswordSUP);
        etNameSUP = findViewById(R.id.etNameSUP);
        etPasswordSUP2 = findViewById(R.id.etPasswordSUP2);
        btnSignup = findViewById(R.id.btnSignup);
        ibtnPwdSUP = findViewById(R.id.ibtnPwdSUP);
        ibtnPwdSUP2 = findViewById(R.id.ibtnPwdSUP2);
        tvGoToLogin = findViewById(R.id.tvGoToLogin);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = etEmailSUP.getText().toString().trim();
                final String name = etNameSUP.getText().toString().trim();
                String password1 = etPasswordSUP.getText().toString().trim();
                String password2 = etPasswordSUP2.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    etNameSUP.setError("Enter your name!");
                    etNameSUP.requestFocus();
                } else if (TextUtils.isEmpty(email)) {
                    etEmailSUP.setError("Enter your email!");
                    etEmailSUP.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmailSUP.setError("Enter a valid email!");
                    etEmailSUP.setText("");
                    etEmailSUP.requestFocus();
                } else if (TextUtils.isEmpty(password1)) {
                    etPasswordSUP.setError("Create password!");
                    etPasswordSUP.requestFocus();
                } else if (password1.length() < 6) {
                    etPasswordSUP.setError("Password should have at least 6 characters!");
                    etPasswordSUP.requestFocus();
                    etPasswordSUP.setText("");
                } else if (TextUtils.isEmpty(password2)) {
                    etPasswordSUP2.setError("Confirm password");
                    etPasswordSUP2.requestFocus();
                } else if (!password1.equals(password2)) {
                    Toast.makeText(getApplicationContext(), "Re- enter the correct password", Toast.LENGTH_SHORT).show();
                    etPasswordSUP.setText("");
                    etPasswordSUP2.setText("");
                } else{

                    //Signing up user using shared preferences method.

                    SharedPreferences pref= getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor= pref.edit();

                    if(!(pref.contains(name))) {
                        editor.putString(name, password1);
                        editor.putString("LoggedInUser", name);
                        editor.apply();

                        Toast.makeText(getApplicationContext(), "New account created successfully!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Username already exists. Please login directly!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupActivity.this, MainActivity.class));
                    }

                }
            }
        });

        tvGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignupActivity.this, MainActivity.class));
            }
        });

        ibtnPwdSUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransformationMethod tfm = etPasswordSUP.getTransformationMethod();

                if (tfm != null) {
                    etPasswordSUP.setTransformationMethod(null);
                } else {
                    etPasswordSUP.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        ibtnPwdSUP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransformationMethod tfm = etPasswordSUP2.getTransformationMethod();

                if (tfm != null) {
                    etPasswordSUP2.setTransformationMethod(null);
                } else {
                    etPasswordSUP2.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

    }
}
