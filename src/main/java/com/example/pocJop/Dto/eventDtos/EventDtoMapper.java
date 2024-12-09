package com.example.pocJop.Dto.eventDtos;

import com.example.pocJop.Dto.categoryDtos.CategoryDto;
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
        CategoryDto categoryDto = input.getCategory() != null ? CategoryDto.builder()
                .id(input.getCategory().getId())
                .name(input.getCategory().getName())
                .build() : null;

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
                .category(categoryDto)
                .build();
    }
}
