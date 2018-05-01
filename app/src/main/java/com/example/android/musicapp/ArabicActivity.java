package com.example.android.musicapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArabicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic);

        /*Make a arraylist*/
        final ArrayList<Music> songs = new ArrayList<Music>();

        /*Add songs*/
        songs.add(new Music(getString(R.string.nancy_song_title), getString(R.string.nancy), R.drawable.nancy, R.raw.aamballishhibbak));
        songs.add(new Music(getString(R.string.douzi_song_title), getString(R.string.douzi), R.drawable.douzi_mina, R.raw.douzimina));
        songs.add(new Music(getString(R.string.saad_song_1), getString(R.string.saad), R.drawable.saad_lm3allem, R.raw.saadlm3allem));
        songs.add(new Music(getString(R.string.saad_song_2), getString(R.string.saad), R.drawable.saad_letgo, R.raw.saadletgo));


        MusicAdapter adapterForArabic = new MusicAdapter(this, songs);
        final ListView listForArabic = (ListView) findViewById(R.id.list_arabic);
        listForArabic.setAdapter(adapterForArabic);

        /*Send a arraylist to NowPlaying*/
        listForArabic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ArabicActivity.this, NowPlaying.class);
                intent.putExtra("SONGS", songs.get(position));
                startActivity(intent);


            }
        });

        /*Bottom Navigation for help user to navigate between different activity*/
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_arabic);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_nav:
                        finish();
                        Intent intentHome = new Intent(ArabicActivity.this,LibraryActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.hindi_nav:
                        finish();
                        Intent intentHindi = new Intent(ArabicActivity.this,HindiActivity.class);
                        startActivity(intentHindi);
                        break;
                    case R.id.arabic_nav:

                        break;
                    case R.id.english_nav:
                        finish();
                        Intent intentEnglish = new Intent(ArabicActivity.this,EnglishActivity.class);
                        startActivity(intentEnglish);
                        break;

                }
                return false;
            }
        });
    }
}
