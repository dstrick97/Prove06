package com.example.prove06;

import java.util.List;
import java.util.Map;

public class WeatherForecastItems {

    Map<String, Float> main;
    List<WeatherConditions> weather;
    WindSpeed wind;
    String dt_txt;

    public String getDt_txt() {
        return dt_txt;
    }

    public Float getMain() {
        return main.get("temp");
    }

    public Float getWind() {
        return wind.getSpeed();
    }

    public String getWeather(){
        String conditions = weather.get(0).getDescription();
        return conditions;
    }

}