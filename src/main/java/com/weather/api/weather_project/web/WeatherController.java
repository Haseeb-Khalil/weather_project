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
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public WeatherData getWeather(@PathVariable String city) {
        WeatherData weatherData = weatherService.getWeatherData(city);
        System.out.println("City: " + weatherData.getLocation().getName());
        System.out.println("Temperature: " + weatherData.getCurrent().getTemp_c());
        System.out.println("Description: " + weatherData.getCurrent().getCondition().getText());
        return weatherData;
    }
}
