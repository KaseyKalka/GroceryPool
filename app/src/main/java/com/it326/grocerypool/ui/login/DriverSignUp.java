package com.it326.grocerypool.ui.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.it326.grocerypool.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class DriverSignUp extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_sign_up);

        Button button = findViewById(R.id.LoginSignUpButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText email = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);
                validate(email.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate(final String email, final String password) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("Users");

        Query query = usersRef.orderByChild("email").equalTo(email);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!snapshot.exists()){
                    database.getReference("Users").push().setValue(new UserModel(email, password, UserType.DRIVER));

                    Intent intent = new Intent(DriverSignUp.this, LoggedInUser.class);
                    intent.putExtra("Email", email);
                    intent.putExtra("User Type", UserType.DRIVER);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Account already exists", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(DriverSignUp.this, HomeScreen.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}