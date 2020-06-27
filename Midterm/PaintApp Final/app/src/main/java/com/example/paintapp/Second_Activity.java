package com.example.paintapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Second_Activity extends Activity {

  private Button Back;
  private TextView Display_Gallons2;
  private TextView Display_Coat2;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second_);

    Back = findViewById(R.id.btn_Back);
    Display_Gallons2 = findViewById(R.id.Display_Gallons);
    Display_Coat2 = findViewById(R.id.Display_Coat);


    // Getting the intent from the other activity
    String Gallons = getIntent().getStringExtra("Gallons");
    String Coat = getIntent().getStringExtra("Coat");

    // Displaying the Activities.
    Display_Gallons2.setText("You will need " +  Gallons + " Gallons of paint");
    Display_Coat2.setText("For " + Coat + " Coat(s) of paint");

    ViewSecondActivity_And_Calculate();

  }

  // Method to jump between activates
  private void ViewSecondActivity_And_Calculate() {

    // Sends the user back to the first Activity.
    Back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });


  }
}
