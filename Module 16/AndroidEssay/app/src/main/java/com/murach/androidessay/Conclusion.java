package com.murach.androidessay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Conclusion extends AppCompatActivity {

    private Button Next_Btn_Conclusion;
    private TextView Lbl_Conclusion;
    private TextView EndParagraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusion);


        Lbl_Conclusion = findViewById(R.id.Lbl_Conclusion);

        Lbl_Conclusion.setText(" Conclusion.");

        Next_Btn_Conclusion = findViewById(R.id.Next_Btn_Conclusion);
        EndParagraph = findViewById(R.id.Txt_EndParagraph);

        EndParagraph.setText("From the early 1920s when America that passed the banning of alcohol to the legend known as babe Ruth and lastly the famous quote of Tesla foreshadowing the creation of mobile phones. Mobile computing has long history attached to it with a device that becomes more complex each year.  From the creation of wireless technology that are found in radio's that convert electric and magnetism into electromagnetic waves to breathtaking achievements in the future such as auto driving cars and more it’s a wonder what tomorrow in technology will bring.    ");

        Next_Btn_Conclusion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Moves to the next Page
                MovePage_Moble_to_Android_Intro();
            }
        });
    }


    // Moves forward to the page.
    public void MovePage_Moble_to_Android_Intro() {

        Intent Intent_MovePage_Intro_to_Mobile = new Intent(Conclusion.this, Sources.class);
        startActivity(Intent_MovePage_Intro_to_Mobile);
    }
}