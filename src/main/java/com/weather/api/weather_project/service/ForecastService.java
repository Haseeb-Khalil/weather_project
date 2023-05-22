package com.weather.api.weather_project.service;

import com.weather.api.weather_project.entity.Forecast;
import org.springframework.web.client.RestTemplate;

public class ForecastService {
    private static final String FORECAST_URL = "https://api.weatherapi.com/v1/forecast.json?key=API_KEY&q=%s&days=%s&aqi=no&alerts=no";
    public Forecast getWeatherForecastData(String city , String days) {
        String apiUrl = String.format(FORECAST_URL, city, days);
        RestTemplate restTemplate = new RestTemplate();
        Forecast weatherForecastData = restTemplate.getForObject(apiUrl, Forecast.class);
        return weatherForecastData;
    }
}
