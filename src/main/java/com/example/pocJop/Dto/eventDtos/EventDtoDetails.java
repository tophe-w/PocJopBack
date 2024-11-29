package com.example.pocJop.Dto.eventDtos;

import java.time.LocalDateTime;

import java.util.List;

import com.example.pocJop.Dto.gareDtos.GareDto;

public class EventDtoDetails {
    private Long id;
    private String name;
    private LocalDateTime startEvent;
    private LocalDateTime endEvent;


    private String siteName;

     private List<GareDto> gares;


    public EventDtoDetails(Long id, String name, LocalDateTime startEvent, LocalDateTime endEvent, String siteName, List<GareDto> gares) {
        this.id = id;
        this.name = name;
        this.startEvent = startEvent;
        this.endEvent = endEvent;
      
        this.siteName = siteName;
        this.gares = gares;
    }


}
