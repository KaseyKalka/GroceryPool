package com.it326.grocerypool.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.it326.grocerypool.R;
import com.it326.grocerypool.ui.login.HomeScreen;
import com.it326.grocerypool.ui.login.LoggedInUser;
import com.it326.grocerypool.ui.login.LoginViewModel;

import org.w3c.dom.Text;

public class DriverProfile extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        TextView email = findViewById(R.id.usernameEdit);
        final EditText password = findViewById(R.id.passwordEdit);
        final EditText password2 = findViewById(R.id.passwordEdit2);

        email.setText(getIntent().getExtras().getString("Email"));

        Button saveChangesButton = findViewById(R.id.savebutton);
        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().equals(password2.getText().toString())){
                    Intent intent = new Intent(DriverProfile.this, LoggedInUser.class);
                    intent.putExtra("String", getIntent().getExtras().getString("Email"));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "New password and confirmation do not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button deleteProfileButton = findViewById(R.id.deletebutton);
        deleteProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();

                Query query = database.getReference("Users").orderByChild("email").equalTo(getIntent().getExtras().getString("Email"));
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                            dataSnapshot.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                Intent intent = new Intent(DriverProfile.this, HomeScreen.class);
                intent.putExtra("Email", getIntent().getExtras().getString("Email"));
                startActivity(intent);
            }
        });

        Button viewOtherProfileButton = findViewById(R.id.view_other_profile_button);
        viewOtherProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DriverProfile.this, ViewOtherProfilePromptActivity.class);
                intent.putExtra("Email", getIntent().getExtras().getString("Email"));
                startActivity(intent);
            }
        });
    }
}