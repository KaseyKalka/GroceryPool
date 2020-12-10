package com.it326.grocerypool.requests;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.it326.grocerypool.R;
import com.it326.grocerypool.messaging.ChatMessageModel;

import java.time.LocalDateTime;

public class ViewRequestsActivity extends AppCompatActivity {

    FirebaseListAdapter<Request> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_requests);

        ListView viewRequestsList = findViewById(R.id.requests_listview);
        Query query = FirebaseDatabase.getInstance().getReference("Requests");

        FirebaseListOptions<Request> options =
                new FirebaseListOptions.Builder<Request>()
                        .setQuery(query, Request.class)
                        .setLayout(R.layout.request_list_item)
                        .build();

        adapter = new FirebaseListAdapter<Request>(options) {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            protected void populateView(@NonNull View v, @NonNull Request model, int position) {
                //References to TextViews in request_list_item.xml
                TextView requestsEmail = v.findViewById(R.id.requests_email);
                TextView requestsDateTime = v.findViewById(R.id.requests_date_time);
                TextView requestsAddress = v.findViewById(R.id.requests_address);

                requestsEmail.setText(model.getEmail());
                requestsDateTime.setText(LocalDateTime.of(model.year, model.month, model.day, model.hour, model.minute).toString());
                requestsAddress.setText(model.getAddress());
            }
        };

        viewRequestsList.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}