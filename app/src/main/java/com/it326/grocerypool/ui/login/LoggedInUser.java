package com.it326.grocerypool.ui.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.it326.grocerypool.CalendarActivity;
import com.it326.grocerypool.R;
import com.it326.grocerypool.location.LocationService;
import com.it326.grocerypool.messaging.MessagingBoardActivity;
import com.it326.grocerypool.messaging.MessagingChoicesActivity;
import com.it326.grocerypool.profile.DriverProfile;
import com.it326.grocerypool.requests.MakeRequestActivity;
import com.it326.grocerypool.requests.ViewRequestsActivity;

public class LoggedInUser extends AppCompatActivity {
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_user);

        Button messagesButton = findViewById(R.id.Messages);
        messagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoggedInUser.this, MessagingChoicesActivity.class);
                intent.putExtra("Email", getIntent().getExtras().getString("Email"));
                startActivity(intent);
            }
        });

        Button createRideButton = findViewById(R.id.create_ride_button);
        createRideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoggedInUser.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        Button profileButton = findViewById(R.id.Profile);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoggedInUser.this, DriverProfile.class);
                intent.putExtra("Email", getIntent().getExtras().getString("Email"));
                startActivity(intent);
            }
        });

        Button requestsButton = findViewById(R.id.requests_button);
        requestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoggedInUser.this, MakeRequestActivity.class);
                intent.putExtra("Email", getIntent().getExtras().getString("Email"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Start location service
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            Log.i("permission", "Permission denied");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 22);
            Log.i("permission", "Requesting permission");
        }
        else{
            Log.i("permission", "Permission granted, attempt to start LocationService");
            Intent i = new Intent(this, LocationService.class);
            startService(i);
        }
    }
}