package id.ac.binus.pertemuan3lg01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pindahBtn = findViewById(R.id.pindahBtn);
        checkBox = findViewById(R.id.checkBox);
        pindahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
//                if (checkBox.isChecked()){
//                    Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "No", Toast.LENGTH_LONG).show();
//                }
            }
        });

        Log.d("State Manager", "saat ini sedang onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("State Manager", "saat ini sedang onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("State Manager", "saat ini sedang onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("State Manager", "saat ini sedang onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("State Manager", "saat ini sedang onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("State Manager", "saat ini sedang onDestroy");

    }
}