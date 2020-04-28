package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button recentbooks;
    private Button userprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recentbooks = findViewById(R.id.Recentbooks);
        recentbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToRecentBooks();


            }
        });

        userprofile = findViewById(R.id.Userprofile);
        userprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToUserProfile();

            }
        });
    }
    private void moveToRecentBooks() {
        Intent intent = new Intent(this, Recentbooks.class);
        startActivity(intent);
    }

    private void moveToUserProfile() {
        Intent intent = new Intent(this, Userprofile.class);
        startActivity(intent);
    }

}
