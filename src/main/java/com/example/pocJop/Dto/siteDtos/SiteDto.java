package com.example.pocJop.Dto.siteDtos;

import com.example.pocJop.Dto.eventDtos.EventDto;
import com.example.pocJop.Dto.gareDtos.GareDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class SiteDto {
    private Long id;
    private String name;
    private String town;
    private String description;
    private int capacity;
    private String photo;
    private String planDeSite;
    private String address;
    private List<GareDto> gares;
    private List<EventDto> events;

}
