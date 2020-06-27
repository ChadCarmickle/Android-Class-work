package com.murach.fragment;

import java.util.Random;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Clicker extends Fragment {

    private Button Btn_Fragment;
    private Button Btn_RetartScores;
    private TextView Lbl_Fragment_Output;

    private TextView UserScore_Display;
    private TextView BotScore_Display;

    private int max = 6;
    private int min = 1;

    private int UserScoreBoard = 0;
    private int BotScoreBoard = 0;
    private int TieScoreBoard = 0;
    private TextView UserScoreBoard_TextView;
    private TextView BotScoreBoard_TxtView;
    private TextView TieScoreBoard_TxtView;

    private int BotScore = 0;
    private int UserScore = 0;

    private int UserWin = 0;
    private int  UserLose = 0;
    private int  UserTie = 0;

    // User Dice
    private ImageView User_Dice1;
    private ImageView User_Dice2;
    private ImageView User_Dice3;
    private ImageView User_Dice4;
    private ImageView User_Dice5;
    private ImageView User_Dice6;

    // Bot Dice
    private ImageView Bot_Dice1;
    private ImageView Bot_Dice2;
    private ImageView Bot_Dice3;
    private ImageView Bot_Dice4;
    private ImageView Bot_Dice5;
    private ImageView Bot_Dice6;


    // We only need the onCreateView everything else is deleted.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Creates the layout to the fragment_clicker view.
        View clickFrag =  inflater.inflate(R.layout.fragment_clicker, container, false);

        // Linking the Btn Fragment to output.
        Lbl_Fragment_Output = clickFrag.findViewById(R.id.Lbl_Output);
        // Linking Btn_Fragment to Uml.
        Btn_Fragment = clickFrag.findViewById(R.id.Btn_Fragment_Click_Me);
        Btn_RetartScores = clickFrag.findViewById(R.id.Btn_restart);
        // Seting the display.
        BotScore_Display = clickFrag.findViewById(R.id.BotScore);
        UserScore_Display = clickFrag.findViewById(R.id.UserScore);

        // Reference to scoreboard.
        UserScoreBoard_TextView = clickFrag.findViewById(R.id.lbl_UserScoreBoard);
        BotScoreBoard_TxtView = clickFrag.findViewById(R.id.lbl_BotScoreBoard);
        TieScoreBoard_TxtView = clickFrag.findViewById(R.id.lbl_TieScoreBoard);
        // Reference to the dice.
        User_Dice1 = clickFrag.findViewById(R.id.User_Dice1);
        User_Dice2 = clickFrag.findViewById(R.id.User_Dice2);
        User_Dice3 = clickFrag.findViewById(R.id.User_Dice3);
        User_Dice4 = clickFrag.findViewById(R.id.User_Dice4);
        User_Dice5 = clickFrag.findViewById(R.id.User_Dice5);
        User_Dice6 = clickFrag.findViewById(R.id.User_Dice6);

        Bot_Dice1 = clickFrag.findViewById(R.id.Bot_Dice1);
        Bot_Dice2 = clickFrag.findViewById(R.id.Bot_Dice2);
        Bot_Dice3 = clickFrag.findViewById(R.id.Bot_Dice3);
        Bot_Dice4 = clickFrag.findViewById(R.id.Bot_Dice4);
        Bot_Dice5 = clickFrag.findViewById(R.id.Bot_Dice5);
        Bot_Dice6 = clickFrag.findViewById(R.id.Bot_Dice6);

        Btn_Fragment.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                Dice_Calc();

                if (UserWin == 1) {
                    Lbl_Fragment_Output.setText("You won!");
                    UserScoreBoard++;
                    UserScoreBoard_TextView.setText("You: " + UserScoreBoard);
                }
                else if (UserLose == 1)
                {
                    Lbl_Fragment_Output.setText("You Lose. :( ");
                    BotScoreBoard++;
                    BotScoreBoard_TxtView.setText("Computer: " + BotScoreBoard);

                }
                else if (UserTie == 1)
                {
                    Lbl_Fragment_Output.setText("You both Tied!");
                    TieScoreBoard++;
                    TieScoreBoard_TxtView.setText("Ties: " + TieScoreBoard);
                }
                UserScore_Display.setText("Your Dice Number:  " + UserScore);
                BotScore_Display.setText("Computer Dice Number " + BotScore);
            }
        });

        Btn_RetartScores.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                UserScoreBoard = 0;
                UserScoreBoard_TextView.setText("You: " + UserScoreBoard);

                BotScoreBoard = 0;
                BotScoreBoard_TxtView.setText("Computer: " + BotScoreBoard);

                TieScoreBoard = 0;
                TieScoreBoard_TxtView.setText("Ties: " + TieScoreBoard);

                Lbl_Fragment_Output.setText("Score's Reset!");

            }
        });


        return clickFrag;
    }

    public void Dice_Calc() {

        // Random number generator for the user.
        final int User_RandomNumber = new Random().nextInt((max - min) + 1) + min;
        final int Bot_RandomNumber = new Random().nextInt((max - min) + 1) + min;

        UserScore = User_RandomNumber;
        BotScore = Bot_RandomNumber;

        // If statement starts to tell whether the user won, lost or tied.
        if (User_RandomNumber > Bot_RandomNumber) {
            UserWin = 1; // Set to true
            UserLose = 0;
            UserTie = 0;
        }
        else if (User_RandomNumber < Bot_RandomNumber) {
            UserLose = 1; // Set to true
            UserWin = 0;
            UserTie = 0;
        }
        else {
            UserTie = 1; // Set to true
            UserWin = 0;
            UserLose = 0;
        }
        User_Dice_Display();
        Bot_Dice_Display();

    }

    // Based on Random Number the code will display the current dice.
    public void User_Dice_Display() {
        if (UserScore == 1) {
            User_Dice1.setVisibility(View.VISIBLE);
            User_Dice2.setVisibility(View.GONE);
            User_Dice3.setVisibility(View.GONE);
            User_Dice4.setVisibility(View.GONE);
            User_Dice5.setVisibility(View.GONE);
            User_Dice6.setVisibility(View.GONE);

        } else if (UserScore == 2) {
            User_Dice1.setVisibility(View.GONE);
            User_Dice2.setVisibility(View.VISIBLE);
            User_Dice3.setVisibility(View.GONE);
            User_Dice4.setVisibility(View.GONE);
            User_Dice5.setVisibility(View.GONE);
            User_Dice6.setVisibility(View.GONE);
        } else if (UserScore == 3) {
            User_Dice1.setVisibility(View.GONE);
            User_Dice2.setVisibility(View.GONE);
            User_Dice3.setVisibility(View.VISIBLE);
            User_Dice4.setVisibility(View.GONE);
            User_Dice5.setVisibility(View.GONE);
            User_Dice6.setVisibility(View.GONE);
        } else if (UserScore == 4) {
            User_Dice1.setVisibility(View.GONE);
            User_Dice2.setVisibility(View.GONE);
            User_Dice3.setVisibility(View.GONE);
            User_Dice4.setVisibility(View.VISIBLE);
            User_Dice5.setVisibility(View.GONE);
            User_Dice6.setVisibility(View.GONE);
        } else if (UserScore == 5) {
            User_Dice1.setVisibility(View.GONE);
            User_Dice2.setVisibility(View.GONE);
            User_Dice3.setVisibility(View.GONE);
            User_Dice4.setVisibility(View.GONE);
            User_Dice5.setVisibility(View.VISIBLE);
            User_Dice6.setVisibility(View.GONE);
        } else if (UserScore == 6) {
            User_Dice1.setVisibility(View.GONE);
            User_Dice2.setVisibility(View.GONE);
            User_Dice3.setVisibility(View.GONE);
            User_Dice4.setVisibility(View.GONE);
            User_Dice5.setVisibility(View.GONE);
            User_Dice6.setVisibility(View.VISIBLE);
        }
    }

            /*******************Bot Display Dice *************************8*/
    public void Bot_Dice_Display()
        {
            if (BotScore == 1) {
                Bot_Dice1.setVisibility(View.VISIBLE);
                Bot_Dice2.setVisibility(View.GONE);
                Bot_Dice3.setVisibility(View.GONE);
                Bot_Dice4.setVisibility(View.GONE);
                Bot_Dice5.setVisibility(View.GONE);
                Bot_Dice6.setVisibility(View.GONE);

            } else if (BotScore == 2) {
                Bot_Dice1.setVisibility(View.GONE);
                Bot_Dice2.setVisibility(View.VISIBLE);
                Bot_Dice3.setVisibility(View.GONE);
                Bot_Dice4.setVisibility(View.GONE);
                Bot_Dice5.setVisibility(View.GONE);
                Bot_Dice6.setVisibility(View.GONE);
            } else if (BotScore == 3) {
                Bot_Dice1.setVisibility(View.GONE);
                Bot_Dice2.setVisibility(View.GONE);
                Bot_Dice3.setVisibility(View.VISIBLE);
                Bot_Dice4.setVisibility(View.GONE);
                Bot_Dice5.setVisibility(View.GONE);
                Bot_Dice6.setVisibility(View.GONE);
            } else if (BotScore == 4) {
                Bot_Dice1.setVisibility(View.GONE);
                Bot_Dice2.setVisibility(View.GONE);
                Bot_Dice3.setVisibility(View.GONE);
                Bot_Dice4.setVisibility(View.VISIBLE);
                Bot_Dice5.setVisibility(View.GONE);
                Bot_Dice6.setVisibility(View.GONE);
            } else if (BotScore == 5) {
                Bot_Dice1.setVisibility(View.GONE);
                Bot_Dice2.setVisibility(View.GONE);
                Bot_Dice3.setVisibility(View.GONE);
                Bot_Dice4.setVisibility(View.GONE);
                Bot_Dice5.setVisibility(View.VISIBLE);
                Bot_Dice6.setVisibility(View.GONE);
            } else if (BotScore == 6) {
                Bot_Dice1.setVisibility(View.GONE);
                Bot_Dice2.setVisibility(View.GONE);
                Bot_Dice3.setVisibility(View.GONE);
                Bot_Dice4.setVisibility(View.GONE);
                Bot_Dice5.setVisibility(View.GONE);
                Bot_Dice6.setVisibility(View.VISIBLE);
            }
        }
    }

