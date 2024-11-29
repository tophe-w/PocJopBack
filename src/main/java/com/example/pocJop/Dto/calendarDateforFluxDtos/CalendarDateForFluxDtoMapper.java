package com.example.pocJop.Dto.calendarDateforFluxDtos;

import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Models.CalendarDateForFlux;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CalendarDateForFluxDtoMapper implements UnidirectionalMapper<CalendarDateForFluxDto, CalendarDateForFlux> {
    @Override
    public CalendarDateForFluxDto from(CalendarDateForFlux input) {
        return CalendarDateForFluxDto.builder()
                .id(input.getId())
                .date(input.getDate())
                .build();
    }
}
