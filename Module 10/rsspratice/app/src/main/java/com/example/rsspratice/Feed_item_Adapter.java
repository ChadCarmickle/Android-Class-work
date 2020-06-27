package com.example.rsspratice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Feed_item_Adapter extends BaseAdapter {

  Feed_Item ItemList = new Feed_Item();
  ImageView StudentPicture_Adapter;
  Bitmap My_bitmap;
  String UrlLink = "";

    // Make the inflator which will populate the layout.
    private LayoutInflater layoutInflater;

    // We now make an array to hold the items using the consturcter.
    private Feed_Item[] FeedItemArray;

    // We need constructers to handle the feeditems passed.
    public Feed_item_Adapter(Context context, Feed_Item[] feedItemConstructer) throws IOException {
      this.FeedItemArray = feedItemConstructer; // Making the FeedItemArray a reference to the FeedItemConstructer. (linking the two together)

      // Taking the layout inflater, the class, getting the context then inflating to a built in service.
      this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // Number of items going to the listview.
   @Override
    public int getCount() {
      return FeedItemArray.length;
   }
   // Returns the item from the array
   @Override
    public Object getItem(int position){
      return FeedItemArray[position];
   }


   // Obtain internal thing,
  @Override
  public long getItemId(int position) {return position;}

  @Override
  public View getView(int position, View contextView, ViewGroup parent) {

    View FeedListView = layoutInflater.inflate(R.layout.feed_item_layout, null);


    TextView StudentName_Adapter = FeedListView.findViewById(R.id.Lbl_FirstName);
    TextView StudentLastName_Adapter = FeedListView.findViewById(R.id.Lbl_LastName);
    TextView StudentInfo_Adapter = FeedListView.findViewById(R.id.Lbl_Student_Info);
    TextView StudentGrade_Adapter = FeedListView.findViewById(R.id.Lbl_Student_Grade);


    StudentName_Adapter.setText(FeedItemArray[position].getFirstNameFeed());
    StudentLastName_Adapter.setText(FeedItemArray[position].getLastNameFeed());
    StudentInfo_Adapter.setText(FeedItemArray[position].getStudentInfoFeed());
    StudentGrade_Adapter.setText(FeedItemArray[position].getStudentGradeFeed());

    // Setting the URL link
    UrlLink = FeedItemArray[position].getStudentPicture();

    // Setting the object to the widget.
    StudentPicture_Adapter = FeedListView.findViewById(R.id.Student_Picture);

    // Running the Class getImage passing in the object and executing it with the URL obtained from the Feed.
    new GetImage(StudentPicture_Adapter).execute((UrlLink));

    return FeedListView;


  }


  public class GetImage extends AsyncTask<String, Void, Bitmap> {

    // Holds the image
    ImageView ImageView;

    public GetImage(ImageView ImgV) { this.ImageView = ImgV; }

    @Override
    protected Bitmap doInBackground(String... A_URL) {
      String URL_Display = A_URL[0]; // Variable to display the feed.
      StudentPicture_Adapter = null; // Setting the feed to null so it can replace its current default image.
      try {
        InputStream srt = new java.net.URL(URL_Display).openStream(); // Opening the stream
        My_bitmap = BitmapFactory.decodeStream(srt); // Decoding the stream
      } catch(Exception e){ // Catching a file not found or other error.
        e.printStackTrace();
      }
      return My_bitmap; // setting the Bitmap to return
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
      super.onPostExecute(bitmap);
      ImageView.setImageBitmap(bitmap); // Setting the bitmap to the imageView.
    }
  }
}
