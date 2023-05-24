package com.weather.api.weather_project.web;

import com.weather.api.weather_project.entity.Weather;
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
    public Weather getWeather(@PathVariable String city) {
        Weather weather = weatherService.getWeatherData(city);
        System.out.println("City: " + weather.getLocation().getName());
        System.out.println("Temperature: " + weather.getCurrent().getTemp_c());
        System.out.println("Description: " + weather.getCurrent().getCondition().getText());
        return weather;
    }
}
