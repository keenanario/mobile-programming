package com.binus.latihanintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    Button btnSubmit;
    Button btnOpenUrl;
    Button btnCall;
    Button btnWA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnOpenUrl = findViewById(R.id.btnOpenUrl);
        btnCall = findViewById(R.id.btnCall);
        btnWA = findViewById(R.id.btnWhatsApp);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaUser = txtName.getText().toString();

                Intent pindahHalaman = new Intent(MainActivity.this, SecondPage.class);
                pindahHalaman.putExtra("username", namaUser);
                startActivity(pindahHalaman);
            }
        });

        //open url
        btnOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://newbinusmaya.binus.ac.id";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));

                startActivity(i);
            }
        });

        //call
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:1234567");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                startActivity(callIntent);
            }
        });

        //share to other app
        btnWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendWA = new Intent();
                sendWA.setAction(Intent.ACTION_SEND);
                sendWA.putExtra(Intent.EXTRA_TEXT, "ini adalah pesan");
                sendWA.setType("text/plain");
                sendWA.setPackage("com.whatsapp");
                startActivity(sendWA);
            }
        });
    }
}