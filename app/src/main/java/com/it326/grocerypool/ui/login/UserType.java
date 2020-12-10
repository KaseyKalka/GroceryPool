package com.it326.grocerypool.ui.login;

import androidx.annotation.NonNull;

public enum UserType {
    RIDER ("Rider"),
    DRIVER ("Driver");

    private final String name;

    private UserType(String n){
        this.name = n;
    }


    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}



