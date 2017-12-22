package com.myapp.shankar.weddingapp;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.design.widget.BottomNavigationView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import static android.media.session.PlaybackState.ACTION_STOP;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {




//i am using bottomNavigation for this application

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homemusic:   //when i click on music
                         Intent i=new Intent(getApplicationContext(),MainActivity.class);
                           startActivity(i);
                        Intent svc=new Intent(getApplicationContext(), MyService.class);
                        startService(svc); //to start the music i use this intent



                       // stopService();

                        //Intent gks=new Intent(getApplicationContext(), MyService.class);
                        //stopService(gks);



                        return true;

                    case R.id.wedd:  //when i click on the second tab
                        Intent imm=new Intent(getApplicationContext(), Weddactivity.class); //when i click on the second tab i use this
                        startActivity(imm);
                        Intent ggg=new Intent(getApplicationContext(), MyService.class);
                        stopService(ggg); //i dont want music in my second tab so i am using this to stop the service
                        return  true;


                    case R.id.navigation_location:
                        Intent igt=new Intent(getApplicationContext(),MapsActivity.class); //for getting the map location
                        startActivity(igt);
                        Intent fff=new Intent(getApplicationContext(), MyService.class);
                        stopService(fff);//i dont want music in third tab so i am using this to stop service that is music

                        // mTextMessage.setText(R.string.title_dashboard);
                        return true;
                    //  case R.id.navigation_countdown:
                    //     Intent inn=new Intent(getApplicationContext(),Countdowntimer.class);
                    //     startActivity(inn);
                    //     return true;

                    //   case R.id.navigation_photoalbum:
                    //    Intent ipp=new Intent(getApplicationContext(),Viewflippy.class);
                    //   startActivity(ipp);
                    //   return true;

                }
                return false;
            }

        };



    //we know once we quit the app the music keeps running inorder to stop the music i am using this
    public void onBackPressed()    //to stop the music i am using this method

    {
       // onDestroy();
        super.onBackPressed();
       // onDestroy();
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), MyService.class);
        stopService(intent);




    }


  //  public void stopService(){
   //     Intent stopIntent = new Intent(getBaseContext(),MyService.class);
   //     intent.setAction(MyService.ACTION_STOP);
   //     stopService(stopIntent);
  //  }



        private int currentPage = -1;

        private int NUM_PAGES=0;
        Runnable update;
        Timer timer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);















        // final int currentPage = 0;
        final Timer timer;
        final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
        final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.


        //private int currentPage = -1;
        final ViewPager viewPager;


        final  Integer[] imageId = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10,R.drawable.image11,R.drawable.image12};
        final String[] imagesName = {"couples","couples","couples","couples","couples","couples","couples","couples","couples","couples","couples","couples"};




        viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter adapter = new CustomAdapter(MainActivity.this,imageId,imagesName);
        viewPager.setAdapter(adapter);
   //USING THREADS AND HANDLERS FOR SLIDESHOW
        final Handler handler = new Handler();
        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);

        update = new Runnable() {
            public void run() {
                //  if (currentPage == NUM_PAGES-1) {
                if(currentPage==imagesName.length)
                {
                    viewPager.setCurrentItem(0, true);
                    if(timer!=null)
                    {




                        timer.cancel();
                    }


                }
                else
                {
                    viewPager.setCurrentItem(currentPage++, true);
                }

            }
        };


//AFTER MILLISECONDS THE IMAGE KEEPS CHANGING




        // private int currentPage = -1;
        // start auto scroll of viewpager













        //    viewPager = (ViewPager)findViewById(R.id.viewPager);
        //      adapter = new CustomAdapter(this);//
        //      viewPager.setAdapter(adapter);//




        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);















           }




}