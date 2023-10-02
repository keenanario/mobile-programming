package com.example.pertemuan3lh01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    //TimePickerDialog timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button callAlertBtn = findViewById(R.id.callAlertBtn);

        callAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                builder.setTitle("Konfirmasi"); //title AlertDialog
                builder.setMessage("Apakah anda yakin ?"); //pesan AlertDialog
                
                //untuk tombol Confirm / Ok
                builder.setPositiveButton("Setuju", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SecondActivity.this, "Setuju di klik", Toast.LENGTH_SHORT).show();
                    }
                });

                //untuk tombol Cancel / Batal
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SecondActivity.this, "Batal di klik", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        EditText datePickerET = findViewById(R.id.datePickerET);
        datePickerDialog = new DatePickerDialog(this);
        //timePicker = new TimePickerDialog(this);

        datePickerET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
                //timePicker.show();
            }
        });
    }
}