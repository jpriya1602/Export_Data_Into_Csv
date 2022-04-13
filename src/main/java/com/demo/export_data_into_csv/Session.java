package com.demo.export_data_into_csv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Session {
    private String name;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
}
