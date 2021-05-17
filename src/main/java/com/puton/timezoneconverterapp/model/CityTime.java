package com.puton.timezoneconverterapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CityTime {
    private String name;
    private String actualTime;

    public CityTime(@JsonProperty("name") String name,
                    @JsonProperty("time") String actualTime) {
        this.name = name;
        this.actualTime = actualTime;
    }
}
