package com.binus.latihanintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        txtUsername = findViewById(R.id.txtUsername);

        Intent getData = getIntent();
        String username = getData.getStringExtra("username");

        txtUsername.setText(username);
    }
}