package com.weather.api.weather_project.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Weather(@JsonProperty("location") LocationData location, @JsonProperty("current") CurrentData current) {
    public static record LocationData(@JsonProperty("name") String name) {
    }

    public static record CurrentData(@JsonProperty("temp_c") double temp_c,
                                     @JsonProperty("condition") ConditionData condition) {
        public static record ConditionData(@JsonProperty("text") String text) {
        }
    }
}