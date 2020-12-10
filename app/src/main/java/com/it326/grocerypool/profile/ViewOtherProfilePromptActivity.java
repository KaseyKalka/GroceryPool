package com.it326.grocerypool.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.it326.grocerypool.R;
import com.it326.grocerypool.ui.login.LoggedInUser;

public class ViewOtherProfilePromptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_other_profile_prompt);

        Button viewOtherProfileSendButton = findViewById(R.id.other_profile_send_button);
        viewOtherProfileSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText viewOtherProfileEditText = findViewById(R.id.other_profile_email_editText);


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                Query query = database.getReference("Users").orderByChild("email").equalTo(viewOtherProfileEditText.getText().toString());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            Intent intent = new Intent(ViewOtherProfilePromptActivity.this, ViewDriverProfile.class);
                            intent.putExtra("Other Email", viewOtherProfileEditText.getText().toString());
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "No profile found", Toast.LENGTH_LONG);
                            Intent intent = new Intent(ViewOtherProfilePromptActivity.this, LoggedInUser.class);
                            intent .putExtra("Email", getIntent().getExtras().getString("Email"));
                            startActivity(new Intent(ViewOtherProfilePromptActivity.this, LoggedInUser.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}