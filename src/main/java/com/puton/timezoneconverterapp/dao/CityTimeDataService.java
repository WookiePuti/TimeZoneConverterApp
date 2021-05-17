package com.puton.timezoneconverterapp.dao;

import com.puton.timezoneconverterapp.model.City;
import org.springframework.stereotype.Repository;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeCityDAO")
public class CityTimeDataService implements CityTimeDAO {
    private static List<City> acceptableCities = new ArrayList<>(List.of(
       new City("New York", ZoneId.of("America/New_York")),
       new City("London", ZoneId.of("Europe/London")),
       new City("Paris", ZoneId.of("Europe/Paris")),
       new City("Moscow", ZoneId.of("Europe/Moscow")),
       new City("Beijing", ZoneId.of("Asia/Shanghai"))
    ));
    @Override
    public List<City> getAllCities() {
        return acceptableCities;
    }

    @Override
    public Optional<City> getCityByName(String name) {
        return acceptableCities.stream()
                .filter(city -> city.getName().equals(name))
                .findFirst();
    }
}
