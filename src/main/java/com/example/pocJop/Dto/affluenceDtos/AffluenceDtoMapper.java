package com.example.pocJop.Dto.affluenceDtos;

import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Dto.dateCalendarDtos.DateCalendarDtoMapper;
import com.example.pocJop.Dto.gareDtos.GareDtoMapper;
import com.example.pocJop.Models.Affluence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AffluenceDtoMapper implements UnidirectionalMapper<AffluenceDto, Affluence> {
    @Override
    public AffluenceDto from(Affluence input) {
        return AffluenceDto.builder()
                .id(input.getId())
                .estimationUp(input.getEstimationUp())
                .estimationDown(input.getEstimationDown())
                .affluenceHabituelleUp(input.getAffluenceHabituelleUp())
                .affluenceHabituelleDown(input.getAffluenceHabituelleDown())
                .gare(input.getGare() != null ? new GareDtoMapper().from(input.getGare()) : null)
                .dateCalendar(input.getDateCalendar() != null ? new DateCalendarDtoMapper().from(input.getDateCalendar()) : null)
                .build();
    }
}
