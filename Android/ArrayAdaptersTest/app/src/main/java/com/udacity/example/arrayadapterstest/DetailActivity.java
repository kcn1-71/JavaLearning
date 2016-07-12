package com.udacity.example.arrayadapterstest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView = (TextView) findViewById(R.id.textview);
        Intent intent = getIntent();
        String text = intent.getStringExtra(ListActivity.EXTRA_TEXT);
        textView.setText(text);
    }

}
