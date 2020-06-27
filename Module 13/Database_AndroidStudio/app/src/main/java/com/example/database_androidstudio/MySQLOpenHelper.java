package com.example.database_androidstudio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLOpenHelper extends SQLiteOpenHelper {

  // variables for the database.
  private static String database_Name = "Programming_Comnpany.db";
  private String table_name = "Employee";
  private static final int dataBase_Version = 1;

  private String column_id = "id", column_name = "name";

  // creates a statement.
  private String database_create_statement =
      "create table "+ table_name+" ( "+column_id + " integer primary key autoincrement, "+ column_name+ " text not null );";

  public MySQLOpenHelper(Context context) {
    super(context, database_Name, null, dataBase_Version);
  }


  // This will give us access to the databases.
  @Override
  public void onCreate(SQLiteDatabase db) {


    // this will be called to create the sql database.
    db.execSQL(database_create_statement);
  }

  // requires two int, the older version and newer.
  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    // Changes in the database ~
  }
}

