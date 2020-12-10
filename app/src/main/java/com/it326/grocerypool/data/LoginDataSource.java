package com.it326.grocerypool.data;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.it326.grocerypool.data.model.LoggedInUserOld;
import com.it326.grocerypool.messaging.ChatMessageModel;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();

    LoggedInUserOld fakeUser = null;

    public Result<LoggedInUserOld> login(final String username, final String password) {

        try {
            // TODO: handle loggedInUser authentication
            Query query = ref.child("Users").orderByChild("displayName").equalTo(username);
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(!snapshot.exists()){
                        fakeUser = new LoggedInUserOld(java.util.UUID.randomUUID().toString(), "");
                        FirebaseDatabase.getInstance().getReference("Users").push().setValue(new LoggedInUserOld(password, username));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            if(fakeUser != null)
                return new Result.Success<>(fakeUser);
            else
                throw new Exception();

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}