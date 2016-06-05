package com.udacity.example.edittexttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText = (EditText) findViewById(R.id.edittext);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String str = eText.getText().toString();
                Toast msg = Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG);
                msg.show();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar,if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

}
