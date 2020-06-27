package com.murach.listviewinclassproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Variables
    private ListView ListTest;

    // Array for strings inside the list View
//     private String[] StringArray = {"Finn", "BubbleGum", "Gunter", "Ice King", "Jake" };

       private String[] Lbl_Names = {"New User ", "BubbleGum", "Finn", "Gunter", "Ice King", "Jake" };
       private String[] Small_Words = new String[6];
       private int[] pics = new int[6];
       private int[] numbers = {1, 2, 3, 4, 5, 6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            0 = New User
        *   1 = BubbleGum
        *   2 = Finn
        *   3 = Gunter
        *   4 = Ice King
        *   5 = Jake
        * */

        // Bubble Gum
        Small_Words[0] = "New User has joined land of ooo: " + Lbl_Names[1];
        pics[0] = R.drawable.adventure_time_wallpaper;
        Small_Words[1] = " Hey everyone I did some research and found this new form of communcations from the older times and im like talking about old before mushroom war era, its called a Social Media and the acient onces would post on this. ";
        pics[1] = R.drawable.bubblegum;

        // Finn
        Small_Words[0] = "New User has joined land of ooo: " + Lbl_Names[2];
        pics[0] = R.drawable.adventure_time_wallpaper;
        Small_Words[2] = "Sweet PB your so smart!! ";
        pics[2] = R.drawable.finnpic;

        // Gunter
        Small_Words[0] = "New User has joined land of ooo: " + Lbl_Names[3];
        pics[0] = R.drawable.adventure_time_wallpaper;
        Small_Words[3] = "Quack";
        pics[3] = R.drawable.gunter;

        // Ice King
        Small_Words[0] = "New User has joined land of ooo: " + Lbl_Names[4];
        pics[0] = R.drawable.adventure_time_wallpaper;
        pics[4] = R.drawable.iceking;
        Small_Words[4] = "Sweet now I can stalk all the cute princesses...";

        // Jake
        Small_Words[0] = "New User has joined land of ooo: " + Lbl_Names[5];
        pics[0] = R.drawable.adventure_time_wallpaper;
        pics[5] = R.drawable.jake;
        Small_Words[5] = "This is great";


    ListTest = findViewById(R.id.ListView1);

    //ListTest.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, StringArray));


        MyAdapter adapt = (new MyAdapter(this, Lbl_Names, Small_Words, pics, numbers ));
        ListTest.setAdapter(adapt);

    }// End OnCreate()
} // End MainActivity
