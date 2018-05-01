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

import java.util.ArrayList;

public class EnglishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        /*Make a arraylist*/
        final ArrayList<Music> songs = new ArrayList<Music>();

        /*Add songs*/
        songs.add(new Music(getString(R.string.geazy_song_title), getString(R.string.geazy), R.drawable.goodlife, R.raw.goodlife));
        songs.add(new Music(getString(R.string.imagine_song_title), getString(R.string.imagine), R.drawable.believer, R.raw.believer));
        songs.add(new Music(getString(R.string.demi_songs_title), getString(R.string.demi), R.drawable.nopromises, R.raw.nopromises));
        songs.add(new Music(getString(R.string.alan_song_title), getString(R.string.alan), R.drawable.allfallsdown, R.raw.allfallsdown));


        MusicAdapter adapterForEnglish = new MusicAdapter(this, songs);
        final ListView listForEnglish = findViewById(R.id.list_english);
        listForEnglish.setAdapter(adapterForEnglish);

        /*Send a arraylist to NowPlaying*/
        listForEnglish.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EnglishActivity.this, NowPlaying.class);
                intent.putExtra("SONGS", songs.get(position));
                startActivity(intent);


            }
        });

        /*Bottom Navigation for help user to navigate between different activity*/
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_english);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_nav:
                        finish();
                        Intent intentHome = new Intent(EnglishActivity.this,LibraryActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.hindi_nav:
                        finish();
                        Intent intentHindi = new Intent(EnglishActivity.this,HindiActivity.class);
                        startActivity(intentHindi);
                        break;
                    case R.id.arabic_nav:
                        finish();
                        Intent intentArabic = new Intent(EnglishActivity.this,ArabicActivity.class);
                        startActivity(intentArabic);
                        break;
                    case R.id.english_nav:

                        break;

                }
                return false;
            }
        });
    }
}
