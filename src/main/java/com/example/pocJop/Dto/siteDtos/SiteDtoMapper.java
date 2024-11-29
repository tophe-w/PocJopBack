package com.example.pocJop.Dto.siteDtos;
import com.example.pocJop.Dto.eventDtos.EventDto;
import com.example.pocJop.Dto.gareDtos.GareDto;
import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Models.Site;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SiteDtoMapper implements UnidirectionalMapper<SiteDto, Site> {
    @Override
    public SiteDto from(Site input) {
        return SiteDto.builder()
                .photo(input.getPhoto())
                .name(input.getName())
                .town(input.getTown())
                .description(input.getDescription())
                .capacity(input.getCapacity())
                .planDeSite(input.getPlanDeSite())
                .address(input.getAddress())
                .id(input.getId())
                .gares(input.getGares().stream().map(gare -> GareDto.builder()
                        .id(gare.getId())
                        .name(gare.getName())
                        .build()).toList())
                .events(input.getEvents().stream().map(event -> EventDto.builder()
                        .id(event.getId())
                        .name(event.getName())
                        .startEvent(event.getStartEvent())
                        .endEvent(event.getEndEvent())
                        .description(event.getDescription())
                        .nbPeopleExpected(event.getNbPeopleExpected())
                        .build()).toList())
                .build();
    }
}
