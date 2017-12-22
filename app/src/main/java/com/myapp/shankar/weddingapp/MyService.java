package com.myapp.shankar.weddingapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import static android.media.session.PlaybackState.ACTION_STOP;
import static com.myapp.shankar.weddingapp.R.id.navigation;
import static com.myapp.shankar.weddingapp.R.id.homemusic;

public class MyService extends Service {

    public static final String ACTION_STOP = "stop_music_service";
    MediaPlayer player;



    @Override
    public IBinder onBind(Intent args0) {
        return null;

    }


    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.wedding); //storing music file in raw folder
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
        //this.stopSelf();


    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent.getAction()!=null && intent.getAction().equals(ACTION_STOP)){
            onDestroy();
        }
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer player) {
                player.release();

            }
        });
        return START_STICKY;

      //  this.stopSelf();


    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {

        player.stop();
       // player.stopService()

        this.stopSelf();

    }
    public void onPause() {


        //stopService(new Intent(this, MainActivity.class));
    }
    @Override
    public void onDestroy() {




       // Intent stopIntent = new Intent(getBaseContext(),MyService.class);
       // intent.setAction(MyService.ACTION_STOP);
       // stopService(stopIntent);

       // Log.d("SERVICE","ONDESTROY");

        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), MyService.class);
        stopService(intent);



        player.stop();

       player.release();
    }

    @Override
    public void onLowMemory() {

    }




}




















