package com.weather.api.weather_project.service;

import com.weather.api.weather_project.entity.Weather;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String WEATHER_URL = "https://api.weatherapi.com/v1/current.json?key=78936007682e4b1e9c1112312223105&q=%s";

    private final RestTemplate restTemplate;

    public WeatherService(Jackson2ObjectMapperBuilder objectMapperBuilder) {
        this.restTemplate = new RestTemplate();
        this.restTemplate.getMessageConverters().add(0, new MappingJackson2HttpMessageConverter(objectMapperBuilder.build()));
    }

    public Weather getWeatherData(String city) {
        String apiUrl = String.format(WEATHER_URL, city);
        return restTemplate.getForObject(apiUrl, Weather.class);
    }

}
