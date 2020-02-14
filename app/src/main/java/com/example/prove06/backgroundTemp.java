package com.example.prove06;

import com.google.gson.Gson;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backgroundTemp implements Runnable{
    private Activity activity;
    private String city;

    public backgroundTemp(Activity activity, String city) {
        this.activity = activity;
        this.city = city;
    }

    @Override
    public void run() {
        Log.d("PROVE06","GETTING TEMP");
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HTTpHelper http = new HTTpHelper();

        String result = http.readHTTP("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=imperial&APPID=36e0c7fe4753e22a66e3418e84c7f1b9");
        final WeatherForecastItems weather = gson.fromJson(result, WeatherForecastItems.class);

        Log.d("TEMP","Current Temp: " + weather.getMain());

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "Current Temperature: " + weather.getMain(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
