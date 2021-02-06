package com.example.scripture;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    String _book;
    String _chapter;
    String _verse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent= getIntent();
        _book= intent.getStringExtra(MainActivity.BOOK_PART);
        _chapter=intent.getStringExtra(MainActivity.CHAPTER_PART);
        _verse=intent.getStringExtra(MainActivity.VERSE_PART);
        TextView scriptureLabel=(TextView) findViewById(R.id.lblDescription);
        scriptureLabel.setText(_book + " " + _chapter + ":" + _verse);

    }
    public void onSaveScripture(View theButton){
        SharedPreferences sharedPrefs=getSharedPreferences(MainActivity.APP_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPrefs.edit();
        editor.apply();
        Toast.makeText(this, "Scripture has been saved", Toast.LENGTH_SHORT).show();
    }
}