package com.srmu.authentication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class LoginActivity extends AppCompatActivity {
    //declare the java fields based on ui widgets
    Button btn_login;
    EditText et_username, et_password;
    TextView tv_register;
    SharedPreferences sp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        //to get the sharedPreferences file srmu from application
        sp = getSharedPreferences("srmu", 0);
        //initialization connect ui widget to java fields
        btn_login = findViewById(R.id.btn_login);
        et_password = findViewById(R.id.et_password);
        et_username = findViewById(R.id.et_username);
        tv_register = findViewById(R.id.tv_register);


        //to click on the login button
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add validation to check the username and password are correct
                if (et_username.getText().toString().equals(sp.getString("username", null))
                        && et_password.getText().toString().equals(sp.getString("password", null)))
                {
                    //credentials are correct
                    //redirect to MainActivity
                    Intent home = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(home);
                    finish();


                }else {
                    Toast.makeText(LoginActivity.this, "Credential Incorrect",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        //to click on the don't have an account textview
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //redirect to MainActivity
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
                finish();
            }
        });




    }
}
