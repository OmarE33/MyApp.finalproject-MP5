package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.widget.SearchView;

public class Recentbooks extends AppCompatActivity {
    private BookListAdapter adapter;
    List<Book> listToAdd = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recentbooks);
        final ListView list = findViewById(R.id.theList);
        final SearchView searchBar = findViewById(R.id.search_bar);
        final BookClient searchBooks = new BookClient();

        adapter = new BookListAdapter(this, R.layout.activity_custom, listToAdd);
        System.out.println("oncreate");

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                listToAdd = searchBooks.search(searchBar.getQuery().toString());

                list.setAdapter(adapter);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                listToAdd = searchBooks.search(searchBar.getQuery().toString());

                list.setAdapter(adapter);
                return false;
            }
        });

    }

}
