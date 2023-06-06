package com.weather.api.weather_project.web;

import com.weather.api.weather_project.entity.Weather;
import com.weather.api.weather_project.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    public ModelAndView getWeather(@PathVariable String city) {
        Weather weather = weatherService.getWeatherData(city);
        ModelAndView modelAndView = new ModelAndView("weather");
        modelAndView.addObject("weather", weather);
        return modelAndView;
    }
}


