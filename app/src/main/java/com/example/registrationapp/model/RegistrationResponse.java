package com.example.registrationapp.model;

import com.google.gson.annotations.SerializedName;

public class RegistrationResponse {

    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
