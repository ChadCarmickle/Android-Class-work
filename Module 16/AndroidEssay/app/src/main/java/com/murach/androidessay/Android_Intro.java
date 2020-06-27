package com.murach.androidessay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class Android_Intro extends AppCompatActivity {

    // Basic Variables.
    private Button Btn_Next_AndroidIntro;
    private TextView Lbl_Android_Intro;
    private ScrollView ScrollBar_Android_Intro;

    // Labels for photos
    private TextView PhotoText1;
    private TextView PhotoText2;
    private TextView PhotoText3;

    // Paragraph textviews.
    private TextView Txt_IntroParagraph1_Android_Intro;
    private TextView Txt_IntroParagraph2_Android_Intro;
    private TextView Txt_IntroParagraph3_Android_Intro;
    private TextView Txt_IntroParagraph4_Android_Intro;
    private TextView Txt_IntroParagraph5_Android_Intro;
    private TextView Txt_IntroParagraph6_Android_Intro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android__intro);

        // Reference to scrollBar
        ScrollBar_Android_Intro = findViewById(R.id.ScrollBar_Android_Intro);

        // Reference and sets to Picture Labels.
        PhotoText1 = findViewById(R.id.PhotoText1_AndroidIntro);
        PhotoText2 = findViewById(R.id.PhotoText2_AndroidIntro);
        PhotoText3 = findViewById(R.id.PhotoText3_AndroidIntro);
        PhotoText1.setText("Iphone XS Max");
        PhotoText2.setText("Galaxy S10");
        PhotoText3.setText("Palo Alto California, USA");

        // Reference to Paragraphs
        Txt_IntroParagraph1_Android_Intro = findViewById(R.id.Txt_IntroParagraph1_Android_Intro);
        Txt_IntroParagraph2_Android_Intro = findViewById(R.id.Txt_IntroParagraph2_Android_Intro);
        Txt_IntroParagraph3_Android_Intro = findViewById(R.id.Txt_IntroParagraph3_Android_Intro);
        Txt_IntroParagraph4_Android_Intro = findViewById(R.id.Txt_IntroParagraph4_Android_Intro);
        Txt_IntroParagraph5_Android_Intro = findViewById(R.id.Txt_IntroParagraph5_Android_Intro);
        Txt_IntroParagraph6_Android_Intro = findViewById(R.id.Txt_IntroParagraph6_Android_Intro);

        Txt_IntroParagraph1_Android_Intro.setText("On September 12th, 2018, Apple revealed their newest iPhone, the iPhone XS MAX. With a 6.5-inch screen the phone was priced at $1,100 dollar and pushed the limits of Apple to making it faster, sleeker and more desirable to users (Bart Pursel, 2018).  The new phone claims to have a more advanced processor and more durable screen against scraps and cracks.");
        Txt_IntroParagraph2_Android_Intro.setText("Not far behind though Samsung has created their version of the newest phone called the Galaxy S10, with a lower price than the Apple’s phone priced at $750 dollars (CAMP, 2019). With both companies spending hundreds of dollars on their newest technology for example,  Samsung reportedly spending over $307 dollars on each of their Galaxy S8 phones with a retail value of $720 making a $420 potential revenue from each sale (Morris, 2017), one might ask how did these companies scale to such mighty giants in the technology world making millions each year?");
        Txt_IntroParagraph3_Android_Intro.setText("For sake of complexity we will dive into the world of Android and how it all started. In 2003 of October, before the term smartphone was coined, the company Android inc was founded in Palo Alto California by its four founders (Callaham, 2018). The company was first founded to help build better and more complex operating systems for digital cameras, they soon had to scrap the idea when they saw the decline of camera’s was dropping. They instead took their feet and dove into the realm of operating systems development to challenge Microsoft Windows Mobile and later in time Apple iPhones (Khamlichi, 2015). ");
        Txt_IntroParagraph4_Android_Intro.setText("Although the project was showing positive results, it wasn’t until Rubin was able to obtain a ten-thousand-dollar donation from a friend that the company skyrocketed its popularity. On July 2005, the recent success of the small company caught eyes of a particular big fish known as Google, who later went on to buying the company for a staggering fifty million dollars (Khamlichi, 2015). Nick sears soon left the company after Google bought them, while the other three founders remained and lead development teams that would later create Google's mobile phones known as Android. The three former founders went on to create Androids iconic flavors or versions of its software coined by their desert names (Khamlichi, 2015).");
        Txt_IntroParagraph5_Android_Intro.setText("In 2014 Android released its latest Android flavor known as Lollipop, sticking to the naming of deserts and a more updated version to its predecessors known as Cupcake (version 1.5) to KitKat (version 4.4.4) (Khamlichi, 2015). Version Lollipop also known as version 5.0, introduced a new design language, the ability of multitasking and animations. The phone became a massive selling point, soon becoming the most popular operating system or flavor of Android.  One phone that had Lollipop was the HTC ONE which sold over 6.4 million units in 2013 (Charles & Samuel, 2014). ");
        Txt_IntroParagraph6_Android_Intro.setText("Today we can enjoy the most current Android flavor known as Pie (version 9.0). With many new features being added it will now or soon be available to users and developers. Some of the most recent features that the new flavor will include are, App Timers, the ability to set limits on applications that will then gray out the icons hinting to the user they have used their allotted time, a more advanced screen rotation that has the option to rotate the screen landscape mode and back with a tap of an icon and lastly the new adaptive battery that will allow the users to hibernate all apps not being used and many more features to come (Okoi, 2018). ");


        // Reference to basic Widgets.
        Btn_Next_AndroidIntro = findViewById(R.id.Btn_Next_AndroidIntro);
        Lbl_Android_Intro = findViewById(R.id.Lbl_Android_Intro);
        Lbl_Android_Intro.setText("Android Introduction.");


        Btn_Next_AndroidIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Moves to the next Page
                MovePage_AndroidIntro_to_AndroidCreators();
            }
        });

        Txt_IntroParagraph1_Android_Intro.setMovementMethod(new ScrollingMovementMethod());
        Txt_IntroParagraph2_Android_Intro.setMovementMethod(new ScrollingMovementMethod());
        Txt_IntroParagraph3_Android_Intro.setMovementMethod(new ScrollingMovementMethod());
        Txt_IntroParagraph4_Android_Intro.setMovementMethod(new ScrollingMovementMethod());
        Txt_IntroParagraph5_Android_Intro.setMovementMethod(new ScrollingMovementMethod());
        Txt_IntroParagraph6_Android_Intro.setMovementMethod(new ScrollingMovementMethod());

        /*********************************
         *                                *
         *       Textview Scrolls inside  *
         *              ScrowView         *
         *********************************/

      ScrollBar_Android_Intro.setOnTouchListener(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Txt_IntroParagraph1_Android_Intro.getParent().requestDisallowInterceptTouchEvent(false);
            Txt_IntroParagraph2_Android_Intro.getParent().requestDisallowInterceptTouchEvent(false);
            Txt_IntroParagraph3_Android_Intro.getParent().requestDisallowInterceptTouchEvent(false);
            Txt_IntroParagraph4_Android_Intro.getParent().requestDisallowInterceptTouchEvent(false);
            Txt_IntroParagraph5_Android_Intro.getParent().requestDisallowInterceptTouchEvent(false);
            Txt_IntroParagraph6_Android_Intro.getParent().requestDisallowInterceptTouchEvent(false);

            return false;
        }
    });

        Txt_IntroParagraph1_Android_Intro.setOnTouchListener(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Txt_IntroParagraph1_Android_Intro.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    });

        Txt_IntroParagraph2_Android_Intro.setOnTouchListener(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Txt_IntroParagraph2_Android_Intro.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    });
        Txt_IntroParagraph3_Android_Intro.setOnTouchListener(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Txt_IntroParagraph3_Android_Intro.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    });

        Txt_IntroParagraph4_Android_Intro.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagraph4_Android_Intro.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        Txt_IntroParagraph5_Android_Intro.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagraph5_Android_Intro.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        Txt_IntroParagraph6_Android_Intro.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagraph6_Android_Intro.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
}


    // Moves forward to the page.
    public void MovePage_AndroidIntro_to_AndroidCreators() {

        Intent Intent_MovePage_Intro_to_Mobile = new Intent(Android_Intro.this, android_creator.class);
        startActivity(Intent_MovePage_Intro_to_Mobile);
    }
}

