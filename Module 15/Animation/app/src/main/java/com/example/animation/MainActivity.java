package com.example.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


// Source Video:   https://www.youtube.com/watch?v=scZYIAZrMWk
// Love this guys tutorial you should add him as a resource in the next classes all his videos are short, sweet and extremely helpful.
public class MainActivity extends AppCompatActivity {

  // Making a drawable variables.
  AnimationDrawable wifiAnimation;
  AnimationDrawable Notification;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Reference to the layout.
    ImageView imageView = findViewById(R.id.Wifi_Picture);
    ImageView imageView2 = findViewById(R.id.Notification_Animation);

    // setting the background
    imageView.setBackgroundResource(R.drawable.animation);
    imageView2.setBackgroundResource(R.drawable.animation_2);

    // Setting the AnimationDrawable and casting it to the background of the images.
    wifiAnimation = (AnimationDrawable) imageView.getBackground();
    Notification = (AnimationDrawable) imageView2.getBackground();

  }

  @Override
  public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);

    // making the methods start when app starts.
    wifiAnimation.start();
    Notification.start();

  }
}
