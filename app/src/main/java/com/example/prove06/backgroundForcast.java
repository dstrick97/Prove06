package com.example.prove06;

import android.app.Activity;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class backgroundForcast implements Runnable {
    private Activity activity;
    private String city;

    public backgroundForcast(Activity activity, String city) {
        this.activity = activity;
        this.city = city;
    }

    @Override
    public void run() {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HTTpHelper http = new HTTpHelper();

        String result = http.readHTTP("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&units=imperial&APPID=36e0c7fe4753e22a66e3418e84c7f1b9");
        WeatherForecasts weather = gson.fromJson(result, WeatherForecasts.class);
        ArrayList<String> weatherList = new ArrayList<>();

        for (WeatherForecastItems i : weather.getList()){
            String temp =
            "Date and Time: " + i.getDt_txt() +
            "Temperature: "+ i.getMain() +
            "Weather Conditions: "+ i.getWeather() +
            "Wind Speed: "+ i.getWind();

            weatherList.add(temp);
        }

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, );

    }
}
