package com.weather.api.weather_project.service;

import com.weather.api.weather_project.entity.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String WEATHER_URL = "https://api.weatherapi.com/v1/current.json?key=78936007682e4b1e9c1112312223105&q=%s";

    public Weather getWeatherData(String city) {
        String apiUrl = String.format(WEATHER_URL, city);
        RestTemplate restTemplate = new RestTemplate();
        Weather jsonResponse = restTemplate.getForObject(apiUrl, Weather.class);
        return mapToWeatherData(jsonResponse);
    }

    private Weather mapToWeatherData(Weather weatherResponse) {
        Weather weather = new Weather();

        Weather.LocationData location = new Weather.LocationData();
        location.setName(weatherResponse.getLocation().getName());
        weather.setLocation(location);

        Weather.CurrentData current = new Weather.CurrentData();
        current.setTemp_c(weatherResponse.getCurrent().getTemp_c());

        Weather.ConditionData condition = new Weather.ConditionData();
        condition.setText(weatherResponse.getCurrent().getCondition().getText());
        current.setCondition(condition);

        weather.setCurrent(current);

        return weather;
    }
}
