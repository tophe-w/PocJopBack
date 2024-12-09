package com.example.pocJop.Dto.affluenceDtos;

import com.example.pocJop.Dto.dateCalendarDtos.DateCalendarDto;
import com.example.pocJop.Dto.gareDtos.GareDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class AffluenceDto {
    private Long id;
    private int estimationUp;
    private int estimationDown;
    private int affluenceHabituelleUp;
    private int affluenceHabituelleDown;
    private GareDto gare;
    private DateCalendarDto dateCalendar;
}
