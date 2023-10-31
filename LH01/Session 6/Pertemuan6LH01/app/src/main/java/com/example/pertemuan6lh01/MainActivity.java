package com.example.pertemuan6lh01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for contextual menu
        TextView helloTV = findViewById(R.id.helloTV);
        registerForContextMenu(helloTV);

        //for popup menu
        Button popButton = findViewById(R.id.popButton);
        popButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popMenu = new PopupMenu(MainActivity.this, popButton);
                popMenu.getMenuInflater().inflate(R.menu.context_item_menu, popMenu.getMenu());

                popMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int selectedId = item.getItemId();

                        if (selectedId == R.id.itemEdit){
                            Toast.makeText(MainActivity.this, "Edit Clicked", Toast.LENGTH_SHORT).show();
                        }else if (selectedId == R.id.itemDelete){
                            Toast.makeText(MainActivity.this, "Delete Clicked", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                popMenu.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.context_item_menu, menu);
        menu.setHeaderTitle("Menu Title");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int selectedId = item.getItemId();

        if (selectedId == R.id.itemEdit){
            Toast.makeText(this, "Edit Clicked", Toast.LENGTH_SHORT).show();
        }else if (selectedId == R.id.itemDelete){
            Toast.makeText(this, "Delete Clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.option_item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int selectedId = item.getItemId();
        
        if (selectedId == R.id.itemSettings){
            Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
        }else if (selectedId == R.id.itemLogout){
            Toast.makeText(this, "Logout Clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}