package com.udacity.example.autocomplittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str[] = {"Arun", "Mathev", "Vishnu", "Vishal", "Arjun",
                "Arul", "Balaji", "Babu", "Boopathy", "Godwin", "Nagaraj"};

        AutoCompleteTextView t1 = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, str);

        t1.setThreshold(1);
        t1.setAdapter(adp);
    }
}
