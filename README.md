## TimeZoneConverterApp

### Spring Boot Web app which allows to obtain the actual time data in several places around the world.

### Available endpoints:
* GET /app/time - return a Json response with all available cities and corresponding times
* GET /app/time/{cityName} return a Json response with the time in city, which name is equal to the cityName path variable.
If there is no such a city, the null response is returned.
  
Available cityName paths:
London, Beijing, New York, Moscow, Paris