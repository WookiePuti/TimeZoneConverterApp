package com.puton.timezoneconverterapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZoneId;

@Data
@AllArgsConstructor
public class City {
    private String name;
    ZoneId zoneId;
}
