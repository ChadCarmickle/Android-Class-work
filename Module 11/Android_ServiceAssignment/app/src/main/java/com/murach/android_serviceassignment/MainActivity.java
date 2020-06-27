package com.murach.android_serviceassignment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MainActivity localActivity;
    private Button Start;
    private Button Stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Start = findViewById(R.id.Start_btn);
        Stop = findViewById(R.id.Stop_btn);

            Start.setOnClickListener(this);
            Stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == Start) {
            startService(new Intent(this, MyService.class));
        }else if(view == Stop) {
            stopService(new Intent(this, MyService.class));
        }
    }
}
