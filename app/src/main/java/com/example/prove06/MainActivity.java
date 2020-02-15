package com.example.prove06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getTemp(View view){

        EditText e = findViewById(R.id.City);
        city = e.getText().toString();
        Log.d("MainActivity", city);
        backgroundTemp temp = new backgroundTemp(this, city);
        Thread thread = new Thread(temp);

        thread.start();
    }

    public void getForcast(View view){
        EditText e = findViewById(R.id.City);
        city = e.getText().toString();
        Log.d("MainActivity", city);
        backgroundForcast forcast = new backgroundForcast(this, city);
        Thread thread = new Thread(forcast);
        thread.start();


    }
}
