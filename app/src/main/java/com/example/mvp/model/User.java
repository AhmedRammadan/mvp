package com.example.mvp.model;

import android.util.Patterns;


public class User implements UserInterface {
    private String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidateDate() {
        if (email.isEmpty())
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getPassword().length()<6)
            return 2;
        else
            return -1;
    }
}
