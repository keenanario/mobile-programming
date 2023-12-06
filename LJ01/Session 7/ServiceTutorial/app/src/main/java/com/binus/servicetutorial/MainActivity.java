package com.binus.servicetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button startBtn, stopBtn, nextPageBtn;
    SharedPreferences sharedPreferences = getSharedPreferences("ServicePref", MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);
        nextPageBtn = findViewById(R.id.nextPageBtn);

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        nextPageBtn.setOnClickListener(this);

        boolean flag = sharedPreferences.getBoolean("flagService", false);

        if(!flag){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("flagService", true);
            editor.apply();
            startService(service);
        }
    }

    @Override
    public void onClick(View view) {
        Intent service = new Intent(this, MyMusicService.class);
        switch (view.getId()){
            case R.id.startBtn:
                startService(service);

                break;
            case R.id.stopBtn:
                stopService(service);
                break;
            case R.id.nextPageBtn:
                Intent pindahHalaman = new Intent(this, SecondActivity.class);
                startActivity(pindahHalaman);
                break;
        }
    }
}