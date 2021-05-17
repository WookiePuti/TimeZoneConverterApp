package com.puton.timezoneconverterapp.service;

import com.puton.timezoneconverterapp.dao.CityTimeDAO;
import com.puton.timezoneconverterapp.model.City;
import com.puton.timezoneconverterapp.model.CityTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimeZoneService {
    private final CityTimeDAO citiesData;
    private final DateTime dateTime;

    @Autowired
    public TimeZoneService(CityTimeDAO citiesData, DateTime dateTime) {
        this.citiesData = citiesData;
        this.dateTime = dateTime;
    }

    public Optional<CityTime> getActualTimeInCity(String name) {

        Optional<City> city = citiesData.getCityByName(name);
        return city.map(value -> new CityTime(name, calculateActualCityTime(value).toString()));
    }

    public List<CityTime> getActualTimesInAllCities() {
        return citiesData.getAllCities().stream()
                .map(city -> new CityTime(city.getName(), calculateActualCityTime(city).toString()))
                .collect(Collectors.toList());
    }

    private ZonedDateTime calculateActualCityTime(City city) {
        return dateTime.getDate(city.getZoneId());
    }
}
