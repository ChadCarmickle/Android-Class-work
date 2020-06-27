package com.example.finalv2;


import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class Item_Handler extends DefaultHandler {
  private static final String TAG = "MyActivity";

  private boolean isItem_Bool = false;
  private boolean ArtistName_Bool = false;
  private boolean SongName_Bool = false;
  private boolean Url_bool = false;

  My_Database MyDatabase;
  // making the list.
  Feed_Item currentItem = new Feed_Item();
  ArrayList<Feed_Item> items = new ArrayList<>();


  public Feed_Item[] getItems() {
    Feed_Item[] temp = new Feed_Item[items.size()];
    items.toArray(temp);
    return temp;
  }
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    super.startElement(uri, localName, qName, attributes);
    if (localName.equals("music")) {
      isItem_Bool = true;
    } else if (localName.equals("artist")) {
      ArtistName_Bool = true;
    } else if (localName.equals("song")) {
      SongName_Bool = true;
    } else if (localName.equals("url")) {
      Url_bool = true;
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    super.characters(ch, start, length);

    if (isItem_Bool) {
      if (ArtistName_Bool) {
        currentItem.setArtistName(new String(ch, start, length));
      } else if (SongName_Bool) {
        currentItem.setSongName(new String(ch, start, length));
       // Feed_Item feed_item = new Feed_Item(null, currentItem.getSongName());
       // MyDatabase.AddSongs(null, feed_item);
      } else if (Url_bool) {
        currentItem.setURL(new String(ch, start, length));
      }
    }
  }


  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    super.endElement(uri, localName, qName);
    if (localName.equals("music")) {
      items.add(currentItem);
      currentItem = new Feed_Item();
      isItem_Bool = false;
    } else if (localName.equals("artist")) {
      ArtistName_Bool = false;
    } else if (localName.equals("song")) {
      SongName_Bool = false;
    } else if (localName.equals("url")) {
      Url_bool = false;
    }
  }
}
