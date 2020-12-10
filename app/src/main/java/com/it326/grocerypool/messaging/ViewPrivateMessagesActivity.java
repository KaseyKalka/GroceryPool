package com.it326.grocerypool.messaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class ViewPrivateMessagesActivity extends AppCompatActivity {

    FirebaseListAdapter<PrivateMessageModel> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_private_messages);
        displayChatMessages();
    }

    public void displayChatMessages(){
        ListView listOfMessages = findViewById(R.id.list_of_private_messages);
        Query query = FirebaseDatabase.getInstance().getReference("PrivateMessages").orderByChild("recipient").equalTo(getIntent().getExtras().getString("Email"));

        FirebaseListOptions<PrivateMessageModel> options =
                new FirebaseListOptions.Builder<PrivateMessageModel>()
                        .setQuery(query, PrivateMessageModel.class)
                        .setLayout(R.layout.chat_message)
                        .build();
        adapter = new FirebaseListAdapter<PrivateMessageModel>(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull PrivateMessageModel model, int position) {
                // Get references to the views of message.xml
                TextView messageText = v.findViewById(R.id.message_text);
                TextView messageUser = v.findViewById(R.id.message_user);
                TextView messageTime = v.findViewById(R.id.message_time);

                // Set their text
                messageText.setText(model.getMessage());
                messageUser.setText(model.getSender());

                // Format the date before showing it
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };

        listOfMessages.setAdapter(adapter);
        adapter.startListening();
    }
}