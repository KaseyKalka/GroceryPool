package com.it326.grocerypool.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.it326.grocerypool.R;

public class ViewDriverProfile extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user_profile);

        TextView usernameEditText = findViewById(R.id.emailView);
        usernameEditText.setText("Dummy");//TODO

        ImageView sendmess = findViewById(R.id.imageButton2);

        sendmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
    }
}
