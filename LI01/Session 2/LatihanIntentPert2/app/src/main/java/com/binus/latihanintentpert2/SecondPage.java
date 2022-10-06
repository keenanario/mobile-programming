package com.binus.latihanintentpert2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        txtName = findViewById(R.id.txtName);

        Intent getData = getIntent();
        String namaUser = getData.getStringExtra("username");

        txtName.setText(namaUser);
    }
}