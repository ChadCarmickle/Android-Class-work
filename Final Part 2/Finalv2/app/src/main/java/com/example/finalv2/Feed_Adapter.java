package com.example.finalv2;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.lang.reflect.Array;

public class Feed_Adapter<SongArray> extends BaseAdapter {
  private static final String TAG = "MyActivity";
  private boolean ChangeColor = false;
  private LayoutInflater layoutInflater;

  private static Feed_Item[] FeedItemArray;
  static String MyArray[] = new String[45];  // I wasnt sure how much to hold and choose this number.
  static String MySongArray[] = new String[45];  // I wasnt sure how much to hold and choose this number.

  public Feed_Adapter(Context context, Feed_Item[] feedItem_Constructor) throws IOException {
    this.FeedItemArray = feedItem_Constructor;
    this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return FeedItemArray.length;
  }

  @Override
  public Object getItem(int position) {
    return FeedItemArray[position];  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View FeedListView = layoutInflater.inflate(R.layout.activity_feed_item_layout, null);


    TextView ArtistName = FeedListView.findViewById(R.id.Artist_txt);
    TextView SongName = FeedListView.findViewById(R.id.SongName_Txt);


    MyArray[position] = FeedItemArray[position].getURL();
    MySongArray[position] = FeedItemArray[position].getSongName();
    ArtistName.setText(FeedItemArray[position].getArtistName());
    SongName.setText(FeedItemArray[position].getSongName());


    View Someview = FeedListView.findViewById(R.id.FeedItemLayout);

    if(ChangeColor) {
      Someview.setBackgroundColor(Color.parseColor("#F5CBF3"));
      ChangeColor = false;
    } else {
      Someview.setBackgroundColor(Color.parseColor("#A5F2F3"));
      ChangeColor = true;
    }
    return FeedListView;

  }


}
