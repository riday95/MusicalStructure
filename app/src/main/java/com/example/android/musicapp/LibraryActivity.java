package com.example.android.musicapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class LibraryActivity extends AppCompatActivity {

    ImageButton arabic;
    ImageButton hindi;
    ImageButton english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Toast.makeText(getApplicationContext(), "Please choose a category", Toast.LENGTH_LONG).show();

        arabic = findViewById(R.id.arabic_cat);
        hindi = findViewById(R.id.hindi_cat);
        english = findViewById(R.id.english_cat);

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arabicCat = new Intent(LibraryActivity.this, ArabicActivity.class);
                startActivity(arabicCat);
            }
        });
        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hindiCat = new Intent(LibraryActivity.this, HindiActivity.class);
                startActivity(hindiCat);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent englishCat = new Intent(LibraryActivity.this, EnglishActivity.class);
                startActivity(englishCat);
            }
        });
    }
}