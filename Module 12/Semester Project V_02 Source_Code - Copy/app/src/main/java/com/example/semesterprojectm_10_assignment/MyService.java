package com.example.semesterprojectm_10_assignment;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
  private MediaPlayer player;
  @Override
  public IBinder onBind(Intent intent) { return null;  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    player = MediaPlayer.create(this, R.raw.song);
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

