package com.it326.grocerypool.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.it326.grocerypool.R;
import com.it326.grocerypool.messaging.PrivateMessagesActivity;

public class ViewDriverProfile extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user_profile);

        TextView usernameEditText = findViewById(R.id.emailView);
        usernameEditText.setText(getIntent().getExtras().getString("Other Email"));


    }
}
