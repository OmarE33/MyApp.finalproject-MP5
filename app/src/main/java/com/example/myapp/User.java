package com.example.myapp;

import java.util.ArrayList;
import java.util.List;

public class User {
    /**
     * list of books user has read.
     */
    List<String> books;
    /**
     * list of the genres of the books the user has read.
     */
    List<String> genres;
    /**
     * list of the authors of the books the user has read.
     */
    List<String> authors;
    /**
     * list of the page numbers of the books the user has read.
     */
    List<Integer> pageNum;

    /**
     * sets all the lists above
     * @param setBooks books read
     * @param setGenres genres read
     * @param setAuthors authors of books read
     * @param setPageNum page numbers of books read.
     *
     */
    User (List<String> setBooks, List<String> setGenres, List<String> setAuthors, List<Integer> setPageNum) {
        books = setBooks;
        genres = setGenres;
        authors = setAuthors;
        pageNum = setPageNum;
    }

    /**
     * sets all list from a list of Book objects
     * @param books2 llist of Book objects
     */
    User (List<Book> books2) {
        books = new ArrayList<>();
        genres = new ArrayList<>();
        authors = new ArrayList<>();
        pageNum = new ArrayList<>();
        for (int i = 0; i < books2.size(); i++) {
            String author = books2.get(i).getAuthor();
            int pages = books2.get(i).getPages();
            String title = books2.get(i).getTitle();
            String genre = books2.get(i).getGenre();
            books.add(title);
            genres.add(genre);
            authors.add(author);
            pageNum.add(pages);
        }
    }
    /**
     * calculates the total number of pages the user has read.
     * @return the total number of pages read by the user.
     */
    public int totalPages() {
        int toReturn = 0;
        for (int i = 0; i < pageNum.size(); i++) {
            toReturn = toReturn + i;
        }
        return toReturn;
    }

    /**
     * gives the user's favorite author out of all the books they have read.
     * @return the user's favorite author.
     */
    public String favAuthor() {
        List<Integer> num = new ArrayList<>();
        if (authors.size() == 0) {
            return "none";
        }
        for (int i = 0; i < authors.size(); i++) {
            int count = 0;
            for (int j = 0; j < authors.size(); i++) {
                if (authors.get(i) == authors.get(j)) {
                    count++;
                }
            }
            num.add(count);
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < num.size(); i++) {
            if (max < num.get(i)) {
                max = num.get(i);
                index = i;
            }
        }
        return authors.get(index);
    }

    /**
     * gives the user's favorite genre out of all the books they have read.
     * @return returns the user's favorite genre.
     */
    public String favGenre() {
        List<Integer> num = new ArrayList<>();
        if (genres.size() == 0) {
            return "none";
        }
        for (int i = 0; i < genres.size(); i++) {
            int count = 0;
            for (int j = 0; j < genres.size(); i++) {
                if (genres.get(i) == genres.get(j)) {
                    count++;
                }
            }
            num.add(count);
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < num.size(); i++) {
            if (max < num.get(i)) {
                max = num.get(i);
                index = i;
            }
        }
        return genres.get(index);
    }

    /**
     * the current book the user is reading or last book the user read.
     * @return the current book the user is reading
     */
    public String currentBook() {
        return books.get(books.size() - 1);
    }
}
