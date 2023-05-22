package com.weather.api.weather_project.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherData {
    private LocationData location;
    private CurrentData current;

    // Getters and setters


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

    public static class LocationData {
        private String name;

        // Getters and setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class CurrentData {
        private double temp_c;
        private ConditionData condition;

        // Getters and setters

        public double getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(double temp_c) {
            this.temp_c = temp_c;
        }

        public ConditionData getCondition() {
            return condition;
        }

        public void setCondition(ConditionData condition) {
            this.condition = condition;
        }
    }

    public static class ConditionData {
        private String text;

        // Getters and setters

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
    
}