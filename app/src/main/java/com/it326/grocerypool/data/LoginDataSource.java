package com.it326.grocerypool.data;

import com.it326.grocerypool.data.model.LoggedInUserOld;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUserOld> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUserOld fakeUser =
                    new LoggedInUserOld(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}