package com.example.myapp;

import java.util.List;
public class Book {
    int pages;
    String genre;
    String author;
    String title;
    List<Integer> pageNumbers;
    Book (String setGenre, String setAuthor, String setTitle) {
        genre = setGenre;
        author = setAuthor;
        title = setTitle;
        for (int i = 0; i < pages; i++) {
            pageNumbers.add(i + 1);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public List<Integer> getPageNumbers() {
        return pageNumbers;
    }

    public void bookMark(int currentPage) {
        for (int i = 0; i < pageNumbers.size(); i++) {
            if (pageNumbers.get(i) == currentPage) {
                pageNumbers.add(i, 0);
            }
        }
    }
}
