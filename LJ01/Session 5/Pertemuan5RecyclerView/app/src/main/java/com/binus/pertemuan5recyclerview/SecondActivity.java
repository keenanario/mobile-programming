package com.binus.pertemuan5recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtView2 = findViewById(R.id.txtView2);

        Intent getData = getIntent();
        String description = getData.getStringExtra("description");

        txtView2.setText(description);
    }
}