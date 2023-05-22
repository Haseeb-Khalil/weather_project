package com.weather.api.weather_project.service;

import com.weather.api.weather_project.entity.WeatherData;
import com.weather.api.weather_project.entity.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String WEATHER_URL = "https://api.weatherapi.com/v1/current.json?key=78936007682e4b1e9c1112312223105&q=%s";

    public WeatherData getWeatherData(String city) {
        String apiUrl = String.format(WEATHER_URL, city);
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse jsonResponse = restTemplate.getForObject(apiUrl, WeatherResponse.class);
        return mapToWeatherData(jsonResponse);
    }

    private WeatherData mapToWeatherData(WeatherResponse weatherResponse) {
        WeatherData weatherData = new WeatherData();

        WeatherData.LocationData location = new WeatherData.LocationData();
        location.setName(weatherResponse.getLocation().getName());
        weatherData.setLocation(location);

        WeatherData.CurrentData current = new WeatherData.CurrentData();
        current.setTemp_c(weatherResponse.getCurrent().getTemp_c());

        WeatherData.ConditionData condition = new WeatherData.ConditionData();
        condition.setText(weatherResponse.getCurrent().getCondition().getText());
        current.setCondition(condition);

        weatherData.setCurrent(current);

        return weatherData;
    }
}
