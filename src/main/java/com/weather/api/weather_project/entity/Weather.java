package com.weather.api.weather_project.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Weather(@JsonProperty("location") LocationData location, @JsonProperty("current") CurrentData current) {
    public static record LocationData(@JsonProperty("name") String name) {
    }

    public static record CurrentData(@JsonProperty("temp_c") double temp_c, @JsonProperty("humidity") double humidity,
                                     @JsonProperty("wind_mph") double wind_speed,
                                     @JsonProperty("condition") ConditionData condition) {
        public static record ConditionData(@JsonProperty("text") String text, @JsonProperty("icon") String image) {
        }
    }
}
/**
 * The Weather class is annotated with @JsonIgnoreProperties(ignoreUnknown = true), indicating that any unknown properties encountered during JSON deserialization should be ignored. This allows the class to handle JSON data that may have additional fields not explicitly defined in the class.
 * <p>
 * The class is defined as a record, which automatically generates a constructor and other methods based on the defined fields. It has two fields: location and current, represented by the LocationData and CurrentData classes respectively.
 * <p>
 * The LocationData class is defined as a nested record within the Weather class. It has a single field name, which is annotated with @JsonProperty("name") to indicate that it should be mapped to the corresponding property in the JSON data.
 * <p>
 * The CurrentData class is another nested record within the Weather class. It has two fields: temp_c and condition. The temp_c field represents the temperature in Celsius and is of type double. The condition field is of type ConditionData, representing the weather condition. Both fields are annotated with @JsonProperty to specify the corresponding property names in the JSON data.
 * <p>
 * The ConditionData class is the final nested record within the Weather class. It has a single field text, representing the textual description of the weather condition. The field is annotated with @JsonProperty("text") to indicate its mapping in the JSON data.
 */