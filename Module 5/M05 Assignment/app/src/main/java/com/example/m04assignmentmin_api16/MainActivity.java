package com.example.m04assignmentmin_api16;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import java.text.DecimalFormat;

                                                                                            // Have to implement the object.
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private static final String Tag = "MyActivity";

    private EditText bill_Amount;
    private TextView percent_Amount;
    private TextView discount_Amount;
    private TextView total_Amount;
    private Button BtnCalc;
    double Discount_Number = 0;
    double Tipcalc = 10;

    // Variable for my DropBox
    private Spinner SplitSpinner;

    // All my Radio Buttons
    private RadioGroup RadioGroup;
    private RadioButton Radio_RoundNone;
    private RadioButton Radio_RoundNTip;
    private RadioButton Radio_RoundNTotal;

    // Variable for my total
    double Total;

    // Variable for the two buttons
    private Button MinusButton;
    private Button PlusButton;

    // Variables for the bottom Textfields.
    private TextView PerPerson;
    private TextView Lbl_PerPerson;

    // Variables for my Bill amount, variable to maintain bill Amount for dropbox uses.
    private double Bill_Amount = 0;
    private double Total_OG = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Referencing the objects to ones on MainActivity.
        bill_Amount = findViewById(R.id.Input_Bill_Amount);
        percent_Amount = findViewById(R.id.Percent_Number_Amount);
        discount_Amount = findViewById(R.id.Tip_Number_Amount);
        total_Amount = findViewById(R.id.Total_Amount);
        BtnCalc = findViewById(R.id.Btn_Apply);
        SplitSpinner = findViewById(R.id.spinner_DropBox);
        MinusButton = findViewById(R.id.Btn_Minus);
        PlusButton = findViewById(R.id.Btn_Plus);
        Lbl_PerPerson = findViewById(R.id.Lbl_PerPerson);
        PerPerson = findViewById(R.id.Per_Person_Amount);

      // Radio buttons
      Radio_RoundNone = findViewById(R.id.Radio_RoundNone);
      Radio_RoundNTip = findViewById(R.id.Radio_RoundNTip);
      Radio_RoundNTotal = findViewById(R.id.Radio_RoundNTotal);

        // Creating the on Key Listener and passing the object as this.
        BtnCalc.setOnClickListener(this);
        PlusButton.setOnClickListener(this);
        MinusButton.setOnClickListener(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.DropBox_Entities, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SplitSpinner.setAdapter(adapter);


                // Spinner
                SplitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        // I tried to use Total Format and place it up here but it would bug out the code and not work correctly

                        switch (position) {
                            case 0:
                                // User selects to split the bill No
                                String Total_Format1 = String.format("$" + "%.2f", Bill_Amount);
                                PerPerson.setVisibility(View.GONE);
                                Lbl_PerPerson.setVisibility(View.GONE);
                                PerPerson.setText(Total_Format1);
                                break;

                            case 1:
                                // User selects to split the bill 2 ways
                                Bill_Amount = Bill_Amount / 2;
                                String Total_Format2 = String.format("$" + "%.2f", Bill_Amount);
                                Lbl_PerPerson.setVisibility(View.VISIBLE);
                                PerPerson.setVisibility(View.VISIBLE);
                                PerPerson.setText(Total_Format2);
                                Bill_Amount = Total_OG;
                                break;

                            case 2:
                                // User selects to split the bill 3 ways
                                Bill_Amount = Bill_Amount / 3;
                                String Total_Format3 = String.format("$" + "%.2f", Bill_Amount);
                                Lbl_PerPerson.setVisibility(View.VISIBLE);
                                PerPerson.setVisibility(View.VISIBLE);
                                PerPerson.setText(Total_Format3);
                                Bill_Amount = Total_OG;
                                break;

                            case 3:
                                // User selects to split the bill 4 ways
                                Bill_Amount = Bill_Amount / 4;
                                String Total_Format = String.format("$" + "%.2f", Bill_Amount);
                                Lbl_PerPerson.setVisibility(View.VISIBLE);
                                PerPerson.setVisibility(View.VISIBLE);
                                PerPerson.setText(Total_Format);
                                Bill_Amount = Total_OG;
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }


            // Method that does all the magic.
            public void CalculateAndDisplay() {

                String Bill_Amount_String = bill_Amount.getText().toString();  // Pulling the input from Bill_Amount and converting it to a string.
                double Bill_Number = Double.parseDouble(Bill_Amount_String);

              if (Radio_RoundNTip.isChecked()) {
                Discount_Number = StrictMath.round(Bill_Number * (Tipcalc / 100));
                Total = Bill_Number + Discount_Number;

              } else if (Radio_RoundNTotal.isChecked()) {
                double TipNotRounded = Bill_Number * (Tipcalc / 100);
                Total = StrictMath.round(Bill_Number + TipNotRounded);
                Discount_Number = Total - Bill_Number;

              } else {
                Total = Bill_Number + Discount_Number;
              }

                Discount_Number = Bill_Number * (Tipcalc / 100);
                Total = Bill_Number + Discount_Number;

                Total_OG = Total; // Sets the total to this variable that allows the dropboxes to use Total and this will refresh the value back.


                Bill_Amount = Total;


                DecimalFormat FormatTipCalc = new DecimalFormat("0.##");
                String Discount_Double = String.format("$" + "%.2f", Discount_Number);
                String Total_Format = String.format("$" + "%.2f", Total);

                percent_Amount.setText(FormatTipCalc.format(Tipcalc) + "%");
                discount_Amount.setText(Discount_Double);
                total_Amount.setText(Total_Format);
            }

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            // Using an anonymous class to handle all button interfaces.
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.Btn_Minus:

                        if (Tipcalc != 0) {
                            Tipcalc = (Tipcalc - 1);
                            DecimalFormat FormatTipCalc = new DecimalFormat("0.##");
                            percent_Amount.setText(FormatTipCalc.format(Tipcalc) + "%");
                            CalculateAndDisplay();
                        } else
                            Tipcalc = 0;
                        CalculateAndDisplay();
                        break;

                    case R.id.Btn_Plus:
                        Tipcalc = (Tipcalc + 1);
                        DecimalFormat FormatTipCalc = new DecimalFormat("0.##");
                        percent_Amount.setText(FormatTipCalc.format(Tipcalc) + "%");
                        CalculateAndDisplay();
                        break;

                    case R.id.Btn_Apply:
                        PerPerson.setVisibility(View.GONE);
                        Lbl_PerPerson.setVisibility(View.GONE);
                        CalculateAndDisplay();
                        break;
                }
            }
        }
