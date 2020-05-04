package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Recentbooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recentbooks);
        ListView list = findViewById(R.id.theList);

        Book harry = new Book("fantasy", "steve", "Harry Potter");
        Book harry1 = new Book("fantasy", "steve", "Harry Potter");
        Book harry2 = new Book("nonfiction", "omar", "Death and 1891");
        Book harry3 = new Book("fantasy", "steve", "Harry Potter");
        Book harry4 = new Book("fantasy", "steve", "Harry Potter");

        List<Book> listToAdd = new ArrayList<>();
        listToAdd.add(harry);
        listToAdd.add(harry1);
        listToAdd.add(harry2);
        listToAdd.add(harry3);
        listToAdd.add(harry4);

        BookListAdapter adapter = new BookListAdapter(this, R.layout.activity_recentbooks, listToAdd);
        list.setAdapter(adapter);
    }
}
