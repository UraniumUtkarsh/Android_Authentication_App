package com.srmu.authentication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class RegisterActivity extends AppCompatActivity {
    //declare the java fields based on ui widgets
    EditText et_username, et_fullName, et_emailId, et_password, et_cPassword;
    Button btn_register;
    TextView tv_login;


    SharedPreferences sp;
    SharedPreferences.Editor ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        //to initialize the sharedPreferences
        sp = getSharedPreferences("srmu", 0);
        //to edit the sharedpreferences file
        ed = sp.edit();


        //intialization the java fields from ui widgets
        et_fullName = findViewById(R.id.et_fullname);
        et_cPassword = findViewById(R.id.et_cpassword);
        et_password = findViewById(R.id.et_password);
        et_username = findViewById(R.id.et_username);
        et_emailId = findViewById(R.id.et_emailid);
        btn_register = findViewById(R.id.btn_register);
        tv_login = findViewById(R.id.tv_signin);


        //to click on the register button
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to save the user data into sharedpreferences file srmu in key value pair
                ed.putString("username", et_username.getText().toString());
                ed.putString("fullName", et_fullName.getText().toString());
                ed.putString("emailId", et_emailId.getText().toString());
                ed.putString("password", et_password.getText().toString());
                ed.commit();
                //redirect to MainActivity
                Intent home = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(home);
                finish(); //finish stops backtracking which increase more data and complexity
            }
        });


        //redirect to LoginActivity
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //redirect to MainActivity
                Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(login);
                finish();
            }
        });


    }
}
