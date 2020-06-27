package com.murach.androidessay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private TextView LogoText;

    private Button Next_btn;
    private Button Intro_btn;
    private Button Moble_btn;
    private Button Android_btn;
    private Button AndroidCreators_btn;
    private Button Conclusion_btn;
    private Button AppCreator_btn;
    private Button Sources_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        LogoText = findViewById(R.id.LogoText);
        Next_btn = findViewById(R.id.Next_Btn_Mobile);
        Intro_btn = findViewById(R.id.Intro_Btn);
        Moble_btn = findViewById(R.id.Mobile_Btn);
        Android_btn = findViewById(R.id.Android_Btn);
        AndroidCreators_btn = findViewById(R.id.Android_Creators_btn);
        Conclusion_btn = findViewById(R.id.Conclusion_Btn);
        AppCreator_btn = findViewById(R.id.Creator_btn);
        Sources_btn = findViewById(R.id.Source_btn);


        LogoText.setText("Home");
        /***********************************
         *                                 *
         *      Button Listeners           *
         **********************************/
        // Moves to Introduction Page
        Next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MovePage_Home_to_Intro();
            }
        });
        // Moves to Introduction Page.
        Intro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MovePage_Home_to_Intro();
            }
        });

        // Moves to Mobile Page.
        Moble_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MovePage_Home_to_Moble();
            }
        });

        // Moves to Intro Android
        Android_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MovePage_Home_to_AndroidIntro();
            }
        });

        // Move to Android Creator page
        AndroidCreators_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MovePage_Home_to_AndroidCreators();
            }
        });

        // Move to Conclusion Page
        Conclusion_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MovePage_Home_to_Conclusion();
            }
        });

        // Move to Sources Page
        Sources_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MovePage_Home_to_Sources();
            }
        });

        // Moves to App Creator's Page.
        AppCreator_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MovePage_Home_to_AppCreator();
            }
        });

    } // End of on create


    /***********************************
     *                                 *
     *      Button Methods             *
     **********************************/
    // Move to Intro Page
    public void MovePage_Home_to_Intro() {

        Intent MovePage_Home_to_Intro = new Intent(MainActivity.this, Intro.class);
        startActivity(MovePage_Home_to_Intro);
    }

    public void MovePage_Home_to_Moble() {

        Intent MovePage_Home_to_Moble = new Intent(MainActivity.this, Mobile_Computing.class);
        startActivity(MovePage_Home_to_Moble);
    }

    public void MovePage_Home_to_AndroidIntro() {

        Intent MovePage_Home_to_AndroidIntro = new Intent(MainActivity.this, Android_Intro.class);
        startActivity(MovePage_Home_to_AndroidIntro);
    }

    public void MovePage_Home_to_AndroidCreators() {

        Intent MovePage_Home_to_AndroidCreators = new Intent(MainActivity.this, android_creator.class);
        startActivity(MovePage_Home_to_AndroidCreators);
    }

    public void MovePage_Home_to_Conclusion() {

        Intent MovePage_Home_to_Conclusion = new Intent(MainActivity.this, Conclusion.class);
        startActivity(MovePage_Home_to_Conclusion);
    }

    public void MovePage_Home_to_Sources() {

        Intent MovePage_Home_to_Sources = new Intent(MainActivity.this, Sources.class);
        startActivity(MovePage_Home_to_Sources);
    }

    public void MovePage_Home_to_AppCreator() {

        Intent MovePage_Home_to_AppCreator = new Intent(MainActivity.this, Creator.class);
        startActivity(MovePage_Home_to_AppCreator);
    }


} // end of MainActivity

