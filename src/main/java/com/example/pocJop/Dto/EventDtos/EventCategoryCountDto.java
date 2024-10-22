package com.example.pocJop.Dto.EventDtos;


import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EventCategoryCountDto {
    private String category;
    private int count;
    private List<EventDto> events;
    
   
    public EventCategoryCountDto(String category, int count, List<EventDto> events) {
        this.category = category;
        this.count = count;
        this.events = events;
       
    }

 
}
