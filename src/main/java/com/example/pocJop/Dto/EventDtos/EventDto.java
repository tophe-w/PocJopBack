package com.example.pocJop.Dto.EventDtos;
import java.time.LocalDateTime;

import java.util.List;

import com.example.pocJop.Dto.SiteNameDto;
import com.example.pocJop.Dto.GareDtos.GareDto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@RequiredArgsConstructor
@Getter
@Setter
public class EventDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startEvent;
    private LocalDateTime endEvent;
    private String description;
    private int nbPeopleExpected;
    private List<GareDto> gares;
    private SiteNameDto site;

    public EventDto(Long id, String name, LocalDateTime startEvent, LocalDateTime endEvent, String description, int nbPeopleExpected, List<GareDto> gares,SiteNameDto site) {
        this.id = id;
        this.name = name;
        this.startEvent = startEvent;
        this.endEvent = endEvent;
        this.description = description;
        this.nbPeopleExpected = nbPeopleExpected;
        this.gares = gares;
        this.site = site;
    }

}