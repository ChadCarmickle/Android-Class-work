package com.example.database_androidstudio;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private Button btnCreateDatabase;

  private MySQLOpenHelper mySqliteOpenHelper;

  private SQLiteDatabase mDatabase;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    btnCreateDatabase = findViewById(R.id.btn_CreateDatabase);

    btnCreateDatabase.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        // create the database with table here --

        mySqliteOpenHelper = new MySQLOpenHelper(getApplicationContext());

        // Exabling my database
        mDatabase = mySqliteOpenHelper.getReadableDatabase();

        // Cursor is a subset of a table.
        Cursor cursor = mDatabase.rawQuery("select * from employee ;", null);

        // Printing out the data.
        System.out.println("MainActivity.onClick:" + cursor.getColumnCount());


      }
    });

  }
}
