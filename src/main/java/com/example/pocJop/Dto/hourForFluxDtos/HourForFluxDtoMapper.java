package com.example.pocJop.Dto.hourForFluxDtos;

import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Models.HourForFlux;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HourForFluxDtoMapper implements UnidirectionalMapper<HourForFluxDto, HourForFlux> {
    @Override
    public HourForFluxDto from(HourForFlux input) {
        return HourForFluxDto.builder()
                .id(input.getId())
                .hour(input.getHour())
                .build();
    }
}
