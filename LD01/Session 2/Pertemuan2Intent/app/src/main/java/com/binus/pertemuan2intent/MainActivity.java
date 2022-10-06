package com.binus.pertemuan2intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button submitBtn;
    TextView nameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = findViewById(R.id.submitBtn);
        nameTv = findViewById(R.id.nameTV);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = nameTv.getText().toString();

                Intent pindahHalaman = new Intent(MainActivity.this, SecondPage.class);
                pindahHalaman.putExtra("namaUser", nama);
                startActivity(pindahHalaman);
            }
        });
    }
}