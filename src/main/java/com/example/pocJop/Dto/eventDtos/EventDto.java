package com.example.pocJop.Dto.eventDtos;

import java.time.LocalDateTime;

import com.example.pocJop.Dto.categoryDtos.CategoryDto;
import com.example.pocJop.Dto.siteDtos.SiteNameDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class EventDto {

    private Long id;
    private String name;
    private LocalDateTime startEvent;
    private LocalDateTime endEvent;
    private String description;
    private int nbPeopleExpected;
    private SiteNameDto site;
    private CategoryDto category;

}