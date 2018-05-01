package com.example.android.musicapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NowPlaying extends AppCompatActivity implements View.OnClickListener {

    Button btPlay;
    int albumArt;
    String songtitle;
    String songArtist;
    int songfile;
    MediaPlayer mp;
    SeekBar seekBar;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        btPlay = findViewById(R.id.playbutton);
        btPlay.setOnClickListener(this);


        Intent music = getIntent();
        Music songs = music.getParcelableExtra("SONGS");

        /*Gets the song info and store in a variable*/
        albumArt = songs.getAlbumart();
        songArtist = songs.getArtistName();
        songtitle = songs.getsongName();
        songfile = songs.songFile();


        ImageView imageView = findViewById(R.id.imageViewdis);
        imageView.setImageResource(albumArt);
        TextView textView1 = findViewById(R.id.artistnamedis);
        textView1.setText(songArtist);
        TextView textView2 = findViewById(R.id.songtitledis);
        textView2.setText(songtitle);

        mp = MediaPlayer.create(NowPlaying.this, songfile);
        mp.start();
        btPlay.setBackgroundResource(R.drawable.pausebutton);

        /*Seekbar function for current song is playing*/
        seekBar = findViewById(R.id.seekBar);
        thread = new Thread() {
            @Override
            public void run() {
                int totalDuration = mp.getDuration();
                int currentDuration = 0;
                while (currentDuration < totalDuration) {
                    try {
                        sleep(500);
                        currentDuration = mp.getCurrentPosition();
                        seekBar.setProgress(currentDuration);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(seekBar.getProgress());
            }
        });
        seekBar.setMax(mp.getDuration());
        thread.start();


        /*Bottom Navigation for help user to navigate between different activity*/
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_nowplaying);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_nav:
                        mp.stop();
                        finish();
                        Intent intentHome = new Intent(NowPlaying.this,LibraryActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.hindi_nav:
                        mp.stop();
                        finish();
                        Intent intentHindi = new Intent(NowPlaying.this,HindiActivity.class);
                        startActivity(intentHindi);
                        break;
                    case R.id.arabic_nav:
                        mp.stop();
                        finish();
                        Intent intentArabic = new Intent(NowPlaying.this,ArabicActivity.class);
                        startActivity(intentArabic);
                        break;
                    case R.id.english_nav:
                        mp.stop();
                        finish();
                        Intent intentEnglish = new Intent(NowPlaying.this,ArabicActivity.class);
                        startActivity(intentEnglish);
                        break;

                }
                return false;
            }
        });



    }

    /*When back button pressed the current song stopped*/
    @Override
    public void onBackPressed() {
        if (mp != null)
            mp.stop();
        super.onBackPressed();
    }

    /*When pause button pressed it pause the current song and changes button image*/
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.playbutton:
                if (mp.isPlaying()) {
                    mp.pause();
                    btPlay.setBackgroundResource(R.drawable.playbutton);
                } else {
                    mp.start();
                    btPlay.setBackgroundResource(R.drawable.pausebutton);
                }
                break;
        }
    }
}