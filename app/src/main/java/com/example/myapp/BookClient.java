package com.example.myapp;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BookClient extends Recentbooks{
    private static final String KEY_ = "AIzaSyDPRMo_AtgJgG-Tn0cDej3_Lwiarrc2LZc";

    String url;

    String cover;

    public BookClient() {

    }

    public Book searchSpecific(String volumeLink) {
        url = volumeLink;
        final Book first = new Book();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, volumeLink, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            cover = (String) response.get("thumbnail");
                            int pages = (int) response.get("pageCount");
                            String title = (String) response.get("title");
                            String author = (String) response.get("authors");
                            first.setAuthor(author);
                            first.setPages(pages);
                            first.setTitle(title);
                            first.setCoverURL(cover);
                            first.setUrl(url);
                        } catch(Exception e) {
                            System.out.println("error in searchSpecific");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });
        queue.add(jsonObjectRequest);
        return first;
    }

    public List<Book> search(String searchedTerm) {
        String searchURL = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + searchedTerm;
        final List<Book> books = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, searchURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            BookClient search = new BookClient();
                            JSONArray array = response.getJSONArray("items");
                            for (int i = 0; i < 20; i++) {
                                String link = (String) array.getJSONObject(i).get("selfLink");
                                Book x = search.searchSpecific(link);
                                books.add(x);
                            }
                        } catch (Exception e) {
                            System.out.println("error in search");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });
        queue.add(jsonObjectRequest);
        return books;
    }
}
