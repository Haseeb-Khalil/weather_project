package com.weather.api.weather_project.service;

import com.weather.api.weather_project.entity.Forecast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ForecastService {

    private static final String FORECAST_URL =
            "https://api.weatherapi.com/v1/forecast.json?key=%s&q=%s&days=%s&aqi=no&alerts=no";

    private final RestTemplate restTemplate;
    private final String apiKey;

    public ForecastService(Jackson2ObjectMapperBuilder objectMapperBuilder,
                           @Value("${weatherapi.key:}") String apiKey) {
        this.restTemplate = new RestTemplate();
        this.restTemplate.getMessageConverters()
                .add(0, new MappingJackson2HttpMessageConverter(objectMapperBuilder.build()));
        this.apiKey = apiKey;
    }

    public Forecast getWeatherForecastData(String city, String days) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "WeatherAPI key not configured. Set WEATHERAPI_KEY environment variable or weatherapi.key property.");
        }
        String apiUrl = String.format(FORECAST_URL, apiKey, city, days);
        return restTemplate.getForObject(apiUrl, Forecast.class);
    }
}
