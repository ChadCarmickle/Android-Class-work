package com.example.semesterprojectm_10_assignment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {
  private static int SPLASH_TIME_OUT = 2000; // Adding integer to loading screen time. 4000mill = 4 seconds



  // Reference to the main activity.
  private MainActivity localActivitvy;

  private BottomNavigationView BotNav;


  // the URL
  private String RSSFeed = new String("https://bobbi.ivytech.edu/~ccarmickle1/RSS_Feed/season_1_feed.xml");

  // Array that will store the tags
  private Feed_Item[] CurrentItem ;

  // Holds the listview
  private ListView lstFeedDisplay;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    /*******************************************
    *                                          *
    *              Loading Screen              *
    *******************************************/

    // Source: https://www.youtube.com/watch?v=jXtof6OUtcE
      new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
          Intent homeIntent = new Intent(MainActivity.this, LoadingActivity.class);
          startActivity(homeIntent);
          finish();
        }
      }, SPLASH_TIME_OUT);



    localActivitvy = this;

    BotNav = findViewById(R.id.MenuBar);
    BotNav.setOnNavigationItemSelectedListener(navListener);

    GetRSSFeed myFeed = new GetRSSFeed(); //instance of inner class we created below
    myFeed.execute(RSSFeed);//run our asynchronous thread


  }
  private BottomNavigationView.OnNavigationItemSelectedListener navListener =
      new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

          switch (menuItem.getItemId()) {
            case R.id.nav_Friends:
              // Code to move to Profile page.
              break;
            case R.id.nav_Play:
              startService(new Intent(MainActivity.this, MyService.class));
              break;
            case R.id.nav_Pause:
              stopService(new Intent(MainActivity.this, MyService.class));
              break;
          }
          return false;
        }
      };

  public class GetRSSFeed extends AsyncTask<String, Void, Feed_Item[]> {
    @Override
    protected Feed_Item[] doInBackground(String... strings) {
      try{
        //url of our feed
        URL feedURL = new URL(RSSFeed);

        // Parser
        XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        Feed_Handler feedHandler = new Feed_Handler();//the handler we made
        xmlReader.setContentHandler(feedHandler);//attach our handler to the reader
        xmlReader.parse(new InputSource(feedURL.openStream()));//parse an input stream
        return feedHandler.getItems();//return the array the handler returns
      }

      // Catching any Errors
      catch(Exception e){
        //if an exception is caught we make a FeedItem put it in array and show stack trace on our app screen
        String NameError = "error Name ";
        String DateError = "Error Date ";
        String InfoError = "Error Info ";
        String PicError = "Error Pic";
        Feed_Item caught = new Feed_Item(NameError, DateError, InfoError, PicError  );
        CurrentItem = new Feed_Item[1];
        CurrentItem[0] = caught;
        return CurrentItem;
      }

    }

    @Override

    protected void onPostExecute(Feed_Item[] feedItems) {
      super.onPostExecute(feedItems);
      CurrentItem = feedItems;

      Feed_item_Adapter adapt = null;
      try {
        adapt = new Feed_item_Adapter(localActivitvy, CurrentItem);
      } catch (IOException e) {
        e.printStackTrace();
      }
      lstFeedDisplay = findViewById(R.id.My_ListView);
      lstFeedDisplay.setAdapter(adapt);
    }
  }

}
