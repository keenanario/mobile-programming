package com.example.webservicelh01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.webservicelh01.model.FruitModel;
import com.example.webservicelh01.service.APIClient;
import com.example.webservicelh01.service.FruitInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView fruitRecycler;
    FruitInterface apiInterface;
    FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruitRecycler = findViewById(R.id.fruitRecycler);

        apiInterface = APIClient.getMyRetrofit().create(FruitInterface.class);
        Call<List<FruitModel>> callAPI = apiInterface.getAllFruit();
        
        callAPI.enqueue(new Callback<List<FruitModel>>() {
            @Override
            public void onResponse(Call<List<FruitModel>> call, Response<List<FruitModel>> response) {
                if (response.code() == 200){
                    adapter = new FruitAdapter(response.body());
                    LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                    fruitRecycler.setLayoutManager(manager);
                    fruitRecycler.setAdapter(adapter);
                }else{
                    Toast.makeText(MainActivity.this, "Terjadi kesalahan: " +response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<FruitModel>> call, Throwable t) {
                t.printStackTrace(); //nampilin error di log
                Toast.makeText(MainActivity.this, "gagal koneksi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}