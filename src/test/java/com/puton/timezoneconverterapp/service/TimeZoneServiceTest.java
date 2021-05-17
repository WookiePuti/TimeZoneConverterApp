package com.puton.timezoneconverterapp.service;

import com.puton.timezoneconverterapp.dao.CityTimeDAO;
import com.puton.timezoneconverterapp.model.City;
import com.puton.timezoneconverterapp.model.CityTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TimeZoneServiceTest {
    public static final ZonedDateTime newYorkZonedDateTime = ZonedDateTime.of(1000, 12, 12, 12,
            12, 12, 1, ZoneId.of("America/New_York"));
    public static final ZonedDateTime londonZonedDateTime = ZonedDateTime.of(2000, 12, 12, 12,
            12, 12, 1, ZoneId.of("Europe/London"));
    private TimeZoneService sut;

    @BeforeEach
    void setUp() {
        final CityTimeDAO cityTimeDAO = Mockito.mock(CityTimeDAO.class);
        Mockito.when(cityTimeDAO.getAllCities()).thenReturn(new ArrayList<>(List.of(
                new City("New York", ZoneId.of("America/New_York")),
                new City("London", ZoneId.of("Europe/London"))
        )));

        Mockito.when(cityTimeDAO.getCityByName("London")).thenReturn(
                Optional.of(new City("London", ZoneId.of("Europe/London")))
        );

        Mockito.when(cityTimeDAO.getCityByName("Warsaw")).thenReturn(
                Optional.empty()
        );

        final DateTime dateTime = Mockito.mock(DateTime.class);
        Mockito.when(dateTime.getDate(ZoneId.of("America/New_York"))).thenReturn(
                newYorkZonedDateTime
        );
        Mockito.when(dateTime.getDate(ZoneId.of("Europe/London"))).thenReturn(
                londonZonedDateTime
        );

        sut = new TimeZoneService(cityTimeDAO, dateTime);
    }

    @Test
    void getActualTimeInCity_shouldReturnProperCityTime_whenCityNameIsInDAO() {
        var cityName = "London";
        var result = sut.getActualTimeInCity(cityName);

        var expected = new CityTime(cityName, londonZonedDateTime.toString());

        assertTrue(result.isPresent());
        assertEquals(expected, result.get());

    }

    @Test
    void getActualTimeInCity_shouldReturnEmptyOptional_whenCityNameIsNotInDAO() {
        var cityName = "Warsaw";
        var result = sut.getActualTimeInCity(cityName);

        assertTrue(result.isEmpty());

    }

    @Test
    void getActualTimesInAllCities_shouldReturnProperCityTimes() {
        var result = sut.getActualTimesInAllCities();

        var expected = new ArrayList<>(List.of(
                new CityTime("New York", newYorkZonedDateTime.toString()),
                new CityTime("London", londonZonedDateTime.toString())
        ));

        assertEquals(expected, result);

    }

}