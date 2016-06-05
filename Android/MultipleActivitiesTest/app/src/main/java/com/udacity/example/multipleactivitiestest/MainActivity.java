package com.udacity.example.multipleactivitiestest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static String VALUE = "myValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNewActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(VALUE, "My bla-bla-bla string");
        startActivity(intent);
    }
}
