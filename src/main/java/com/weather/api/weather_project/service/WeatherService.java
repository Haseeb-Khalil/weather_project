package com.weather.api.weather_project.service;

import com.weather.api.weather_project.entity.Weather;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String WEATHER_URL = "https://api.weatherapi.com/v1/current.json?key=78936007682e4b1e9c1112312223105&q=%s";

    private final RestTemplate restTemplate;
    /**
     * public WeatherService(Jackson2ObjectMapperBuilder objectMapperBuilder)
     * Initializes a new instance of the WeatherService class with the provided Jackson2ObjectMapperBuilder. It sets up the RestTemplate and configures the message converters for JSON serialization and deserialization.
     */
    public WeatherService(Jackson2ObjectMapperBuilder objectMapperBuilder) {
        this.restTemplate = new RestTemplate();
        this.restTemplate.getMessageConverters().add(0, new MappingJackson2HttpMessageConverter(objectMapperBuilder.build()));
        /**
         * this.restTemplate.getMessageConverters().add(0, new MappingJackson2HttpMessageConverter(objectMapperBuilder.build()));: This line configures the RestTemplate to use a custom MappingJackson2HttpMessageConverter for JSON serialization and deserialization.
         * this.restTemplate.getMessageConverters() retrieves the list of message converters configured for the RestTemplate.
         * add(0, new MappingJackson2HttpMessageConverter(objectMapperBuilder.build())) adds a new MappingJackson2HttpMessageConverter at the beginning of the list.
         * The objectMapperBuilder.build() method is called to create an instance of ObjectMapper from the provided Jackson2ObjectMapperBuilder.
         */
    }

    /**
     * The getWeatherData method is responsible for retrieving the current weather data for a specific city from an API
     * String apiUrl = String.format(WEATHER_URL, city);: This line creates the API URL by formatting the WEATHER_URL string with the provided city value. The WEATHER_URL is a constant string that represents the base URL of the weather API.
     * return restTemplate.getForObject(apiUrl, Weather.class);: This line sends a GET request to the specified API URL using the RestTemplate instance. It expects the API response to be in JSON format and automatically converts the JSON response into a Weather object based on the provided Weather.class parameter. The getForObject method performs the HTTP request and returns the deserialized response as an instance of the Weather class.
     */


    public Weather getWeatherData(String city) {
        String apiUrl = String.format(WEATHER_URL, city);
        return restTemplate.getForObject(apiUrl, Weather.class);
    }

}
