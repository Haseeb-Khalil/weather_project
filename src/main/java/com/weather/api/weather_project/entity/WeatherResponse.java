package com.weather.api.weather_project.entity;

public class WeatherResponse {
    private WeatherData.LocationData location;
    private WeatherData.CurrentData current;

    // Getters and setters

    public WeatherData.LocationData getLocation() {
        return location;
    }

    public void setLocation(WeatherData.LocationData location) {
        this.location = location;
    }

    public WeatherData.CurrentData getCurrent() {
        return current;
    }

    public void setCurrent(WeatherData.CurrentData current) {
        this.current = current;
    }
}

