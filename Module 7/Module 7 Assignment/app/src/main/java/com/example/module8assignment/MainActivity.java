package com.example.module8assignment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

  // Variables
  EditText StartText;
  TextView EndText;


  // Source: https://www.youtube.com/watch?v=dSEcD4MJhX0
  private TextWatcher textWatcher = null;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    StartText = findViewById(R.id.Edit_box);
    EndText = findViewById(R.id.Second_Lbl);

    // Adding a textwatcher to listen for what the user does.
    textWatcher = new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        EndText.setText(StartText.getText().toString());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    };

    // Setting the Listener
    StartText.addTextChangedListener(textWatcher);
  }


  // Adding the menu bar to the activity.
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    return true;
  }

  // Adding listeners to the items in the menu
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId())
    {

        // Text Sizes.
      case R.id.TextSize_Small:
        EndText.setTextSize(25);
        return true;
      case R.id.TextSize_Medium:
        EndText.setTextSize(35);
        return true;
      case R.id.TextSize_Large:
        EndText.setTextSize(50);
        return true;

        // Text Colors.
      case R.id.TextColor_Red:
        EndText.setTextColor(Color.RED);
        return true;
      case R.id.TextColor_Blue:
        EndText.setTextColor(Color.BLUE);
        return true;
      case R.id.TextColor_Black:
        EndText.setTextColor(Color.BLACK);
        return true;


      case R.id.TextColor_Yellow:
        EndText.setTextColor(Color.YELLOW);
        return true;
      case R.id.TextColor_Green:
        EndText.setTextColor(Color.rgb(34,139,34));
        return true;
      case R.id.TextColor_Pink:
        EndText.setTextColor(Color.rgb(255,192,203));
        return true;
      case R.id.TextColor_Cayn:
        EndText.setTextColor(Color.CYAN);
        return true;
      case R.id.TextColor_Gray:
        EndText.setTextColor(Color.GRAY);
        return true;
      case R.id.TextColor_Magenta:
        EndText.setTextColor(Color.MAGENTA);
        return true;


    }
    return super.onOptionsItemSelected(item);
  }
}
