package com.example.scripture;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String BOOK_PART="BOOK_PART";
    public static final String APP_PREFS="APPLICATION_PREFFERENCES";
    public static final String CHAPTER_PART="CHAPTER_PART";
    public static final String VERSE_PART="VERSE_PART";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Favorite Scripture");
    }
    public void onDisplayScripture(View theButton){
        EditText txtBook= (EditText) findViewById(R.id.txtBook);
        EditText chapter=(EditText) findViewById(R.id.chapter);
        EditText verse=(EditText) findViewById(R.id.verse);
        String book = txtBook.getText().toString();
        String chapters=chapter.getText().toString();
        String verses=verse.getText().toString();
        Intent scriptureIntent= new Intent(this, DisplayActivity.class);

        scriptureIntent.putExtra(BOOK_PART, book);
        scriptureIntent.putExtra(CHAPTER_PART, chapters);
        scriptureIntent.putExtra(VERSE_PART, verses);
        startActivity(scriptureIntent);

    }
    public void onLoadScripture(View theButton){
        SharedPreferences sharedPref=getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        String book=sharedPref.getString(BOOK_PART, null);
        String chapters=sharedPref.getString(CHAPTER_PART, null);
        String verses=sharedPref.getString(VERSE_PART, null);
        EditText txtBook=(EditText) findViewById(R.id.txtBook);
        EditText chapter=(EditText) findViewById(R.id.chapter);
        EditText verse=(EditText) findViewById(R.id.verse);
        txtBook.setText(book);
        chapter.setText(chapters);
        verse.setText(verses);

    }
}
