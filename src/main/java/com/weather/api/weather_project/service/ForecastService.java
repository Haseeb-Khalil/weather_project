package com.weather.api.weather_project.service;

import com.weather.api.weather_project.entity.Forecast;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ForecastService {
    private static final String FORECAST_URL = "https://api.weatherapi.com/v1/forecast.json?key=78936007682e4b1e9c1112312223105&q=%s&days=%s&aqi=no&alerts=no";

    private final RestTemplate restTemplate;

    public ForecastService(Jackson2ObjectMapperBuilder objectMapperBuilder) {
        this.restTemplate = new RestTemplate();
        this.restTemplate.getMessageConverters().add(0, new MappingJackson2HttpMessageConverter(objectMapperBuilder.build()));
    }

    public Forecast getWeatherForecastData(String city, String days) {
        String apiUrl = String.format(FORECAST_URL, city, days);
        return restTemplate.getForObject(apiUrl, Forecast.class);
    }

}

