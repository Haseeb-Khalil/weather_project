# Weather Project: Spring Boot REST API

A Spring Boot service that consumes the OpenWeatherMap API and exposes clean REST endpoints for current weather and multi-day forecasts by city.

## What this demonstrates

- Building a Spring Boot REST API in Java.
- Consuming a third-party HTTP API and mapping the response onto domain entities.
- A clear separation between web layer (`controller`), business logic (`service`) and domain (`entity`).
- Configuration through `application.properties`.

## Tech stack

- Java + Spring Boot
- Maven
- OpenWeatherMap API

## Project structure

```
src/main/java/com/weather/api/weather_project
├── WeatherProjectApplication.java
├── entity
│   ├── Weather.java
│   └── Forecast.java
├── service
│   ├── WeatherService.java
│   └── ForecastService.java
└── web
    ├── WeatherController.java
    └── ForecastController.java
```

## REST endpoints

| Method | Path | Purpose |
| --- | --- | --- |
| GET | `/weather/{city}` | Current weather for a given city |
| GET | `/forecast/{city}/{days}` | Forecast for a given city across N days |

Examples:

```
http://localhost:8080/weather/coventry
http://localhost:8080/forecast/coventry/3
```

## Running it locally

```bash
# Clone
git clone https://github.com/Haseeb-Khalil/weather_project.git
cd weather_project

# Add your OpenWeatherMap API key in src/main/resources/application.properties

# Run
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080`.

## Why I built this

Practice for consuming external HTTP APIs from Spring Boot, mapping responses to entities and exposing them through clean REST endpoints, the pattern I use at Capgemini on the HMRC Enterprise Integration Services (EIS) programme.
