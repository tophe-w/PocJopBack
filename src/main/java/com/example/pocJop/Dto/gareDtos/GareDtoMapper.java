package com.example.pocJop.Dto.gareDtos;

import com.example.pocJop.Dto.affluenceDtos.AffluenceDto;
import com.example.pocJop.Dto.ligneDtos.LigneDto;
import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Models.Gare;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Component
public class GareDtoMapper implements UnidirectionalMapper<GareDto, Gare> {

        @Override
        public GareDto from(Gare input) {
            return GareDto.builder()
                    .id(input.getId())
                    .name(input.getName())
                    .lignes(input.getLignes().stream().map(ligne -> LigneDto.builder().id(ligne.getId()).name(ligne.getName()).build()).collect(Collectors.toList()))
                    .affluences(input.getAffluences().stream().map(affluence -> AffluenceDto.builder()
                            .id(affluence.getId())
                            .affluenceHabituelleDown(affluence.getAffluenceHabituelleDown())
                            .affluenceHabituelleUp(affluence.getAffluenceHabituelleUp())
                            .estimationUp(affluence.getEstimationUp())
                            .estimationDown(affluence.getEstimationDown())
                            .build()).collect(Collectors.toList()))
                    .code(input.getCode())
                    .planDeGare(input.getPlanDeGare())
                    .planDeGareSvg(input.getPlanDeGareSvg())
                    .accessibilite(input.getAccessibilite())
                    .build();
        }
}
