package com.developer.recyclerviewtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerContainer;
    List<ContactData> contactList;
    ContactAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerContainer = findViewById(R.id.contactContainer);

        loadData();

        myAdapter = new ContactAdapter(contactList);
        recyclerContainer.setLayoutManager(new LinearLayoutManager(this));
        recyclerContainer.setAdapter(myAdapter);
    }

    private void loadData(){
        contactList = new ArrayList<>();

        contactList.add(new ContactData(R.drawable.ic_car, "Johnny", "82342212"));
        contactList.add(new ContactData(R.drawable.ic_plane, "Jane", "865504304"));
        contactList.add(new ContactData(R.drawable.ic_car, "Ron", "819945342"));
        contactList.add(new ContactData(R.drawable.ic_plane, "Harry", "82334412"));
        contactList.add(new ContactData(R.drawable.ic_car, "William", "82249853"));
    }
}