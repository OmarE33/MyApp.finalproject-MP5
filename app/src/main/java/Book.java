import android.util.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Book {
    int pages;
    String genre;
    String author;
    String title;
    List<Integer> pageNumbers;
    String openLibraryId;
    Book (int setPages, String setGenre, String setAuthor, String setTitle, JSONObject format) {
        pages = setPages;
        genre = setGenre;
        author = setAuthor;
        title = setTitle;
        for (int i = 0; i < pages; i++) {
            pageNumbers.add(i + 1);
        }
    }
    public void bookMark(int currentPage) {
        for (int i = 0; i < pageNumbers.size(); i++) {
            if (pageNumbers.get(i) == currentPage) {
                pageNumbers.add(i, 0);
            }
        }
    }
    public String getOpenLibraryId() {
        return openLibraryId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Get medium sized book cover from covers API
    public String getCoverUrl() {
        return "http://covers.openlibrary.org/b/olid/" + openLibraryId + "-M.jpg?default=false";
    }

    // Get large sized book cover from covers API
    public String getLargeCoverUrl() {
        return "http://covers.openlibrary.org/b/olid/" + openLibraryId + "-L.jpg?default=false";
    }
}
