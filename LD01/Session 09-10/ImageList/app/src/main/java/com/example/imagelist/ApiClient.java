package com.example.imagelist;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit rtf;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static Retrofit getRetrofitInstance(){
        if(rtf == null){
            rtf = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return rtf;
    }
}
