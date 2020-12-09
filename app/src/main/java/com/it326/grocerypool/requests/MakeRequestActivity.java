package com.it326.grocerypool.requests;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.firebase.database.FirebaseDatabase;
import com.it326.grocerypool.R;

import java.time.LocalDateTime;

public class MakeRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_request);

        Button requestSubmitButton = findViewById(R.id.request_submit_button);
        requestSubmitButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                //TODO : Create database entry with user's email address
                EditText address = findViewById(R.id.request_address_entry);
                TimePicker timePicker = findViewById(R.id.request_time_picker);
                DatePicker datePicker = findViewById(R.id.request_date_picker);
                LocalDateTime dateTime = LocalDateTime.of(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), timePicker.getHour(), timePicker.getMinute());

                FirebaseDatabase.getInstance().getReference("Requests").push().setValue(new Request("[USER EMAIL]", address.getText().toString(), dateTime));
            }
        });
    }
}