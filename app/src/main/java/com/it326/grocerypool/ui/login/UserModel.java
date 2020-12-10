package com.it326.grocerypool.ui.login;

public class UserModel {
    String email;
    String password;
    UserType userType;

    //Needed for Firebase
    public UserModel(){

    }

    public UserModel(String email, String password, UserType userType){
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public UserType getUserType() {
        return userType;
    }
}
