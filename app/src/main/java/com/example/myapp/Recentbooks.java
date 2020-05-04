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

        Book harry = new Book("fantasy", "steve", "Harry Potter");
        Book harry1 = new Book("fantasy", "steve", "Harry Potter");
        Book harry2 = new Book("nonfiction", "omar", "Death and 1891");
        Book harry3 = new Book("fantasy", "steve", "Harry Potter");
        Book harry4 = new Book("fantasy", "steve", "Harry Potter");
        Book harry5 = new Book("fantasy", "steve", "Harry Potter");
        Book harry6 = new Book("fantasy", "steve", "Harry Potter");
        Book harry7 = new Book("fantasy", "steve", "Harry Potter");
        Book harry8 = new Book("fantasy", "steve", "Harry Potter");
        Book harry9 = new Book("fantasy", "steve", "Harry Potter");
        Book harry0 = new Book("fantasy", "steve", "Harry Potter");


        List<Book> listToAdd = new ArrayList<>();
        listToAdd.add(harry);
        listToAdd.add(harry1);
        listToAdd.add(harry2);
        listToAdd.add(harry3);
        listToAdd.add(harry4);
        listToAdd.add(harry5);
        listToAdd.add(harry6);
        listToAdd.add(harry7);
        listToAdd.add(harry8);
        listToAdd.add(harry9);
        listToAdd.add(harry0);


        BookListAdapter adapter = new BookListAdapter(this, R.layout.activity_custom, listToAdd);
        list.setAdapter(adapter);
    }
}
