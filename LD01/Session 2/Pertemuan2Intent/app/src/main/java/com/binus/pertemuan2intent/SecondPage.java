package com.binus.pertemuan2intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    TextView namaTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        namaTv = findViewById(R.id.namaTv);

        Intent intent = getIntent();
        String namaUser = intent.getStringExtra("namaUser");
        namaTv.setText(namaUser);
    }
}