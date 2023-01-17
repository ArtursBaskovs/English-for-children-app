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

public class Task1Act extends AppCompatActivity {
    Button atb, toMain;
    TextView tquest;
    EditText taskInput;
    private DBManager dbMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        //db
        dbMan = new DBManager(this);
        dbMan.open();

        String question = dbMan.fetchQuestions(2);
        String answ = dbMan.fetchAnswers(2);
        tquest = findViewById(R.id.task1Q);
        tquest.setText(question);

        taskInput = findViewById(R.id.taskInput);

        atb = findViewById(R.id.answBTN);

        atb.setOnClickListener(new View.OnClickListener() {
            int tries = 0;
            int points = 0;
            @Override
            public void onClick(View view) {
                if(answ.equals(taskInput.getText().toString())) {
                    tries = 0;
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("text", String.valueOf(points+ 1));
                    editor.apply();

                    //getting from preferences
                    SharedPreferences preferencesGet = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    String pp = preferences.getString("text", "");
                    Toast.makeText(getApplicationContext(),"+1 punkts. Kopā: " + pp, Toast.LENGTH_LONG).show();

                    Intent i1 = new Intent(Task1Act.this, Task2Act.class);
                    startActivity(i1);

                }
                else if(tries == 1) {
                    tries = 0;
                    Toast.makeText(getApplicationContext(),"Nepareiza atbilde. 0 punkti", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(Task1Act.this, Task2Act.class);
                    startActivity(i2);
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
                Intent i1 = new Intent(Task1Act.this, MainActivity.class);
                startActivity(i1);
            }
        });





    }
}