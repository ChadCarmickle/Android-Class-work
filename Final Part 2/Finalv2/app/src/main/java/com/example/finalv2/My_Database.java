package com.example.finalv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class My_Database extends SQLiteOpenHelper{

    private final static int DB_VERSION = 1;
    private final static String EXAMPLE_DATABASE = "DBExample.db";

    //the labels for the header row in our table
    private String table = "MyTable";
    private String column1 = "Artist";
    private String column2 = "Song";
    private String column3 = "URL ";

    public My_Database(Context context) {
      super(context, EXAMPLE_DATABASE, null, DB_VERSION);
    }//end constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
      String createQuery = "CREATE TABLE IF NOT EXISTS " + table + "(" +
          column1 + " TEXT, " +
          column2 + " TEXT, " +
          column3 + " TEXT);";
      db.execSQL(createQuery);
    }//end onCreate()

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS " + table);
      onCreate(db);
    }//end onUpgrade()


    public boolean addRecord(Feed_Item dbItem){
      ContentValues record = new ContentValues();
      record.put(column1, dbItem.getURL());
      record.put(column2, dbItem.getArtistName());
      record.put(column3, dbItem.getSongName());
      SQLiteDatabase db = this.getWritableDatabase();
      Long result = db.insert(table, null, record);
      if(result == -1){
        return false;
      }
      else{
        return true;
      }
    }//end addRecord()


    public Feed_Item[] getAllRecords(){
      ArrayList<Feed_Item> list = new ArrayList<>();
      SQLiteDatabase db = this.getWritableDatabase();
      String query = "SELECT * FROM " + table + " WHERE 1";
      Cursor c = db.rawQuery(query, null);
      while(c.moveToNext()){

        String temp_url = c.getString(0);
        String temp_artist = c.getString(1);
        String temp_song = c.getString(2);

        Feed_Item temp = new Feed_Item(temp_url, temp_artist, temp_song);
        list.add(temp);
      }
      c.close();
      db.close();

      Feed_Item[] dbItems = new Feed_Item[list.size()];
      return list.toArray(dbItems);
    }

    public void deleteRecords(){
      SQLiteDatabase db = this.getWritableDatabase();
      String deleteQuery = "DELETE FROM " + table + " WHERE 1";
      db.execSQL(deleteQuery);
      db.close();
    }
  }
