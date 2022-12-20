package com.example.imagelist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoServices {
    @GET("/photos")
    Call<List<PhotoData>> getAllPhotos();
}
