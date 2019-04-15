package com.example.registrationapp.rest;

import com.example.registrationapp.model.RegistrationResponse;
import com.example.registrationapp.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("register")
    Call<RegistrationResponse> registerUser(@Body User user);

}
