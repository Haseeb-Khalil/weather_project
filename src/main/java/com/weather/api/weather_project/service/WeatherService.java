package com.weather.api.weather_project.service;

import com.weather.api.weather_project.entity.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String WEATHER_URL =
            "https://api.weatherapi.com/v1/current.json?key=%s&q=%s";

    private final RestTemplate restTemplate;
    private final String apiKey;

    public WeatherService(Jackson2ObjectMapperBuilder objectMapperBuilder,
                          @Value("${weatherapi.key:}") String apiKey) {
        this.restTemplate = new RestTemplate();
        this.restTemplate.getMessageConverters()
                .add(0, new MappingJackson2HttpMessageConverter(objectMapperBuilder.build()));
        this.apiKey = apiKey;
    }

    public Weather getWeatherData(String city) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "WeatherAPI key not configured. Set WEATHERAPI_KEY environment variable or weatherapi.key property.");
        }
        String apiUrl = String.format(WEATHER_URL, apiKey, city);
        return restTemplate.getForObject(apiUrl, Weather.class);
    }
}
