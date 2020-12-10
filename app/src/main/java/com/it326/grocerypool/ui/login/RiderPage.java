package com.it326.grocerypool.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.it326.grocerypool.R;

public class RiderPage extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_page);


        Button button = findViewById(R.id.SignUpRider);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(RiderPage.this, RiderSignUp.class));
            }
        });

        Button button2 = findViewById(R.id.LoginRider);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(RiderPage.this, RiderLogin.class));
            }
        });
    }
}