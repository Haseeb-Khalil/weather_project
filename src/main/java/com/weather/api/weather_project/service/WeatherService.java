package com.weather.api.weather_project.service;

import com.weather.api.weather_project.entity.WeatherData;
import com.weather.api.weather_project.entity.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String WEATHER_URL = "https://api.weatherapi.com/v1/current.json?key=API_KEY&q=%s";

    public WeatherData getWeatherData(String city) {
        String apiUrl = String.format(WEATHER_URL, city);
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject(apiUrl, WeatherResponse.class);
        System.out.println(weatherResponse);
        return mapToWeatherData(weatherResponse);
    }

    private WeatherData mapToWeatherData(WeatherResponse weatherResponse) {
        WeatherData weatherData = new WeatherData();
        weatherData.setCity(weatherResponse.getLocation().getName());
        weatherData.setTemperature(weatherResponse.getCurrent().getTempC());
        weatherData.setDescription(weatherResponse.getCurrent().getCondition().getText());
        return weatherData;
    }
}


