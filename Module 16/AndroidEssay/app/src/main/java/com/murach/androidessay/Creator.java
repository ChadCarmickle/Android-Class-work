package com.murach.androidessay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import java.util.TimerTask;

public class Creator extends AppCompatActivity {

    private Button Next_Btn_AndroidCreator;
    private TextView Lbl_AppCreator;

    private TextView Ttitle;
    private TextView Bio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator);

        Ttitle = findViewById(R.id.NameTxt);
        Ttitle.setText("Chad Carmickle");

        Bio = findViewById(R.id.BioTxt);
        Bio.setText("Hi, Thanks for checking out my app. I made this on April 21st 2019. I made this application for my SDEV-250 class, Android Mobile Development. This app was fun to program and create I had a bit of trouble trying to gather my thoughts and all my java and layouts correct, I had many problems with the naming of variablees due to me copying and messing them up. Anyways I do hope you enjoy, Bye!");

        Lbl_AppCreator = findViewById(R.id.Lbl_AppCreator);

        Lbl_AppCreator.setText(" Creator of App.");
        Next_Btn_AndroidCreator = findViewById(R.id.Next_Btn_AndroidCreator);

        Next_Btn_AndroidCreator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Moves to the next Page
                MovePage_AppCreator_to_MainActivity();
            }
        });
    }


    // Moves forward to the page.
    public void MovePage_AppCreator_to_MainActivity() {

        Intent Intent_MovePage_Intro_to_Mobile = new Intent(Creator.this, MainActivity.class);
        startActivity(Intent_MovePage_Intro_to_Mobile);
    }
}