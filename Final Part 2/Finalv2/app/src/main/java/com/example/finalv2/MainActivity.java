package com.example.finalv2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.net.URL;
import java.sql.Ref;

import javax.xml.parsers.SAXParserFactory;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

  private MediaPlayer MyPlayer;

  private static final String TAG = "MyActivity";
  private String urlAddress = new String(" ");

  private String SongName = "";
  private boolean SongPlaying = false;
  private MainActivity localActivity;
 // private My_Database[] records;//the array to send to our adapter

  private Button StopMusic;
  private Button Refresh;

  // the URL
  private String RSSFeed = new String("https://bobbi.ivytech.edu/~cfrancis4/sdev264_final/music_links.xml");

  // Array that will store the tags
  private Feed_Item[] CurrentItem;

  ListView lstFeedDisplay;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    lstFeedDisplay = findViewById(R.id.My_ListView);
    StopMusic = findViewById(R.id.StopMusic);
    Refresh = findViewById(R.id.Refresh); 

    localActivity = this;

    GetRSSFeed myFeed = new GetRSSFeed(); //instance of inner class we created below
    myFeed.execute(RSSFeed);//run our asynchronous thread


    lstFeedDisplay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

       if (!SongPlaying) {
         SongPlaying = true;
         String Song = Feed_Adapter.MySongArray[position];
         SongName = Song;
         Toast.makeText(MainActivity.this, "Now Playing: \n" + Song, Toast.LENGTH_SHORT).show();

         String ADDRESS = Feed_Adapter.MyArray[position];
         PlayMusic(ADDRESS);
       }
       else {
         Toast.makeText(MainActivity.this, "Song is already playing", Toast.LENGTH_SHORT).show();
       }

      }

    });
    StopMusic.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
       if (SongPlaying) {
         MyPlayer.stop();
         SongPlaying = false;
         Toast.makeText(MainActivity.this, "Now Stopping: \n " + SongName, Toast.LENGTH_SHORT).show();
       } else {
         Toast.makeText(MainActivity.this, "No Song currently playing \n ", Toast.LENGTH_SHORT).show();

       }


      }
    });

    Refresh.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Refreshing Feed ", Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        finish();
        startActivity(intent);
      }
    });
  }

  public void PlayMusic(String url) {
  MyPlayer = new MediaPlayer();
  urlAddress = url;
  try{
    addNotification();
    MyPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    MyPlayer.setDataSource(urlAddress);
    MyPlayer.prepare();
    MyPlayer.start();

  }
  catch(Exception e){
    //just inform about an error.
    Toast.makeText(MainActivity.this, "didn't work", Toast.LENGTH_SHORT).show();
  }
}



  public class GetRSSFeed extends AsyncTask<String, Void, Feed_Item[]> {
    @Override
    protected Feed_Item[] doInBackground(String... strings) {
      try {
        //url of our feed
        URL feedURL = new URL(RSSFeed);

        // Parser
        XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        Item_Handler feedHandler = new Item_Handler();//the handler we made
        xmlReader.setContentHandler(feedHandler);//attach our handler to the reader
        xmlReader.parse(new InputSource(feedURL.openStream()));//parse an input stream
        return feedHandler.getItems();//return the array the handler returns
      }

      // Catching any Errors
      catch (Exception e) {
        //if an exception is caught we make a FeedItem put it in array and show stack trace on our app screen
        String ArtistError = "error Name ";
        String SongError = "Error Date ";
        String UrlError = "Error";
        Log.i(TAG, "**************************************************");
        Log.i(TAG, "***********************************************");
        Log.i(TAG, "**************************************************");

        Feed_Item caught = new Feed_Item(ArtistError, SongError, UrlError);
        CurrentItem = new Feed_Item[1];
        CurrentItem[0] = caught;
        return CurrentItem;
      }
    }


    @Override
    protected void onPostExecute(Feed_Item[] feed_items) {
      super.onPostExecute(feed_items);

      CurrentItem = feed_items;
      Feed_Adapter adapt = null;
      try {
        adapt = new Feed_Adapter(localActivity, CurrentItem);
      } catch (IOException e) {
        e.printStackTrace();
      }
      // Holds the listview
      ListView lstFeedDisplay = findViewById(R.id.My_ListView);
      lstFeedDisplay.setAdapter(adapt);

    }
  }
  public void addNotification() {

    NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
    builder.setSmallIcon(R.drawable.secondaryicon);
    builder.setContentTitle("Final Android app");
    builder.setContentText("Now playing" + SongName);

    Intent notificationIntent = new Intent(this, MainActivity.class);
    PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    builder.setContentIntent(contentIntent);

    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    manager.notify(0,builder.build());
  }
  }

