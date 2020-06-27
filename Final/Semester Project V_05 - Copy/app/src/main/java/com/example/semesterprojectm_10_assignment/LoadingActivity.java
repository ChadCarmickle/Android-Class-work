package com.example.semesterprojectm_10_assignment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class LoadingActivity extends AppCompatActivity {

  private ImageView Logo;
  private ImageView Gif;
  private TextView Welcome;
  int min = 1;
  int max = 10;

  private static int SPLASH_TIME_OUT = 4500; // Adding integer to loading screen time. 4000mill = 4 seconds

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_loading);


    getSupportActionBar().hide();

    Logo = findViewById(R.id.Logo_Loading);
    Gif = findViewById(R.id.MainGif);
    Welcome = findViewById(R.id.Logo_Text_Loading);


    Random r = new Random();
    int FinalNum =  r.nextInt((max - min) + 1) + min;

   if(FinalNum == 1) {
     Gif.setImageResource(R.drawable.dancing_gif_1);
   }else if (FinalNum == 2) {
     Gif.setImageResource(R.drawable.dancing_gif_2);
   }else if (FinalNum == 3) {
     Gif.setImageResource(R.drawable.dancing_gif_3);
   }
   else if (FinalNum == 4) {
     Gif.setImageResource(R.drawable.dancing_gif_4);
   }
   else if (FinalNum == 5) {
     Gif.setImageResource(R.drawable.dancing_gif_5);
   }
   else if (FinalNum == 6) {
     Gif.setImageResource(R.drawable.dancing_gif_6);
   }
   else if (FinalNum == 7) {
     Gif.setImageResource(R.drawable.dancing_gif_7);
   }
   else if (FinalNum == 8) {
     Gif.setImageResource(R.drawable.dancing_gif_8);
   }
   else if (FinalNum == 9) {
     Gif.setImageResource(R.drawable.dancing_gif_9);
   }
   else if (FinalNum == 10) {
     Gif.setImageResource(R.drawable.dancing_gif_10);
   }else {
     Gif.setImageResource(R.drawable.bmo);

   }

      // Source: https://www.youtube.com/watch?v=jXtof6OUtcE
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent homeIntent = new Intent(LoadingActivity.this, MainActivity.class);
              startActivity(homeIntent);
              finish();
          }
      } , SPLASH_TIME_OUT);




  }
}
