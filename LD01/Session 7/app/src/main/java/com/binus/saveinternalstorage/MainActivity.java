package com.binus.saveinternalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button saveBtn, loadBtn;
    EditText txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContent = findViewById(R.id.txtContents);
        saveBtn = findViewById(R.id.saveBtn);
        loadBtn = findViewById(R.id.loadBtn);

        String fileName = "temp.txt";

        File sdCard = Environment.getExternalStorageDirectory();
        File directory = new File (sdCard.getAbsolutePath() + "/MyFiles");
        File file = new File(directory, fileName);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contentText = txtContent.getText().toString();

                FileOutputStream fos;
                try{
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter myOutWritter = new OutputStreamWriter(fOut);
                    myOutWritter.append(contentText);
                    myOutWritter.close();
                    fOut.close();

//                    fos = openFileOutput(fileName, Context.MODE_PRIVATE);
//                    fos.write(contentText.getBytes());
//                    fos.close();

                    Toast.makeText(getApplicationContext(), fileName + " saved", Toast.LENGTH_SHORT).show();
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer stringBuffer = new StringBuffer();
                try{
                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
                    String text;
                    while((text = inputReader.readLine()) != null){
                        stringBuffer.append(text+'\n');
                    }
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), stringBuffer.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}