package com.example.android.musicapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HindiActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi);


        /*Make a arraylist*/
        final ArrayList<Music> songs = new ArrayList<Music>();

        /*Add songs*/
        songs.add(new Music(getString(R.string.arijit_song_title), getString(R.string.arjit), R.drawable.zalima, R.raw.zaalima));
        songs.add(new Music(getString(R.string.atif_song_title), getString(R.string.atif), R.drawable.osaathi, R.raw.osaathi));
        songs.add(new Music(getString(R.string.rahat_song_title), getString(R.string.rahat), R.drawable.sonuek, R.raw.sanuekpalchain));
        songs.add(new Music(getString(R.string.honey_song_title), getString(R.string.honey), R.drawable.dilchori, R.raw.dilchori));


        final MusicAdapter adapterForHindi = new MusicAdapter(this, songs);
        final ListView listForHindi = (ListView) findViewById(R.id.list_hindi);
        listForHindi.setAdapter(adapterForHindi);

        /*Send a arraylist to NowPlaying*/
        listForHindi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HindiActivity.this, NowPlaying.class);
                intent.putExtra("SONGS", songs.get(position));
                startActivity(intent);


            }
        });

        /*Bottom Navigation for help user to navigate between different activity*/
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_hindi);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_nav:
                        finish();
                        Intent intentHome = new Intent(HindiActivity.this,LibraryActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.hindi_nav:

                        break;
                    case R.id.arabic_nav:
                        finish();
                        Intent intentArabic = new Intent(HindiActivity.this,ArabicActivity.class);
                        startActivity(intentArabic);
                        break;
                    case R.id.english_nav:
                        finish();
                        Intent intentEnglish = new Intent(HindiActivity.this,EnglishActivity.class);
                        startActivity(intentEnglish);
                        break;

                }
                return false;
            }
        });

    }
}
