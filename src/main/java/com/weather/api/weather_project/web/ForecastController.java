package com.weather.api.weather_project.web;

import com.weather.api.weather_project.entity.Forecast;
import com.weather.api.weather_project.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/forecast")
public class ForecastController {
    private final ForecastService forecastService;

    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/{city}/{days}")
    public ModelAndView getWeatherForecastData(@PathVariable String city, @PathVariable String days) {
        Forecast forecast = forecastService.getWeatherForecastData(city, days);

        ModelAndView modelAndView = new ModelAndView("forecast");
        modelAndView.addObject("location", forecast.location().name());
        modelAndView.addObject("forecast", forecast.forecast().forecastday());

        return modelAndView;
    }
}




