package com.example.registrationapp.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("email")
    private String userName;

    @SerializedName("password")
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
