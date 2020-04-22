import java.util.List;

public class User {
    List<String> books;
    List<String> genres;
    List<String> authors;
    List<Integer> pageNum
    User (List<String> setBooks, List<String> setGenres, List<String> setAuthors, List<Integer> setPageNum) {
        books = setBooks;
        genres = setGenres;
        authors = setAuthors;
        pageNum = setPageNum;
    }
    public int totalPages() {
        int toReturn = 0;
        for (int i = 0; i < pageNum.size(); i++) {
            toReturn = toReturn + i;
        }
        return toReturn;
    }
    public String favAuthor() {
        List<Integer> num = pageNum;
        for (int i = 0; i < authors.size(); i++) {
            int count = 0;
            for (int j = 0; j < authors.size(); i++) {
                if (i == j) {
                    count++;
                }
            }
            num.add(count, i);
        }
        int max = 0;
        for (int i = 0; i < num.size(); i++) {
            if (max < ) {

            }
        }
    }
    public String favGenre(genres) {

    }

}
