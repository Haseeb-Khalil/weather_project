package com.weather.api.weather_project.service;

import com.weather.api.weather_project.entity.Forecast;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ForecastService {
    /**
     * The ForecastService class is a service component responsible for retrieving weather forecast data from an external API. It uses Spring's RestTemplate to make HTTP requests and deserialize the JSON response into a Forecast object.
     * The Jackson2ObjectMapperBuilder is used to configure the object mapper for JSON serialization and deserialization.
     */
    private static final String FORECAST_URL = "https://api.weatherapi.com/v1/forecast.json?key=78936007682e4b1e9c1112312223105&q=%s&days=%s&aqi=no&alerts=no";
    /**
     * The %s placeholders in the URL are replaced with the city and days parameters provided when calling the getWeatherForecastData method.
     */
    private final RestTemplate restTemplate;

    /**
     * public ForecastService(Jackson2ObjectMapperBuilder objectMapperBuilder)
     * Initializes a new instance of the ForecastService class with the provided Jackson2ObjectMapperBuilder. It sets up the RestTemplate and configures the message converters for JSON serialization and deserialization.
     */
    public ForecastService(Jackson2ObjectMapperBuilder objectMapperBuilder) {
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
     * The getWeatherForecastData method is responsible for retrieving weather forecast data for a specific city and number of days from an API.
     * String apiUrl = String.format(FORECAST_URL, city, days);: This line creates the API URL by formatting the FORECAST_URL string with the provided city and days values. The FORECAST_URL is a constant string that represents the base URL of the weather forecast API.
     * return restTemplate.getForObject(apiUrl, Forecast.class);: This line sends a GET request to the specified API URL using the RestTemplate instance. It expects the API response to be in JSON format and automatically converts the JSON response into a Forecast object based on the provided Forecast.class parameter. The getForObject method performs the HTTP request and returns the deserialized response as an instance of the Forecast class
     */

    public Forecast getWeatherForecastData(String city, String days) {
        String apiUrl = String.format(FORECAST_URL, city, days);
        return restTemplate.getForObject(apiUrl, Forecast.class);
    }

}

