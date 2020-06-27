package com.example.stpatricksday;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

  private EditText SubTotal_Input;

  private SeekBar SeekBar;

  private TextView Scott_Sayings;
  private TextView TipAmount_Display;

  private Button Apply;

  double TipAmount = 15;
  double Tip = 0;
  double Total = 0;
  int counter = 0;
  BroadcastReceiver MinuteUpdaterReciver;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Hides the status bar.
    getSupportActionBar().hide();

    SubTotal_Input = findViewById(R.id.InputTotal);
    Scott_Sayings = findViewById(R.id.Scott_Speech);
    SeekBar = findViewById(R.id.TipSeekBar);
    Apply = findViewById(R.id.Apply_btn);
    TipAmount_Display = findViewById(R.id.Lbl_TipAmt);

    // Settings the min and max
    SeekBar.setMax(30);
    SeekBar.setProgress(15);

    // Running a few methods.
    Calculate();
    Seekbar();
    Updater();
  } // End of onCreate





  /********************************************************************
  *                                                                   *
  *                                                                   *
  *         Button Widget code                                        *
  *                                                                   *
  ********************************************************************/

  private void Calculate()
  {
    Apply.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        String SubTotal_String = SubTotal_Input.getText().toString();

        if (!(SubTotal_String.equals("") || SubTotal_String.equals("0")))
        {
          double SubTotal = Double.parseDouble(SubTotal_String);

          if (TipAmount != 0)
          {
            Tip = SubTotal * (TipAmount / 100);
          }

          Total = SubTotal + Tip;

          // Formatting the decimal points.
          String Tip_Double = String.format("$" + "%.2f", Tip);
          String Total_Format = String.format("$" + "%.2f", Total);

          Scott_Sayings.setText(" Your Tip amount is: " + Tip_Double + " \n And your Total amount is: " + Total_Format );

        }
        else
        {
          Toast toast = Toast.makeText(getApplicationContext(), " Please Enter an amount. ", Toast.LENGTH_LONG);
          toast.show();
        }


      }
    });
  }

  /********************************************************************
   *                                                                   *
   *                                                                   *
   *                    Seek Widget code                               *
   *                                                                   *
   ********************************************************************/

  public void Seekbar()
  {
    SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

      @Override
      public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
        TipAmount = progress;
        DecimalFormat FormatTipCalc = new DecimalFormat("0.##");
        TipAmount_Display.setText(FormatTipCalc.format(TipAmount) + "%");
        Calculate();

        if (progress == 0)
        {
          Scott_Sayings.setText("Hey partner some just reminding you that ya set your tip to 0");
        }
        else if (progress == 15)
        {
          Scott_Sayings.setText("15% eh? thats pretty standard id say");

        }
        else if (progress == 30)
        {
          Scott_Sayings.setText("Holy Cow biscuits a 30% that will sure bring someone a smile!!! ");

        }
        else
        {
          Scott_Sayings.setText(" Did you know that St Patrick's day is credited for bringing Christianity to Ireland around A.D. 432.");

        }

      }

      @Override
      public void onStartTrackingTouch(android.widget.SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(android.widget.SeekBar seekBar) {

      }

    });
  }

  /********************************************************************
   *                                                                   *
   *                                                                   *
   *                    Fun  Widget code                               *
   *                                                                   *
   ********************************************************************/

  // Source: https://www.youtube.com/watch?v=G6AkbQkfywE&t=2s , https://www.youtube.com/watch?v=QKQeSWPEp18&t=247s , https://www.youtube.com/watch?v=6sBqeoioCHE&t=378s
  // https://developer.android.com/reference/java/lang/Thread

  // I had to do some research and found some helpful links on how I could make Scott change his sayings every few seconds.
    public void Updater() {

      Thread t = new Thread()
      {
        @Override
        public void run() {
          super.run();
          {
            try {
              while (!isInterrupted()){
                Thread.sleep(30000); // 30000 milli = 30 seconds
                runOnUiThread(new Runnable() {
                  @Override
                  public void run() {

                    if (counter == 0) {
                      Scott_Sayings.setText(" The original color for St. Patrick's day was blue ");
                      counter++;
                    } else if (counter == 1) {
                      Scott_Sayings.setText(" St. Patrick died more than 1,500 years ago on March 17th ");
                      counter++;
                    } else if (counter == 2) {
                      Scott_Sayings.setText(" During St. Patrick's day a law forced all pubs to close but was repealed in 1961  ");
                      counter++;
                    } else if (counter == 3) {
                      Scott_Sayings.setText(" St. Patrick died more than 1,500 years ago on March 17th ");
                      counter++;
                    } else if (counter == 4) {
                      Scott_Sayings.setText(" The first St. Patrick's Day parade was held in U.S in 1762 ");
                      counter++;
                    } else if (counter == 5) {
                      Scott_Sayings.setText(" Hallmark sells nearly 12 million St. Patrick day cards each year! ");
                      counter++;
                    } else if (counter == 6) {
                      Scott_Sayings.setText(" St. Patrick wasn't Irish he was born in Britain ");
                      counter++;
                    } else {
                      Scott_Sayings.setText(" The original color for St. Patrick's day was blue ");
                      counter = 0;
                    }
                  }});

                  }
                  } catch (InterruptedException e)
                {
                  Toast toast = Toast.makeText(getApplicationContext(), " InterruptedException ERROR  ", Toast.LENGTH_LONG);
                  toast.show();
                }
                }

              }
            };
      t.start();
      }
    }// End of Activity
