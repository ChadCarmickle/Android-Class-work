package com.example.semesterprojectm_10_assignment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Feed_item_Adapter extends BaseAdapter {


  // Variables.
  ImageView Char_Picture_Adapter;
  Bitmap My_Bitmap;
  String URL_Link = "";

  // Inflator which will populate the layout.
  private LayoutInflater layoutInflater;

  // The array to hold the items using the constructer.
  private Feed_Item[] FeedItemArray;


  public Feed_item_Adapter(Context context, Feed_Item[] feedItem_Constructer) throws IOException {

    this.FeedItemArray = feedItem_Constructer; // Making the FeedItemArray, a reference to the FeedItem Constructer.

    // Taking the layout inflater. the class getting the context then inflating to a built in service.
    this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  // Number of items going to the listview.
  @Override
  public int getCount() {
    return FeedItemArray.length;
  }

  // Returns the item from the array
  @Override
  public Object getItem(int position) {
    return FeedItemArray[position];
  }


  // Obtain internal thing,
  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View contextView, ViewGroup parent) {

    View FeedListView = layoutInflater.inflate(R.layout.feed_item_layout, null);


    TextView Character_Name_Adapter = FeedListView.findViewById(R.id.Character_Name);
    TextView Character_Date__Adapter = FeedListView.findViewById(R.id.Date_lbl);
    TextView Character_Post_Adapter = FeedListView.findViewById(R.id.Character_post);


    Character_Name_Adapter.setText(FeedItemArray[position].getFirstNameFeed());
    Character_Date__Adapter.setText(FeedItemArray[position].getDateFeed());
    Character_Post_Adapter.setText(FeedItemArray[position].getChar_Post_Feed());

    // Setting the URL link
    URL_Link = FeedItemArray[position].getChar_PictureFeed();

    // Setting the object to the widget.
    Char_Picture_Adapter = FeedListView.findViewById(R.id.Character_picture);

    // Running the Class getImage passing in the object and executing it with the URL obtained from the Feed.
    new GetImage(Char_Picture_Adapter).execute((URL_Link));


    return FeedListView;

  }

    public class GetImage extends AsyncTask<String, Void, Bitmap> {

      // Holds the image
      ImageView ImageView;

      public GetImage(ImageView ImgV) { this.ImageView = ImgV; }

      @Override
      protected Bitmap doInBackground(String... A_URL) {
        String URL_Display = A_URL[0]; // Variable to display the feed.
        Char_Picture_Adapter = null; // Setting the feed to null so it can replace its current default image.
        try {
          InputStream srt = new java.net.URL(URL_Display).openStream(); // Opening the stream
          My_Bitmap = BitmapFactory.decodeStream(srt); // Decoding the stream
        } catch(Exception e){ // Catching a file not found or other error.
          e.printStackTrace();
        }
        return My_Bitmap; // setting the Bitmap to return
      }

      @Override
      protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        ImageView.setImageBitmap(bitmap); // Setting the bitmap to the imageView.
      }
    }
  }
