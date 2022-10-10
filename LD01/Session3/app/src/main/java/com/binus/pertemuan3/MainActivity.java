package com.binus.pertemuan3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submitBtn, alertBtn;
    EditText nameET;

    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = findViewById(R.id.submitBtn);
        alertBtn = findViewById(R.id.alertBtn);
        nameET = findViewById(R.id.nameIT);

        alertBuilder = new AlertDialog.Builder(this);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString();

                Toast.makeText(getApplicationContext(),"hello, "+name, Toast.LENGTH_SHORT).show();
            }
        });

        alertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set Alert message dari String
//                alertBuilder.setMessage(R.string.bodyAlert).setTitle(R.string.titleAlert);

                //build manual
                alertBuilder.setMessage("Do you want to continue?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                Toast.makeText(getApplicationContext(), "alert berhasil", Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getApplicationContext(), "alert di cancel", Toast.LENGTH_LONG).show();
                            }
                        });

                AlertDialog alert = alertBuilder.create();
                alert.setTitle("Warning");
                alert.show();
            }
        });
    }
}