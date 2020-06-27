package com.example.semesterprojectm_10_assignment;

import android.graphics.Color;
import android.view.View;
import android.widget.BaseAdapter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class Feed_Handler extends DefaultHandler {

  private boolean isItem_Bool = false;
  private boolean FirstName_Bool = false;
  private boolean Date_Bool = false;
  private boolean Char_post_bool = false;
  private boolean Char_Picture_bool = false;
  private View MyView;


  // making the list.
  Feed_Item currentItem = new Feed_Item();
  ArrayList<Feed_Item> items = new ArrayList<>();


  // The method that will start reading the docucument.
  @Override
  public void startDocument() throws SAXException {
    super.startDocument();

    // This will be the first profile with hardcoded text.
    Feed_Item testCase = new Feed_Item(" Welcome to the ", "   ", " Land of Ooo Social Media App ",  "https://bobbi.ivytech.edu/~ccarmickle1/RSS_Feed/ProfilePic/Home.png" );
    items.add(testCase);
  }

  //made this item to return the array of FeedItems we need
  public Feed_Item[] getItems(){
    Feed_Item[] temp = new Feed_Item[items.size()];
    items.toArray(temp);
    return temp;
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    super.startElement(uri, localName, qName, attributes);


    if (localName.equals("item")) {
      isItem_Bool = true;
    } else if (localName.equals("title")) {
      FirstName_Bool = true;
    } else if (localName.equals("Char_date")) {
      Date_Bool = true;
    } else if (localName.equals("description")) {
      Char_post_bool = true;
    } else if (localName.equals("url")) {
      Char_Picture_bool = true;
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    super.characters(ch, start, length);

    if (isItem_Bool) {
      {
        if (FirstName_Bool) {
          currentItem.setFirstNameFeed(new String(ch, start, length));
        } else if (Date_Bool) {
          currentItem.setDateFeed(new String(ch, start, length));
        } else if (Char_post_bool) {
          currentItem.setChar_Post_Feed(new String(ch, start, length));
        } else if (Char_Picture_bool) {
          currentItem.setChar_PictureFeed(new String(ch, start, length));
        }
      }
    }
  }

  //this runs when it hits a closing tag
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {

    //if item closes we're done with this one, add it to dynamic arraylist and reset
    if(localName.equals("item")){
      items.add(currentItem);
      currentItem = new Feed_Item();//I had this set to null in class, that's what caused the error
      isItem_Bool = false;
    } else if (localName.equals("title")) {

      FirstName_Bool = false;
    } else if (localName.equals("Char_date")) {
      Date_Bool = false;
    } else if (localName.equals("description")) {
      Char_post_bool = false;
    } else if (localName.equals("url")) {
      Char_Picture_bool = false;
    }
  }
  //this runs at end of document, we didn't use it here, but I did want to mention it
  @Override
  public void endDocument() throws SAXException {

    Feed_Item testCase = new Feed_Item("End", "of ", "document", "" );
    items.add(testCase);


    super.endDocument();
  }

} // End of Feed)Handler.
