package com.example.pocJop.Dto;


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
    
   
    public EventCategoryCountDto(String category, int count ) {
        this.category = category;
        this.count = count;

       
    }

 
}
