package com.weather.api.weather_project.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Forecast {
    private Location location;
    private ForecastData forecast;

    // Getters and setters

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ForecastData getForecast() {
        return forecast;
    }

    public void setForecast(ForecastData forecast) {
        this.forecast = forecast;
    }

    public static class Location {
        private String name;
        // Other fields, getters, and setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ForecastData {
        private List<ForecastDay> forecastday;
        // Other fields, getters, and setters

        public List<ForecastDay> getForecastday() {
            return forecastday;
        }

        public void setForecastday(List<ForecastDay> forecastday) {
            this.forecastday = forecastday;
        }
    }

    public static class ForecastDay {
        private String date;
        private Day day;
        // Other fields, getters, and setters

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }
    }

    public static class Day {
        private double maxtemp_c;
        private double mintemp_c;
        private Condition condition;
        // Other fields, getters, and setters

        public double getMaxtemp_c() {
            return maxtemp_c;
        }

        public void setMaxtemp_c(double maxtemp_c) {
            this.maxtemp_c = maxtemp_c;
        }

        public double getMintemp_c() {
            return mintemp_c;
        }

        public void setMintemp_c(double mintemp_c) {
            this.mintemp_c = mintemp_c;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }
    }

    public static class Condition {
        private String text;
        // Other fields, getters, and setters

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}



