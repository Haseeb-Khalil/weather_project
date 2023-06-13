package com.weather.api.weather_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Forecast(@JsonProperty("location") Location location, @JsonProperty("forecast") ForecastData forecast) {
    public static record Location(@JsonProperty("name") String name) {
    }

    public static record ForecastData(@JsonProperty("forecastday") List<ForecastDay> forecastday) {
        public static record ForecastDay(@JsonProperty("date") String date, @JsonProperty("day") Day day,
                                         @JsonProperty("astro") Day.AstronomyInfo astronomyInfo) {
            public static record Day(@JsonProperty("maxtemp_c") double maxtemp_c,
                                     @JsonProperty("mintemp_c") double mintemp_c,
                                     @JsonProperty("maxwind_mph") double maxwind_mph,
                                     @JsonProperty("avghumidity") double avg_humidity,
                                     @JsonProperty("daily_chance_of_rain") double chance_of_rain,
                                     @JsonProperty("condition") Condition condition) {
                public static record Condition(@JsonProperty("text") String text, @JsonProperty("icon") String image) {
                }

                public static record AstronomyInfo(@JsonProperty("sunrise") String sunrise,
                                                   @JsonProperty("sunset") String sunset) {
                }
            }
        }
    }
}
