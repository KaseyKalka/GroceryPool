package com.it326.grocerypool.messaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.it326.grocerypool.R;

public class MessagingChoicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging_choices);

        Button viewMessageBoardButton = findViewById(R.id.view_message_board_button);
        Button sendPrivateMessageButton = findViewById(R.id.send_private_message_button);

        viewMessageBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessagingChoicesActivity.this, MessagingBoardActivity.class);
                startActivity(intent);
            }
        });

        sendPrivateMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessagingChoicesActivity.this, PrivateMessagesActivity.class);
                startActivity(intent);
            }
        });
    }
}