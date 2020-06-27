package com.murach.androidessay;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class android_creator extends AppCompatActivity {

    // Adding the main widgets.
    private Button Btn_AndroidCreator;
    private TextView Lbl_AndroidCreator;
    private ScrollView ScrollBar_AndroidCreators;

    // Adding the Paragraph textviews.
    private TextView Txt_IntroParagrap1_AndroidCreator;
    private TextView Txt_IntroParagrap2_AndroidCreator;
    private TextView Txt_IntroParagrap3_AndroidCreator;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_creator);


        // Making a reference to all the widgets.
        Btn_AndroidCreator = findViewById(R.id.Btn_AndroidCreator);
        Lbl_AndroidCreator = findViewById(R.id.Lbl_AndroidCreator);


        Txt_IntroParagrap1_AndroidCreator = findViewById(R.id.Paragraph1_AndroidCreators);
        Txt_IntroParagrap2_AndroidCreator = findViewById(R.id.Paragraph2_AndroidCreators);
        Txt_IntroParagrap3_AndroidCreator = findViewById(R.id.Paragraph3_AndroidCreators);


        ScrollBar_AndroidCreators = findViewById(R.id.ScrollBar_AndroidCreators);
        Lbl_AndroidCreator.setText("Android Creators");

        // Allowing the user to scroll inside the textview.
        Txt_IntroParagrap1_AndroidCreator.setMovementMethod(new ScrollingMovementMethod());
        Txt_IntroParagrap2_AndroidCreator.setMovementMethod(new ScrollingMovementMethod());
        Txt_IntroParagrap3_AndroidCreator.setMovementMethod(new ScrollingMovementMethod());

        Txt_IntroParagrap1_AndroidCreator.setText("Rich Miller was born on May 25th, 1964 and went on to receive his Ph.D. in computer science at University of Massachusetts at Lowell, Miller later went to become a co-founder of Android during its creation which later allowed him to work for Google that lead the development team." + "Miller left Google to become the vice president of Orange, a telecommunications company (Rich co-founded Android and is a pioneer in the mobile space., 2019).");
        Txt_IntroParagrap2_AndroidCreator.setText("Nick Sears the second founder of Android first served three years in the U.S Army providing administrative support to the 10th Special forces group. Sears later began his professional career as a CPA and consult for Ernst & Young joining the AT&T two years later. Nick received a master’s in business administration from pacific Lutheran University, Nick later became “a Vice President at T-Mobile USA, where he led product management and marketing teams through the convergence of mobile phones, personal computers and the Internet.” Lastly becoming one of the founders of Android inc, the company before Google bought them. (Nick Sears, 2019).");
        Txt_IntroParagrap3_AndroidCreator.setText("With little to no information about Chris White we lastly move onto Andy Rubin the father of Android and the one that lead the rest of the founders to creating the companies big name. Andy Rubin fasciation began with an interest in all gadgets, thanks to his father that ran a marketing firm it allowed Rubin to discover all the latest electronic devices which sparked his interest in electronics. Rubin went on to graduate from the Utica College in New York with a major in computer sciences. While on a vacation in the Cayman Islands Rubin rescued, a stranger known as Bill Caswell, a man who would later go on to offer Rubin a job at Apple as a manufacturing engineer. After working for Apple for nearly three years Rubin went on to job hopping around until founding Android inc the company that was later bought by Google. Rubin went on to work with Google as a project manager creating their Android phones for the next few years. Rubin left google and is currently working in a company that develops hardware startups");

        Btn_AndroidCreator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Moves to the next Page
                MovePage_AndroidCreator_to_Conclusion();
            }
        });


        ScrollBar_AndroidCreators.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagrap1_AndroidCreator.getParent().requestDisallowInterceptTouchEvent(false);
                Txt_IntroParagrap2_AndroidCreator.getParent().requestDisallowInterceptTouchEvent(false);
                Txt_IntroParagrap3_AndroidCreator.getParent().requestDisallowInterceptTouchEvent(false);

                return false;
            }
        });

        Txt_IntroParagrap1_AndroidCreator.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagrap1_AndroidCreator.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        Txt_IntroParagrap2_AndroidCreator.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagrap2_AndroidCreator.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        Txt_IntroParagrap3_AndroidCreator.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagrap3_AndroidCreator.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

    }
        // Moves forward to the page.
        public void MovePage_AndroidCreator_to_Conclusion() {

            Intent Intent_MovePage_Intro_to_Mobile = new Intent(android_creator.this, Conclusion.class);
            startActivity(Intent_MovePage_Intro_to_Mobile);
        }
    }

