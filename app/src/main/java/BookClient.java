import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class BookClient {
    String resourceID;
    private static final String KEY_ = "AIzaSyDPRMo_AtgJgG-Tn0cDej3_Lwiarrc2LZc";
    String url = "https://www.googleapis.com/books/v1/volumes/" + resourceID;
    JSONObject toUse;
    BookClient(String volumeID) {
        resourceID = volumeID;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        toUse = response;
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });
    }

    private void search() {
        String searchURL = "https://www.googleapis.com/books/v1/volumes?q=" + "searchedterm" + "+intitle";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, searchURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // sets the list to books matching search word in title
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });
    }
}
