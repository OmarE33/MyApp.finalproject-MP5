package com.example.myapp;


public class Book {
    int pages;
    String author;
    String title;
    String coverURL;
    String url;
    String genre;

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPages() {
        return pages;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public String getUrl() {
        return url;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Book () {

    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public Book (String setGenre, String setAuthor, String setTitle) {
        author = setAuthor;
        title = setTitle;
        genre = setGenre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


}
