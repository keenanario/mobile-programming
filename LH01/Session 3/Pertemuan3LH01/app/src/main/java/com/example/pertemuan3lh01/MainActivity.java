package com.example.pertemuan3lh01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pindahBtn = findViewById(R.id.pindahButton);
        CheckBox setujuBox = findViewById(R.id.checkBox);

        pindahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean setujuCentang = setujuBox.isChecked(); //kalo mau simpen value checkBox

                if (setujuBox.isChecked()){
                    Intent pindahHalaman = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(pindahHalaman);
                }else{
                    Toast.makeText(MainActivity.this, "Belum dicentang", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Log.d("State Manager", "Saat ini sedang onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("State Manager", "Saat ini sedang onResume");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("State Manager", "Saat ini sedang onDestroy");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("State Manager", "Saat ini sedang onStop");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("State Manager", "Saat ini sedang onPause");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("State Manager", "Saat ini sedang onStart");
    }
}