import java.util.List;

public class Book {
    int pages;
    String genre;
    String author;
    String title;
    List<Integer> pageNumbers;
    Book (int setPages, String setGenre, String setAuthor, String setTitle) {
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
}
