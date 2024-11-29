package com.example.pocJop.Dto.affluenceDtos;

import com.example.pocJop.Dto.UnidirectionalMapper;
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
                .build();
    }
}
