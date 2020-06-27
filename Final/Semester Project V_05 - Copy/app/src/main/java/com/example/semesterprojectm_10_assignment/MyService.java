package com.example.semesterprojectm_10_assignment;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
  private MediaPlayer player;
  static int mySong[] = {R.raw.song, R.raw.your_problem, R.raw.remember, R.raw.fries, R.raw.bacon_pancake, R.raw.fiona_song, R.raw.lemon_hope };
  static int ArrayNumber = 0;
  @Override
  public IBinder onBind(Intent intent) { return null;  }



  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    player = MediaPlayer.create(this, mySong[ArrayNumber]);
    player.setLooping(false);
    player.start();
    return START_STICKY;
  }


  @Override
  public void onDestroy() {
    super.onDestroy();
    player.stop();

  }
}

