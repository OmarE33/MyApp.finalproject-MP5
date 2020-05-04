package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookListAdapter extends ArrayAdapter<Book> {
    private Context makeCon;
    private int makeResource;
    public BookListAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
        makeCon = context;
        makeResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String title = getItem(position).getTitle();
        String genre = getItem(position).getGenre();
        String author = getItem(position).getAuthor();

        Book book = new Book(genre, author, title);

        LayoutInflater inflater = LayoutInflater.from(makeCon);
        convertView = inflater.inflate(makeResource, parent, false);
        TextView titleText = convertView.findViewById(R.id.)
        return  convertView;
    }
}