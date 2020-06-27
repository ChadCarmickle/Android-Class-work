package com.example.rsspratice;

import android.widget.ListView;
import android.widget.TextView;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;



public class Feed_Handler extends DefaultHandler {
  private boolean IsItem = false;
  private boolean StudentNameBool = false;
  private boolean StudentLastBool = false;
  private boolean StudentInfoBool = false;
  private boolean StudentGradeBool = false;
  private boolean StudentPicBool = false;

  // Making the list
  Feed_Item currentItem = new Feed_Item();
  ArrayList<Feed_Item> items = new ArrayList<>();


  // The method that will start reading the docucument.
  @Override
  public void startDocument() throws SAXException {
    super.startDocument();

    // This will be the first profile with hardcoded text.
    Feed_Item testCase = new Feed_Item("First Name", "LastName", "Student Infomation", "Grade", "https://pbs.twimg.com/media/DrCFy2zUcAAUXP6.jpg" );
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
      IsItem = true;
    } else if (localName.equals("title")) {
      StudentNameBool = true;
          if (localName.equals("plank"));
      {
      }
    } else if (localName.equals("titleLast")) {
      StudentLastBool = true;
    } else if (localName.equals("description")) {
      StudentInfoBool = true;
    } else if (localName.equals("grade")) {
      StudentGradeBool = true;
    } else if (localName.equals("URL")) {
      StudentPicBool = true;
    }
  }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      super.characters(ch, start, length);

      if (IsItem) {
        {
          if (StudentNameBool) {
            currentItem.setFirstNameFeed(new String(ch, start, length));
          } else if (StudentLastBool) {
            currentItem.setLastNameFeed(new String(ch, start, length));
          } else if (StudentInfoBool) {
            currentItem.setStudentInfoFeed(new String(ch, start, length));
          } else if (StudentGradeBool) {
            currentItem.setStudentGradeFeed(new String(ch, start, length));
          } else if (StudentPicBool)
            currentItem.setStudentPicture(new String(ch, start, length));
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
      IsItem = false;
    } else if (localName.equals("title")) {
      StudentNameBool = false;
    } else if (localName.equals("titleLast")) {
      StudentLastBool = false;
    } else if (localName.equals("description")) {
      StudentInfoBool = false;
    } else if (localName.equals("grade")) {
      StudentGradeBool = false;
    } else if (localName.equals("URL")) {
      StudentPicBool = false;
    }


  }
  //this runs at end of document, we didn't use it here, but I did want to mention it
  @Override
  public void endDocument() throws SAXException {

    Feed_Item testCase = new Feed_Item("Document", " End ", "", "", "https://i.ytimg.com/vi/QNU-sMrEen0/hqdefault.jpg" );
    items.add(testCase);
    super.endDocument();
  }

} // end of class
