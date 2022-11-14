package com.binus.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button popupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popupBtn = findViewById(R.id.popupBtn);

        popupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, popupBtn);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.editMenu:
                                Toast.makeText(MainActivity.this, "Edit Pressed", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.deleteMenu:
                                Toast.makeText(MainActivity.this, "Delete Pressed", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.cancelMenu:
                                Toast.makeText(MainActivity.this, "Cancel Pressed", Toast.LENGTH_SHORT).show();
                                return true;
                        }

                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }
}