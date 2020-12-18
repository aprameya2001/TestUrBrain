package com.example.testurbrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPassword;
    Button btnLogin;
    ImageButton ibtnPwdLogin;
    TextView tvGoToSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        ibtnPwdLogin=findViewById(R.id.ibtnPwdLogin);
        tvGoToSignup=findViewById(R.id.tvGoToSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= etName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if(TextUtils.isEmpty(name))
                {
                    etName.setError("Enter your name!");
                    etName.requestFocus();
                }
                else if(TextUtils.isEmpty(password))
                {
                    etPassword.setError("Enter password!");
                    etPassword.requestFocus();
                }
                else if(password.length()<6)
                {
                    etPassword.setError("Password should have at least 6 characters!");
                    etPassword.requestFocus();
                    etPassword.setText("");
                }
                else
                {
                    //Signing in user using the data stored under shared preferences method.
                    SharedPreferences pref= getSharedPreferences("MyPref", MODE_PRIVATE);

                    if(pref.contains(name))
                    {
                        if(pref.getString(name,"").equals(password))
                        {
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("LoggedInUser", name);
                            editor.apply();

                            Intent intent=new Intent(MainActivity.this, HomeActivity.class );
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Incorrect password!", Toast.LENGTH_SHORT).show();
                            etName.setText("");
                            etPassword.setText("");
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Username does not exist!", Toast.LENGTH_SHORT).show();
                        etName.setText("");
                        etPassword.setText("");
                    }
                }
            }
        });

        tvGoToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }
        });

        ibtnPwdLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransformationMethod transformationMethod = etPassword.getTransformationMethod();

                if(transformationMethod!=null)
                {
                    etPassword.setTransformationMethod(null);
                }
                else
                {
                    etPassword.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });
    }
}
