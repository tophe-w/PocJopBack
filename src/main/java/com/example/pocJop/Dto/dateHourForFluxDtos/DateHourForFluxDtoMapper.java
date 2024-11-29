package com.example.pocJop.Dto.dateHourForFluxDtos;

import com.example.pocJop.Dto.calendarDateforFluxDtos.CalendarDateForFluxDtoMapper;
import com.example.pocJop.Dto.hourForFluxDtos.HourForFluxDtoMapper;
import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Models.DateHourForFlux;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DateHourForFluxDtoMapper implements UnidirectionalMapper<DateHourForFluxDto, DateHourForFlux> {
    @Override
    public DateHourForFluxDto from(DateHourForFlux input) {
        return DateHourForFluxDto.builder()
                .id(input.getId())
                .calendarDateForFlux(new CalendarDateForFluxDtoMapper().from(input.getCalendarDateForFlux()))
                .hourForFlux(new HourForFluxDtoMapper().from(input.getHourForFlux()))
                .build();
    }
}
