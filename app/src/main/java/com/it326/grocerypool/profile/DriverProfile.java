package com.it326.grocerypool.profile;

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

import com.it326.grocerypool.R;
import com.it326.grocerypool.ui.login.HomeScreen;
import com.it326.grocerypool.ui.login.LoginViewModel;

public class DriverProfile extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        //UserProfileView();
    }

    private void UserProfileView(){

        final EditText email = findViewById(R.id.usernameEdit);
        final EditText password = findViewById(R.id.passwordEdit);
        final EditText password2 = findViewById(R.id.passwordEdit2);
        final Button buttonDelete = findViewById(R.id.deletebutton);
        final Button buttonSave = findViewById(R.id.savebutton);

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                //loginViewModel.loginDataChanged(email.getText().toString(),
                        //password.getText().toString());
            }
        };
        email.addTextChangedListener(afterTextChangedListener);
        password.addTextChangedListener(afterTextChangedListener);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DriverProfile.this, HomeScreen.class));//TODO
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DriverProfile.this, HomeScreen.class));
            }
        });
    }
}