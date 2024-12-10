package com.example.pocJop.Dto.dateCalendarDtos;

import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Models.DateCalendar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DateCalendarDtoMapper implements UnidirectionalMapper<DateCalendarDto, DateCalendar> {
    @Override
    public DateCalendarDto from(DateCalendar input) {
        return DateCalendarDto.builder()
                .dateId(input.getDateId())
                .date(input.getDate())
                .dayName(input.getDayName())
                .dayNameAbbr(input.getDayNameAbbr())
                .dayOfMonth(input.getDayOfMonth())
                .monthName(input.getMonthName())
                .monthNameAbbr(input.getMonthNameAbbr())
                .year(input.getYear())
                .build();
    }
}