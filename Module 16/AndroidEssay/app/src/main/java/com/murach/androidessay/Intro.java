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

public class Intro extends AppCompatActivity {

  // Adding the main widgets.
    private Button Next_btn_intro;
    private TextView Lbl_Intro;
    private ScrollView ScrollBar_Intro;

  // Adding the Paragraph textviews.
  private TextView Txt_IntroParagraph;
  private TextView Txt_IntroParagraph2;
  private TextView Txt_IntroParagraph3;

  // Adding the Photo Texts
  private TextView PhotoText1;
  private TextView PhotoText2;
  private TextView PhotoText3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        // Making a reference to all the widgets.
      Next_btn_intro = findViewById(R.id.Next_Btn_Intro);
      Lbl_Intro = findViewById(R.id.Lbl_Intro);
      Txt_IntroParagraph = findViewById(R.id.Txt_IntroParagraph1);
      Txt_IntroParagraph2 = findViewById(R.id.Txt_IntroParagraph2);
      Txt_IntroParagraph3 = findViewById(R.id.TeslaParagraph3);
      ScrollBar_Intro = findViewById(R.id.ScrollBar_Intro);
      PhotoText1 = findViewById(R.id.PhotoText1);
      PhotoText2 = findViewById(R.id.PhotoText2);
      PhotoText3 = findViewById(R.id.PhotoText3);



      // Setting the text to my Paragraphs
      Lbl_Intro.setText("Introduction.");
      Txt_IntroParagraph.setText("The year was 1920s, when America had just passed the Prohibition of alcohol, banning all alcoholic drinks in America. Individuals who manufactured the illegal substance could face a fine up to one thousand dollars for a first offense and up to six months in jail in 1920 (Beckman, 2014). To give an insight on how much the money was worth in that time period, calculating the inflation from 1920 to 2019, the result is twelve thousand, six hundred and eighty cents in today's current economy. The time also caused various of organized gangs to evolve their strategies of making money to smuggling and brewing the illegal substance for large sums of cash. This led various gangs to form and leaders, the most famous one known as Al Capone, an American gangster nicknamed “Scarface”, who during his career is credited credited to making approximately sixty million dollars in just two years (Trueman, 2015). ");
      Txt_IntroParagraph2.setText("With crime’s happening in the dark, a legend rises from his bench and takes to the spotlight, Famous baseball player Babe Ruth. Babe Ruth rose to the call of baseball and took the nation by storm. In his first year Ruth managed to make fifty-four home runs for the New York Yankees and then went on to break that record the following year (Biography.com Editors, 2014). With Al Capone taking the streets with his gangs and Babe Ruth hitting new records for baseball history a pioneer of science was making notes and performing research. Credited for his genius design of the AC current supply, no other than Nikola Tesla. \n");
      Txt_IntroParagraph3.setText("Having the ability to speak eight different languages and holding over three hundred different patents in his lifetime Tesla made an enlightening quote that truly displayed how far ahead he was to others. “When Wireless is perfectly applied the whole earth will be converted into a huge brain…We shall be able to communicate with one another instantly…” (1926, Nikola Tesla described the modern smartphone — in 1926, 2015). Nikola Tesla merely talking about the invention of mobile computing wouldn’t become a reality until the early 1990s nearly seventy years later, but how did a small device no bigger than our hand become such a need that over 92% of all American adults own (ANDERSON, 2015) a mobile phone? In this app I shall answer these questions and more.  ");
      PhotoText1.setText("Al Capone 1930.");
      PhotoText2.setText("Babe Ruth.");
      PhotoText3.setText("Nikola Tesla. ");

      // Allowing the user to scroll inside the textview.
      Txt_IntroParagraph.setMovementMethod(new ScrollingMovementMethod());
      Txt_IntroParagraph2.setMovementMethod(new ScrollingMovementMethod());
      Txt_IntroParagraph3.setMovementMethod(new ScrollingMovementMethod());

      // Btn that will send user to next Activity.
      Next_btn_intro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

          // Moves to the Mobile Page
          MovePage_Intro_to_Mobile();
        }
      });


                              /*********************************
                              *                                *
                              *       Textview Scrolls inside  *
                              *              ScrowView         *
                              *********************************/

      ScrollBar_Intro.setOnTouchListener(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

          Txt_IntroParagraph.getParent().requestDisallowInterceptTouchEvent(false);
          Txt_IntroParagraph2.getParent().requestDisallowInterceptTouchEvent(false);
          Txt_IntroParagraph3.getParent().requestDisallowInterceptTouchEvent(false);

          return false;
        }
      });

      Txt_IntroParagraph.setOnTouchListener(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

          Txt_IntroParagraph.getParent().requestDisallowInterceptTouchEvent(true);
          return false;
        }
      });

      Txt_IntroParagraph2.setOnTouchListener(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

          Txt_IntroParagraph2.getParent().requestDisallowInterceptTouchEvent(true);
          return false;
        }
      });

      Txt_IntroParagraph3.setOnTouchListener(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

          Txt_IntroParagraph3.getParent().requestDisallowInterceptTouchEvent(true);
          return false;
        }
      });
    }


    // Moves user to Moble Page.
    public void MovePage_Intro_to_Mobile() {

        Intent Intent_MovePage_Intro_to_Mobile = new Intent(Intro.this, Mobile_Computing.class);
        startActivity(Intent_MovePage_Intro_to_Mobile);
    }


}
