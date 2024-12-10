package com.example.pocJop.Dto.dateCalendarDtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class DateCalendarDto {
    private Long dateId;
    private LocalDateTime date;
    private String dayName;
    private String dayNameAbbr;
    private int dayOfMonth;
    private String monthName;
    private String monthNameAbbr;
    private String year;
}
