package com.it326.grocerypool.messaging;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.it326.grocerypool.R;

public class MessagingBoardActivity extends AppCompatActivity {

    FirebaseListAdapter<ChatMessageModel> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging_board);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText messageInput = findViewById(R.id.input);

                if(!messageInput.getText().toString().equals(""))
                    FirebaseDatabase.getInstance().getReference("Messages").push().setValue(new ChatMessageModel(messageInput.getText().toString(), "[NEEDS_USER_NAME]"));
                else
                    return;

                messageInput.setText("");
            }
        });

        displayChatMessages();
    }

    public void displayChatMessages(){
        ListView listOfMessages = findViewById(R.id.list_of_messages);
        Query query = FirebaseDatabase.getInstance().getReference("Messages");

        FirebaseListOptions<ChatMessageModel> options =
                new FirebaseListOptions.Builder<ChatMessageModel>()
                        .setQuery(query, ChatMessageModel.class)
                        .setLayout(R.layout.chat_message)
                        .build();
        adapter = new FirebaseListAdapter<ChatMessageModel>(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull ChatMessageModel model, int position) {
                // Get references to the views of message.xml
                TextView messageText = v.findViewById(R.id.message_text);
                TextView messageUser = v.findViewById(R.id.message_user);
                TextView messageTime = v.findViewById(R.id.message_time);

                // Set their text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

                // Format the date before showing it
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };

        listOfMessages.setAdapter(adapter);
        adapter.startListening();
    }
}