package com.udacity.example.arraystest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] myArray = {10, 20, 30, 40, 50};
            Log.v("Log example", Arrays.toString(myArray));
    }
}
