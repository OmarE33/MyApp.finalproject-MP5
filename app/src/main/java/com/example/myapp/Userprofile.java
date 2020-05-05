package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Userprofile extends Temp {
    Button run;
    TextView favgenre;
    TextView favauthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        favgenre = (TextView)findViewById(R.id.Namefavgenre);
        favauthor = (TextView)findViewById(R.id.NamefavAuthor);
        run = (Button)findViewById(R.id.calculateButton);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.favAuthor() == null) {
                    favgenre.setText("error");
                }
                if (user.favGenre() == null) {
                    favauthor.setText("error");
                } else {
                    favgenre.setText(user.favGenre());
                    favauthor.setText(user.favAuthor());
                }

            }
        });
    }
}
