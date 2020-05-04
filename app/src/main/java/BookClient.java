import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapp.Book;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookClient {
    private static final String KEY_ = "AIzaSyDPRMo_AtgJgG-Tn0cDej3_Lwiarrc2LZc";

    String url;

    String cover;

    BookClient() {

    }
    public Book searchSpecific(String volumeLink) {
        url = volumeLink;
        Book first = new Book();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, volumeLink, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            cover = (String) response.get("thumbnail");
                            int pages = (int) response.get("pageCount");
                            String title = (String) response.get("title");
                            String author = (String) response.get("authors");
                        } catch(Exception e) {

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });
    }

    public List<Book> search(String searchedTerm) {
        String searchURL = "https://www.googleapis.com/books/v1/volumes?q=" + searchedTerm + "+intitle:" + KEY_;
        List<Book> books = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, searchURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String link = (String) response.get("selfLink");

                        } catch (Exception e) {

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });
        return books;
    }

}
