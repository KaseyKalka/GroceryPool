package com.it326.grocerypool.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.it326.grocerypool.R;
import com.it326.grocerypool.messaging.MessagingBoardActivity;
import com.it326.grocerypool.messaging.MessagingChoicesActivity;

public class LoggedInUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_user);

        Button messagesButton = findViewById(R.id.Messages);
        messagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoggedInUser.this, MessagingChoicesActivity.class);
                startActivity(intent);
            }
        });
    }
}