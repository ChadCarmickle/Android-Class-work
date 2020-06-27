package com.example.avideoapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

  private VideoView vidScreen; //the widget for videos
  private String MyVideo;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    vidScreen = findViewById(R.id.vidScreen);

    MediaController mc = new MediaController(this);
    mc.setAnchorView(vidScreen);
    mc.setMediaPlayer(vidScreen);

    String Path ="https://bobbi.ivytech.edu/~ccarmickle1/JavaScript%20Homework/Module%207/video/owls.mp4";

    Uri uri = Uri.parse(Path);
    vidScreen.setVideoURI(uri);
    vidScreen.start();

  }
}
