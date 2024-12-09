package com.example.pocJop.Dto.gareDtos;

import com.example.pocJop.Dto.categoryDtos.CategoryDto;
import com.example.pocJop.Dto.eventDtos.EventDto;
import com.example.pocJop.Dto.ligneDtos.LigneDto;
import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Dto.regionDtos.RegionDto;
import com.example.pocJop.Dto.siteDtos.SiteDto;
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
                    .code(input.getCode())
                    .region(RegionDto.builder()
                            .id(input.getRegion().getId())
                            .name(input.getRegion().getName())
                            .build())
                    .planDeGare(input.getPlanDeGare())
                    .planDeGareSvg(input.getPlanDeGareSvg())
                    .accessibilite(input.getAccessibilite())
                    .sites((input.getSites() != null && !input.getSites().isEmpty()) ? input.getSites().stream().map(site -> SiteDto.builder()
                            .id(site.getId())
                            .name(site.getName())
                            .town(site.getTown())
                            .description(site.getDescription())
                            .capacity(site.getCapacity())
                            .photo(site.getPhoto())
                            .planDeSite(site.getPlanDeSite())
                            .address(site.getAddress())
                            .events(site.getEvents() != null ? site.getEvents().stream().map(event -> EventDto.builder()
                                    .id(event.getId())
                                    .name(event.getName())
                                    .startEvent(event.getStartEvent())
                                    .endEvent(event.getEndEvent())
                                    .description(event.getDescription())
                                    .nbPeopleExpected(event.getNbPeopleExpected())
                                    .category(event.getCategory() != null ? CategoryDto.builder()
                                            .id(event.getCategory().getId())
                                            .name(event.getCategory().getName())
                                            .build() : null)
                                    .build()).collect(Collectors.toList()):null)
                            .build()).collect(Collectors.toList()): null)
                    .build();
        }
}
