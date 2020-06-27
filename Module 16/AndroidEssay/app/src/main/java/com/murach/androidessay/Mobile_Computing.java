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


public class Mobile_Computing extends AppCompatActivity {

    // Adding the main widgets.
    private Button Next_Btn_Mobile;
    private TextView Lbl_Mobile;
    private ScrollView ScrollBar_Mobile;

    // Adding the Paragraph textviews.
    private TextView Txt_IntroParagraph1_Mobile;
    private TextView Txt_IntroParagraph2_Mobile;
    private TextView Txt_IntroParagraph3_Mobile;

    // Adding the Photo Texts
    private TextView PhotoText1_Mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile__computing);

        Lbl_Mobile = findViewById(R.id.Lbl_MobileComputing);
        Next_Btn_Mobile = findViewById(R.id.Next_Btn_Mobile);
        Lbl_Mobile.setText("Mobile Introduction.");



        Next_Btn_Mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Moves to the next Page
                MovePage_Moble_to_Android_Intro();
            }
        });


        // Making a reference to all the widgets.
        Txt_IntroParagraph1_Mobile = findViewById(R.id.Txt_IntroParagraph1_Mobile);
        Txt_IntroParagraph2_Mobile = findViewById(R.id.Txt_IntroParagraph2_Mobile);
        Txt_IntroParagraph3_Mobile = findViewById(R.id.Txt_IntroParagraph3_Mobile);

        ScrollBar_Mobile = findViewById(R.id.ScrollBar_Mobile);
        PhotoText1_Mobile = findViewById(R.id.PhotoText1_Mobile);


        // Setting the text to my Paragraphs
        Txt_IntroParagraph1_Mobile.setText("One feature that all cell phones, laptops and even radios share is a term called wireless technology, but what is it?  To understand what wireless technology is, we need to go back and look at the father of radios, Guglielmo Marconi. Marconi put this dream to a reality, by playing a simple game of throw-and-catch, a radio station for example will use a transmitter that codes a pattern of electricity and magnetism into an electromagnetic wave (Woodford, 2018). This wave will then beam through the air in a straight line at the speed of light to a receiver. On the receiver end a radio with an antenna will catch these waves. Once caught the waves will be converted into voices and sounds of the audio of the person that created them. This technology is used everywhere from car radios when driven down the road to televisions in our homes and even to the cute cat videos we watch online at three in the morning, the night before a test (The beginning of Mobile Computing , n.d.), (Woodford, 2018).");
        Txt_IntroParagraph2_Mobile.setText("Today’s humans have evolved from just a radio playing audio to now having the ability to explore millions of websites with trillions amounts of information, such websites being Medical advancements to new automotive inventions and lastly news coverage of disasters from across the world. The ability to performs these feats we use daily in our homes can be thanked by a small computer called a router. Unlike our typical computers that allow us to perform research on our college papers or explore the internet for recipes on eggs, a router’s sole purpose is to relay connections to and from the internet. A router has an ability to connect several computers in one home to the internet. A router has two jobs in a home. One is to create a wireless computer network that connects all the computers together and the other is giving all your devices a shared gateway to communicate with each other or to the internet at once.\n");
        Txt_IntroParagraph3_Mobile.setText("Using similar technology from the radio, a cell-phone will act as the receiver and piggyback onto a network to access the internet. There are two ways a mobile phone can achieve this, one is connecting to an already established router and accessing the internet, some examples would be coffee shops that offer free WIFI to a public library (How Internet Works on Mobile Devices, 2019). The other method to connecting online is to using a cellular telephone service provider.  Depending upon the service provider, various payment plans are created to the user to determine how features will work such as data limits.\n");

        PhotoText1_Mobile.setText("Guglielmo Marconi.");


        // Allowing the user to scroll inside the textview.
        Txt_IntroParagraph1_Mobile.setMovementMethod(new ScrollingMovementMethod());
        Txt_IntroParagraph2_Mobile.setMovementMethod(new ScrollingMovementMethod());
        Txt_IntroParagraph3_Mobile.setMovementMethod(new ScrollingMovementMethod());



        /*********************************
         *                                *
         *       Textview Scrolls inside  *
         *              ScrowView         *
         *********************************/

        ScrollBar_Mobile.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagraph1_Mobile.getParent().requestDisallowInterceptTouchEvent(false);
                Txt_IntroParagraph2_Mobile.getParent().requestDisallowInterceptTouchEvent(false);
                Txt_IntroParagraph3_Mobile.getParent().requestDisallowInterceptTouchEvent(false);

                return false;
            }
        });

        Txt_IntroParagraph1_Mobile.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagraph1_Mobile.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        Txt_IntroParagraph2_Mobile.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagraph2_Mobile.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        Txt_IntroParagraph3_Mobile.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Txt_IntroParagraph3_Mobile.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    // Moves forward to the page.
    public void MovePage_Moble_to_Android_Intro() {

        Intent Intent_MovePage_Intro_to_Mobile = new Intent(Mobile_Computing.this, Android_Intro.class);
        startActivity(Intent_MovePage_Intro_to_Mobile);
    }

}

