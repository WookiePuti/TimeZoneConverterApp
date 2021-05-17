package com.puton.timezoneconverterapp.api;

import com.puton.timezoneconverterapp.model.CityTime;
import com.puton.timezoneconverterapp.service.TimeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("app/time")
@RestController
public class TimeCityController {
    private final TimeZoneService timeZoneService;

    @Autowired
    public TimeCityController(TimeZoneService timeZoneService) {
        this.timeZoneService = timeZoneService;
    }

    @GetMapping()
    public List<CityTime> getTimesInAllCities() {
        return timeZoneService.getActualTimesInAllCities();
    }

    @GetMapping(path = "{cityName}")
    public CityTime getTimeInCityByName(@PathVariable String cityName){
        return timeZoneService.getActualTimeInCity(cityName).orElse(null);
    }
}
