package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.widget.SearchView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class Recentbooks extends Temp {
    private BookListAdapter adapter;
    List<Book> listToAdd = new ArrayList<>();
    RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent intent = new Intent(this, Userprofile.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recentbooks);
        final Context toUse = this;
        final ListView list = findViewById(R.id.theList);
        final SearchView searchBar = findViewById(R.id.search_bar);
        Button back = findViewById(R.id.button);

        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

        // Instantiate the RequestQueue with the cache and network.
        queue = new RequestQueue(cache, network);
        queue.start();

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //adapter.getFilter().filter(query);

                listToAdd = search(query);
                adapter = new BookListAdapter(toUse, R.layout.activity_custom, listToAdd);
                list.setAdapter(adapter);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // gets book at that position
                Book book = (Book) parent.getAdapter().getItem(position);
                // adds book to list "meh" which is the list of books use has read
                // meh is an instance variable in class Temp which both Recentbooks and Userprofile extend
                meh.add(book);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temp temp = new Temp();
                startActivity(intent);

            }
        });

    }

    private static final String KEY_ = "AIzaSyDPRMo_AtgJgG-Tn0cDej3_Lwiarrc2LZc";

    String url;

    /**
     * Used as a helper function to search to get info about each book that match the term the user searched for.
     * @param volumeLink the link to the JsonObject of one specific book.
     * @return the Book object of that one specific book.
     */
    public Book searchSpecific(String volumeLink) {
        url = volumeLink;
        final Book first = new Book();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, volumeLink, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String title = response.getJSONObject("volumeInfo").getString("title");
                            String author = response.getJSONObject("volumeInfo").getString("authors");
                            int pages = response.getJSONObject("volumeInfo").getInt("pageCount");
                            JSONArray genres = response.getJSONObject("volumeInfo").getJSONArray("categories");
                            String genre = "not found";
                            for (int i = 0; i < genres.length(); i++) {
                                genre = genres.getString(0);
                            }

                            first.setAuthor(author);
                            first.setPages(pages);
                            first.setTitle(title);
                            first.setUrl(url);
                            first.setGenre(genre);
                        } catch(Exception e) {
                            System.out.println("error in searchSpecific");
                            System.out.println(e);
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

    /**
     * search calls searchSpecific which finds the JsonObject of one specific book from the list of books
     * found using the GET request below (like a GET request inside another GET request)
     * @param searchedTerm the term that the user put in search bar
     * @return a list of Book objects that represent the search results the user looked for
     */
    public List<Book> search(String searchedTerm) {
        String searchURL = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + searchedTerm;
        final List<Book> books = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, searchURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray array = response.getJSONArray("items");
                            for (int i = 0; i < array.length(); i++) {
                                String link = array.getJSONObject(i).getString("selfLink");
                                Book x = searchSpecific(link);
                                books.add(x);
                            }
                        } catch (Exception e) {
                            System.out.println("error in search");
                            System.out.println(e);
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

    public void onStop() {
        super.onStop();
    }
}
