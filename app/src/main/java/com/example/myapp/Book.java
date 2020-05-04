package com.example.myapp;


public class Book {
    int pages;
    String author;
    String title;
    Book (int pageCount, String setAuthor, String setTitle) {
        author = setAuthor;
        title = setTitle;
        pages = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageNumbers() {
        return pages;
    }

}
