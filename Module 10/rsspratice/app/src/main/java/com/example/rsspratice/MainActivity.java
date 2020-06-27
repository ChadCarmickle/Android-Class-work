package com.example.rsspratice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

  // A reference to our main activity.
  private MainActivity localActivity;

  // The url
  private String RSSFeed = new String("https://bobbi.ivytech.edu/~ccarmickle1/RSS_Feed/GradeFeed.xml");

  // Array that will store the tags
  private Feed_Item[] CurrentItem ;

  // Holds the listview
  private ListView lstFeedDisplay;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    localActivity = this;

    GetRSSFeed myFeed = new GetRSSFeed(); //instance of inner class we created below
    myFeed.execute(RSSFeed);//run our asynchronous thread

  }


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
        String LastError = "Error Last ";
        String InfoError = "Error Info ";
        String GradeError = "Error Grade ";
        String PicError = "Error Pic";
        Feed_Item caught = new Feed_Item(NameError, LastError, InfoError, GradeError, PicError  );
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
        adapt = new Feed_item_Adapter(localActivity, CurrentItem);
      } catch (IOException e) {
        e.printStackTrace();
      }
      lstFeedDisplay = findViewById(R.id.List);
      lstFeedDisplay.setAdapter(adapt);
    }
  }


}
