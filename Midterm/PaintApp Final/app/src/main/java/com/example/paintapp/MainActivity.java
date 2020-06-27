package com.example.paintapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


  /*****************************************************************
   *                                                               *
   *                         Variables                             *
   *                                                               *
   ****************************************************************/


  private Spinner PaintSpinner;

  private ImageView Red_Picture;
  private ImageView Blue_Picture;
  private ImageView Green_Picture;
  private ImageView White_Picture;
  private ImageView Black_Picture;


  private Button Apply;

  private TextView Lbl_Slogan;

  private EditText HightInput;
  private EditText DistanceAmt;
  private EditText CoatAmt;


  double Area = 0;
  double Gallons = 0;
  short SloganNum = 0;




  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Hides the status bar.
    getSupportActionBar().hide();


    /*****************************************************************
     *                                                               *
     *                      Linking All Object                       *
     *                                                               *
     ****************************************************************/

    PaintSpinner = findViewById(R.id.Paint_Selection_Spinner);

    Apply = findViewById(R.id.ApplyBtn);

    Lbl_Slogan = findViewById(R.id.LogoSlogan);

    HightInput = findViewById(R.id.Input_Height);
    DistanceAmt = findViewById(R.id.Input_Distance);
    CoatAmt = findViewById(R.id.Input_PaintCoat);

    Red_Picture = findViewById(R.id.Red_background);
    Blue_Picture = findViewById(R.id.Blue_background);
    Green_Picture = findViewById(R.id.Green_Background);
    White_Picture = findViewById(R.id.White_background);
    Black_Picture = findViewById(R.id.Black_background);

    Red_Picture.setVisibility(View.GONE);
    Blue_Picture.setVisibility(View.GONE);
    Green_Picture.setVisibility(View.GONE);
    White_Picture.setVisibility(View.GONE);
    Black_Picture.setVisibility(View.GONE);


    ViewSecondActivity_And_Calculate();

    /****************************************************************
    *                                                               *
    *                           Spinner                             *
    *                                                               *
    ****************************************************************/

    // creates array adapter for specified array and layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Paint_Spinner_Entities, android.R.layout.simple_spinner_item);

    // set the layout for the drop-box list
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    // Set the spinner attached to the adapter
    PaintSpinner.setAdapter(adapter);

    PaintSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {

          case 1:
            Red_Picture.setVisibility(View.VISIBLE);
            Blue_Picture.setVisibility(View.GONE);
            Green_Picture.setVisibility(View.GONE);
            White_Picture.setVisibility(View.GONE);
            Black_Picture.setVisibility(View.GONE);
            break;

          case 2:
            Red_Picture.setVisibility(View.GONE);
            Blue_Picture.setVisibility(View.VISIBLE);
            Green_Picture.setVisibility(View.GONE);
            White_Picture.setVisibility(View.GONE);
            Black_Picture.setVisibility(View.GONE);
            break;

          case 3:
            Red_Picture.setVisibility(View.GONE);
            Blue_Picture.setVisibility(View.GONE);
            Green_Picture.setVisibility(View.VISIBLE);
            White_Picture.setVisibility(View.GONE);
            Black_Picture.setVisibility(View.GONE);
            break;

          case 4:
            Red_Picture.setVisibility(View.GONE);
            Blue_Picture.setVisibility(View.GONE);
            Green_Picture.setVisibility(View.GONE);
            White_Picture.setVisibility(View.VISIBLE);
            Black_Picture.setVisibility(View.GONE);
            break;

          case 5:
            Red_Picture.setVisibility(View.GONE);
            Blue_Picture.setVisibility(View.GONE);
            Green_Picture.setVisibility(View.GONE);
            White_Picture.setVisibility(View.GONE);
            Black_Picture.setVisibility(View.VISIBLE);
            break;
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {
        Red_Picture.setVisibility(View.GONE);
        Blue_Picture.setVisibility(View.GONE);
        Green_Picture.setVisibility(View.GONE);
        White_Picture.setVisibility(View.GONE);
        Black_Picture.setVisibility(View.GONE);
      }
    });

  } // End of OnCreate


   /****************************************************************
   *                                                               *
   *                     Spinner Entities                          *
   *                                                               *
   ****************************************************************/




  // Method that will jump to the second Activity and perform calculations.
  private void ViewSecondActivity_And_Calculate()
  {
    Apply.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // Gaining the input from user on the Height.
        String HeightInput_String = HightInput.getText().toString();

        // Gaining the input from user on the Distance.
        String DistanceInput_String = DistanceAmt.getText().toString();

        // Gaining the input from user on the Paint coat.
        String PaintCoat_Input_String = CoatAmt.getText().toString();

        // Checking for invalid input.
        if ( !(HeightInput_String.equals("") || (DistanceInput_String.equals("") || (PaintCoat_Input_String.equals("")))))
        {

          double Height_Input = Double.parseDouble(HeightInput_String);
          double Distance_Input = Double.parseDouble(DistanceInput_String);
          int Coat_Input = Integer.parseInt(PaintCoat_Input_String);

        Area = Height_Input * Distance_Input;

        Gallons = Area / 250;

        double Gallons_Rounded = Math.ceil(Gallons);

        // Converting the variables into strings
        // String StringGallonsRounded = Gallons_Rounded;
        String StringGallonRounded = String.valueOf((int) Gallons_Rounded);
        String StringCoatRounded = String.valueOf(Coat_Input);

        // Passing the values to the next Activity
        Intent intent = new Intent(getApplicationContext(), Second_Activity.class );
        intent.putExtra("Gallons", StringGallonRounded);
        intent.putExtra("Coat", StringCoatRounded);
        startActivity(intent);
        NewSlogon();

        // Reset the text.
          HightInput.setText(null);
          DistanceAmt.setText(null);
          CoatAmt.setText(null);
        }

        // Invalid option selection or used.
        else
        {
          Toast toast = Toast.makeText(getApplicationContext(), " Please Enter an amount. ", Toast.LENGTH_LONG);
          toast.show();
        }

      }
    });
  }

  /* Changing the Slogan on the Main_Activity. */
  public void NewSlogon()
  {
    if (SloganNum == 0)
    {
      Lbl_Slogan.setText(" You can do it. We can help ");
      SloganNum++;
    }
    else if (SloganNum == 1)
    {
      Lbl_Slogan.setText(" When your at Home Depot, you'll feel right at home ");
      SloganNum++;
    }
    else
    {
      Lbl_Slogan.setText(" More savings. More doing ");
      SloganNum = 0;
    }

  }
} // End of Main Activity
