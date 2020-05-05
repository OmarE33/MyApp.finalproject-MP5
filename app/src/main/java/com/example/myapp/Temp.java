package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
//Used as a medium class to try to make the user and their list of books that they have read universal to
//the entirety of the app.
public class Temp extends AppCompatActivity {
    User user;
    List<Book> meh = new ArrayList<>();
    Temp() {
        user = new User(meh);
    }

}
