package com.it326.grocerypool.ui.login;

public class UserModel {
    private String email;
    private String password;

    //Default Constructor needed for Firebase Database
    public UserModel(){

    }

    public UserModel(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
}
