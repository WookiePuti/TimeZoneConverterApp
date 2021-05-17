package com.puton.timezoneconverterapp.service;


import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface DateTime {
    ZonedDateTime getDate(ZoneId zoneId);
}
