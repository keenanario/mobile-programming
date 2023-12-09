package com.example.webservicelh01.service;

import com.example.webservicelh01.model.FruitModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FruitInterface {

    @GET("api/fruit/all")
    Call<List<FruitModel>> getAllFruit(); //api langsung json array

    @GET("api/fruit/detail")
    Call<FruitModel> getFruitDetail(); //api langsung json object
}
