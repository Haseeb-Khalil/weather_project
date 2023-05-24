package com.weather.api.weather_project.web;

import com.weather.api.weather_project.entity.Forecast;
import com.weather.api.weather_project.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forecast")
public class ForecastController {
    private final ForecastService forecastService;

    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/{city}/{days}")
    public Forecast getWeatherForecastData(@PathVariable String city, @PathVariable String days) {
        Forecast forecast = forecastService.getWeatherForecastData(city, days);

        // Print the forecast result
        System.out.println("Location: " + forecast.getLocation().getName());
        System.out.println("Forecast:");
        for (Forecast.ForecastDay forecastDay : forecast.getForecast().getForecastday()) {
            System.out.println("Date: " + forecastDay.getDate());
            System.out.println("Max Temp: " + forecastDay.getDay().getMaxtemp_c());
            System.out.println("Min Temp: " + forecastDay.getDay().getMintemp_c());
            System.out.println("Condition: " + forecastDay.getDay().getCondition().getText());
            System.out.println();
        }

        return forecast;
    }
}

