package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DisplayWordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_words);
        TextView display = (TextView) findViewById(R.id.displayAnagrams);
        display.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();
        ArrayList<String> anagrams = intent.getStringArrayListExtra("anagram list");

        String out = "";

        for(int i = 0; i < anagrams.size(); i++){
            out += anagrams.get(i) + " ";
            if(i % 3 == 2)
                out += "\n";
        }

        display.setText(out);

        Button returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayWordsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}