package com.it326.grocerypool.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.it326.grocerypool.R;

public class DriverPage extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_page);

        Button button = findViewById(R.id.SignUpRider);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(DriverPage.this, DriverSignUp.class));            }
        });

        Button button2 = findViewById(R.id.LoginRider);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(DriverPage.this, DriverLogin.class));            }
        });
    }
}