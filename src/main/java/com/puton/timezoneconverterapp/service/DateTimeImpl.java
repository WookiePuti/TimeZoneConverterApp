package com.puton.timezoneconverterapp.service;

import org.springframework.stereotype.Repository;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Repository
public class DateTimeImpl implements DateTime {
    @Override
    public ZonedDateTime getDate(ZoneId zoneId) {
        return ZonedDateTime.now(zoneId);
    }
}
