# Weather Project: Spring Boot REST API

A Spring Boot service that consumes the [WeatherAPI.com](https://www.weatherapi.com/) third-party API and exposes clean REST endpoints for current weather and multi-day forecasts by city.

## What this demonstrates

- Building a Spring Boot REST API in Java.
- Consuming a third-party HTTP API with `RestTemplate` and mapping the response onto Java records.
- Reading sensitive configuration (the API key) from environment variables, not hardcoded in source.
- A clean separation between the web layer, business logic and domain entities.

## Tech stack

- Java 17
- Spring Boot 3.0.6
- WeatherAPI.com (free tier)
- Maven

## Project structure

```
src/main/java/com/weather/api/weather_project
├── WeatherProjectApplication.java
├── entity
│   ├── Weather.java       # Java record mapping current-weather JSON
│   └── Forecast.java      # Java record mapping forecast JSON
├── service
│   ├── WeatherService.java
│   └── ForecastService.java
└── web
    ├── WeatherController.java
    └── ForecastController.java
```

## Run it on your machine

### Prerequisites
- Java 17 or newer (`java -version`)
- A free WeatherAPI key from [https://www.weatherapi.com/signup.aspx](https://www.weatherapi.com/signup.aspx)
- No need to install Maven, the project includes the Maven wrapper

### Steps

```bash
# 1. Clone
git clone https://github.com/Haseeb-Khalil/weather_project.git
cd weather_project

# 2. Set your API key (one-off)
export WEATHERAPI_KEY=your_key_here       # macOS / Linux
# setx WEATHERAPI_KEY "your_key_here"     # Windows PowerShell, then restart shell

# 3. Run
./mvnw spring-boot:run
# On Windows:  mvnw.cmd spring-boot:run
```

The app starts on `http://localhost:8080`.

### Try the endpoints

```bash
# Current weather
curl http://localhost:8080/weather/coventry

# 3-day forecast
curl http://localhost:8080/forecast/coventry/3
```

### Run without setting an environment variable

```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments=--weatherapi.key=your_key_here
```

## Why I built this

Practice for consuming external HTTP APIs from Spring Boot, mapping responses to Java records and exposing them through clean REST endpoints. The same pattern shows up day to day at Capgemini on the HMRC Enterprise Integration Services (EIS) programme.
