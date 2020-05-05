package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Userprofile extends AppCompatActivity {
    Button run;
    TextView favgenre;
    TextView favauthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        favgenre = (TextView)findViewById(R.id.favgenre);
        favauthor = (TextView)findViewById(R.id.favAuthor);
        run = (Button)findViewById(R.id.calculateButton);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favgenre.setText(User.favGenre());
                favauthor.setText(User.favAuthor());
            }
        });
    }
}
