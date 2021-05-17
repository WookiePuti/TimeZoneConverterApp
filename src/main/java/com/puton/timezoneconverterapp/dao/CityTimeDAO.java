package com.puton.timezoneconverterapp.dao;

import com.puton.timezoneconverterapp.model.City;

import java.util.List;
import java.util.Optional;

public interface CityTimeDAO {
    List<City> getAllCities();
    Optional<City> getCityByName(String name);

}
