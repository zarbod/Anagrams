package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anagrams obj = new Anagrams();
        EditText input = (EditText) findViewById(R.id.InputEditText);
        Button enterButton = (Button) findViewById(R.id.eventStart);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> anagrams = new ArrayList<String>();
                ArrayList<String> words = new ArrayList<String>();
                String word = input.getText().toString();
                try {
                    InputStream is = getAssets().open("words.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line = br.readLine();
                    while(line != null)
                    {
                        words.add(line);
                        line = br.readLine();
                    }
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                anagrams = obj.trim(obj.clearList(obj.genLetters(word), words), word);
                Intent intent = new Intent(MainActivity.this, DisplayWordsActivity.class);
                intent.putExtra("anagram list", anagrams);
                startActivity(intent);
            }
        });

    }
}