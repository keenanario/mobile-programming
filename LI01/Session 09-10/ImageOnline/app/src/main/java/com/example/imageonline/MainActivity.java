package com.example.imageonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    CustomAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        PhotoServices services = ApiClient.getRetrofitInstance().create(PhotoServices.class);
        Call<List<PhotoData>> call = services.getAllPhotos();
        call.enqueue(new Callback<List<PhotoData>>() {
            @Override
            public void onResponse(Call<List<PhotoData>> call, Response<List<PhotoData>> response) {
                //berhasil load do something
                adapter = new CustomAdapter(MainActivity.this, response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PhotoData>> call, Throwable t) {
                //fail load do something
                Toast.makeText(MainActivity.this, "Error loading data", Toast.LENGTH_SHORT).show();
            }
        });

    }
}