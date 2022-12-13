package com.binus.servicetutorial;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyMusicService extends Service {
    MediaPlayer mp;

    public MyMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
        mp = MediaPlayer.create(this, R.raw.music);
        mp.setLooping(true);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        mp.start();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Ended", Toast.LENGTH_SHORT).show();
        mp.stop();
    }
}