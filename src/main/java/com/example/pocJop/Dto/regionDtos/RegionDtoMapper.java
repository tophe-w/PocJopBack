package com.example.pocJop.Dto.regionDtos;

import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Models.Region;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegionDtoMapper implements UnidirectionalMapper<RegionDto, Region> {
    @Override
    public RegionDto from(Region input) {

        return RegionDto.builder()
                .id(input.getId())
                .name(input.getName())
                .nbGares(input.getGares().size())
                .nbLieux(input.getGares().stream().map(gare -> gare.getSites().size()).reduce(0, Integer::sum))
                .build();
    }
}
