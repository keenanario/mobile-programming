package com.example.imagelist;

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
    CustomAdaptor adapter;
    RecyclerView rcView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //panggil retrofit
        PhotoServices service = ApiClient.getRetrofitInstance().create(PhotoServices.class);
        Call<List<PhotoData>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<PhotoData>>() {
            @Override
            public void onResponse(Call<List<PhotoData>> call, Response<List<PhotoData>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<PhotoData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to connect", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<PhotoData> photoList){
        rcView = findViewById(R.id.recyclerView);
        adapter = new CustomAdaptor(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rcView.setLayoutManager(layoutManager);
        rcView.setAdapter(adapter);
    }
}