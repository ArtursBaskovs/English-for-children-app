package com.example.myenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Task3Act extends AppCompatActivity {
    Button atb, toMain;
    TextView tquest;
    EditText taskInput;
    private DBManager dbMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);


        //db
        dbMan = new DBManager(this);
        dbMan.open();

        String question = dbMan.fetchQuestions(4);
        String answ = dbMan.fetchAnswers(4);
        tquest = findViewById(R.id.task1Q);
        tquest.setText(question);

        taskInput = findViewById(R.id.taskInput);

        atb = findViewById(R.id.answBTN);
        atb.setOnClickListener(new View.OnClickListener() {
            SharedPreferences preferencesGet = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            String pp = preferencesGet.getString("text", "");
            int tries = 0;
            int points = Integer.parseInt(pp);
            @Override
            public void onClick(View view) {
                if(answ.equals(taskInput.getText().toString())) {
                    tries = 0;
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("text", String.valueOf(points+ 1));
                    editor.apply();
                    points++;
                    //getting from preferences

                    Toast.makeText(getApplicationContext(),"+1 punkts. Kopā: " + points, Toast.LENGTH_LONG).show();

                    Intent i1 = new Intent(Task3Act.this, Task4Act.class);
                    startActivity(i1);

                }
                else if(tries > 0) {
                    tries = 0;
                    Toast.makeText(getApplicationContext(),"Nepareiza atbilde. 0 punkti", Toast.LENGTH_LONG).show();
                    Intent i1 = new Intent(Task3Act.this, Task4Act.class);
                    startActivity(i1);
                }
                else {
                    tries++;
                    Toast.makeText(getApplicationContext(),"Nepareiza atbilde, pamēģini vēl", Toast.LENGTH_LONG).show();
                }
            }
        });

        toMain = findViewById(R.id.button2);
        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Task3Act.this, MainActivity.class);
                startActivity(i1);
            }
        });
    }
}