package com.weather.api.weather_project.web;

import com.weather.api.weather_project.entity.WeatherData;
import com.weather.api.weather_project.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class Controller {
    private final WeatherService weatherService;

    @Autowired
    public Controller(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public WeatherData getWeather(@PathVariable String city) {
        return weatherService.getWeatherData(city);
    }
}
