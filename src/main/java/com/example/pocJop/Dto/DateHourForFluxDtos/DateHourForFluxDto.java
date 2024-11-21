package com.example.pocJop.Dto.DateHourForFluxDtos;

import com.example.pocJop.Dto.CalendarDateforFluxDtos.CalendarDateForFluxDto;
import com.example.pocJop.Dto.HourForFluxDtos.HourForFluxDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DateHourForFluxDto {
    private Long id;
    private CalendarDateForFluxDto calendarDateForFlux;
    private HourForFluxDto hourForFlux;
}
