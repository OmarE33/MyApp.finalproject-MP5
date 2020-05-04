package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.R.layout;
import android.widget.SearchView;

public class Recentbooks extends AppCompatActivity {
    private BookListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recentbooks);
        ListView list = findViewById(R.id.theList);
        SearchView searchBar = findViewById(R.id.search_bar);
        BookClient searchBooks = new BookClient();
        List<Book> listToAdd = new ArrayList<>();


        //listToAdd = searchBooks.search(searchBar.getQuery().toString());
        Book harry = new Book(120, "omar", "harry Potter");
        listToAdd.add(harry);

        adapter = new BookListAdapter(this, R.layout.activity_custom, listToAdd);
        list.setAdapter(adapter);

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

}
