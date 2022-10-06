package com.binus.latihanintentpert2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit, btnOpenURL, btnCall, btnShare;
    EditText txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnOpenURL = findViewById(R.id.btnOpenUrl);
        btnCall = findViewById(R.id.btnCall);
        btnShare = findViewById(R.id.btnShare);
        txtUsername = findViewById(R.id.txtUsername);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaUser = txtUsername.getText().toString();

                Intent pindahHalaman = new Intent(MainActivity.this, SecondPage.class);
                pindahHalaman.putExtra("username", namaUser);
                startActivity(pindahHalaman);
            }
        });

        btnOpenURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://newbinusmaya.binus.ac.id";
                Intent bukaURL = new Intent(Intent.ACTION_VIEW);
                bukaURL.setData(Uri.parse(url));

                startActivity(bukaURL);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:08123456");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                startActivity(callIntent);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareToApp = new Intent();
                shareToApp.setAction(Intent.ACTION_SEND);
                shareToApp.putExtra(Intent.EXTRA_TEXT, "ini adalah pesan");
                shareToApp.setType("text/plain");

                //langsung ke WA
                //shareToApp.setPackage("com.whatsapp");

                startActivity(shareToApp);
            }
        });
    }
}