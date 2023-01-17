package com.example.myenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private DBManager dbMan;


    Button start;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //go to another activity
        start = findViewById(R.id.startBTN);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Task1Act.class);
                startActivity(i);
            }
        });

        //db = new DatabaseHelper(this);
        //t1 = findViewById(R.id.taskF);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("text", "");
        editor.apply();
        dbMan = new DBManager(this);
        dbMan.open();
        //dbMan.insert(2, "Zobens", "Sword", "word", "Translate this word");
        //dbMan.insert(3, "Cirvis", "Axe", "word", "Translate this word");
        //dbMan.insert(4, "My name --- Giovanni Giorgio", "is", "sentenceUse", "Enter word missing in this sentence");
        //dbMan.insert(6, "How --- your day today?", "was", "sentenceUse", "Enter word missing in this sentence");
        //String question = dbMan.fetchQuestions(3);

        //t1.setText(question);

        //adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        //adapter.notifyDataSetChanged();
    }
}