package com.example.webservicelh01.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static Retrofit myRetrofit; //buat penampung retrofit
    public static String BASE_URL = "https://www.fruityvice.com/"; //base url dari API yang tidak berubah

    //untuk retrofit kalau dipanggil
    public static Retrofit getMyRetrofit(){
        if (myRetrofit == null){
            myRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return myRetrofit;
    }

}
