package com.example.myapp;

// A bunch of getters and setters to the instance variables that make up the Book object
public class Book {
    // total pages in book
    int pages;
    // author of book
    String author;
    //title of book
    String title;
    //url of the thumbnail image of book
    String coverURL;
    //specific url of book that can be used for a GET request
    String url;
    //genre of the book
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
