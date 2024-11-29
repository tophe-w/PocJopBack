package com.example.pocJop.Dto.eventDtos;

import com.example.pocJop.Dto.siteDtos.SiteNameDto;
import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Models.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventDtoMapper implements UnidirectionalMapper<EventDto, Event> {
    @Override
    public EventDto from(Event input) {
        return EventDto.builder()
                .id(input.getId())
                .name(input.getName())
                .startEvent(input.getStartEvent())
                .endEvent(input.getEndEvent())
                .description(input.getDescription())
                .nbPeopleExpected(input.getNbPeopleExpected())
                .site(SiteNameDto.builder()
                        .id(input.getSite().getId())
                        .name(input.getSite().getName())
                        .build())
                .build();
    }
}
