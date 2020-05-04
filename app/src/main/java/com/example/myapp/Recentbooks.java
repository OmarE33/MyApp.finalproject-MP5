package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.R.layout;

public class Recentbooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recentbooks);
        ListView list = findViewById(R.id.theList);
        EditText searchBar = findViewById(R.id.search_bar);

        List<Book> listToAdd = new ArrayList<>();




        BookListAdapter adapter = new BookListAdapter(this, R.layout.activity_custom, listToAdd);
        list.setAdapter(adapter);
    }
}
