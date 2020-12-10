package com.it326.grocerypool.messaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.it326.grocerypool.R;

public class PrivateMessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_messages);

        TextInputEditText privateMessageText = findViewById(R.id.private_message_edit_text);
        EditText privateMessageEmail = findViewById(R.id.private_message_email_entry);
        Button privateMessageSendButton = findViewById(R.id.private_message_send_button);

        privateMessageSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : Send Notification to User with matching email in database


                Intent intent = new Intent(PrivateMessagesActivity.this, MessagingChoicesActivity.class);
                startActivity(intent);
            }
        });
    }
}