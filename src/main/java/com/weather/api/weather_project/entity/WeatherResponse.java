package com.weather.api.weather_project.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeatherResponse {
    private LocationData location;
    private CurrentData current;

    public LocationData getLocation() {
        return location;
    }

    public void setLocation(LocationData location) {
        this.location = location;
    }

    public CurrentData getCurrent() {
        return current;
    }

    public void setCurrent(CurrentData current) {
        this.current = current;
    }


}
