package com.example.semesterprojectm_10_assignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class EntireMap extends AppCompatActivity {

  // Reference to my image.
  private ImageView image;

  // The URL of the map i'm using.
  private final static String IMAGE_URL = "https://bobbi.ivytech.edu/~ccarmickle1/RSS_Feed/resize-magic.jpg";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.map_layout);

    // Reference to the widget.
    image = findViewById(R.id.img_large);

    //call asynctask to get image from url
    new MapClass(image).execute(IMAGE_URL);
  }

}
