package com.example.pocJop.Dto.dateHourForFluxDtos;

import com.example.pocJop.Dto.calendarDateforFluxDtos.CalendarDateForFluxDto;
import com.example.pocJop.Dto.hourForFluxDtos.HourForFluxDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DateHourForFluxDto {
    private Long id;
    private CalendarDateForFluxDto calendarDateForFlux;
    private HourForFluxDto hourForFlux;
}
