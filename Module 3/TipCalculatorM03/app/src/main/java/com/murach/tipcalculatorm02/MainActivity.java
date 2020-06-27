package com.murach.tipcalculatorm02;

import android.content.SharedPreferences;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// Importing widgets for textView and editText Step 2.
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

// Importing NumberFormat for step 3
import java.text.DecimalFormat;
import java.text.NumberFormat;

// Importing Listener for step 3
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends AppCompatActivity {

    // Making variables.
    private EditText bill_Amount;
    private TextView percent_Amount;
    private TextView discount_Amount;
    private TextView total_Amount;
    private Button BtnCalc;
    double Discount_Number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencing the objects to ones on MainActivity.
        bill_Amount = findViewById(R.id.Bill_Amount);
        percent_Amount = findViewById(R.id.Percent_Amount);
        discount_Amount = findViewById(R.id.Discount_Amount);
        total_Amount = findViewById(R.id.Total_Amount);
        BtnCalc = findViewById(R.id.CalculateOrder);


       // Button to complete input and carry out calculations
        BtnCalc.setOnClickListener(

                new Button.OnClickListener() {
                    public void onClick(View V) {

                        String Bill_Amount_String = bill_Amount.getText().toString();  // Pulling the input from Bill_Amount and converting it to a string.

                        double Bill_Number = Double.parseDouble(Bill_Amount_String); // Concerting it to a double.
                        double Tipcalc = 0; // Making a titCalc and comparing the discount value to the number of the bill.

                        if (Bill_Number >= 200) {
                            Tipcalc = 20;
                        } else if (Bill_Number >= 100) {
                            Tipcalc = 10;
                        } else {
                            Tipcalc = 0;
                        }


                        // Preventing discount-Number from being multiplied by a 0.
                        if (Tipcalc != 0) {
                            Discount_Number = Bill_Number * (Tipcalc / 100);

                        }

                        // Declaring a variable for the Total.
                        double Total = Bill_Number - Discount_Number;


                        // Formatting the decimal points.
                        DecimalFormat FormatTipCalc = new DecimalFormat("0.##");
                        String Discount_Double = String.format("$" + "%.2f", Discount_Number);
                        String Total_Format = String.format("$" + "%.2f", Total);

                        // Setting the text to the labels to display correct output.
                        percent_Amount.setText(FormatTipCalc.format(Tipcalc) + "%");
                        discount_Amount.setText(Discount_Double);
                        total_Amount.setText(Total_Format);

                    } // End of OnClick

                } // End of OnClick Listener

        ); // End of OnClick Listener.

    } // End of OnCreate Method.

} // End of main Activity.

