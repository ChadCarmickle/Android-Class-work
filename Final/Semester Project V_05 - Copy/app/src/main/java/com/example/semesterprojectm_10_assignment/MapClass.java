package com.example.semesterprojectm_10_assignment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

public class MapClass  extends AsyncTask<String, Void, Bitmap>{

    // Reference to the image.

    private ImageView bmImage;

    // Loads the map.
    public MapClass(ImageView bmImage) {
      this.bmImage = bmImage;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
      String urldisplay = urls[0];
      Bitmap mIcon11 = null;
      try {
        InputStream in = new java.net.URL(urldisplay).openStream();
        mIcon11 = BitmapFactory.decodeStream(in);
      } catch (Exception e) {
        Log.e("Error", e.getMessage());
        e.printStackTrace();
      }
      return mIcon11;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
      bmImage.setImageBitmap(result);
    }
  }

