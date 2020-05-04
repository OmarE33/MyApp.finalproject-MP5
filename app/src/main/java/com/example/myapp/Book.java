package com.example.myapp;


public class Book {
    int pages;
    String author;
    String title;
    String coverURL;
    String url;

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

    public Book (int pageCount, String setAuthor, String setTitle) {
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


}
