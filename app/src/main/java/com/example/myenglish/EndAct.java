package com.example.myenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndAct extends AppCompatActivity {
    Button end;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        textView2 = findViewById(R.id.textView2);
        SharedPreferences preferencesGet = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String pp = preferencesGet.getString("text", "");

        textView2.setText("Iegūtie punkti: "+pp);

        end = findViewById(R.id.buttonEnd);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(EndAct.this, MainActivity.class);
                startActivity(i1);
            }
        });




    }
}