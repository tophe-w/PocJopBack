package com.example.pocJop.Dto.GareDtos;



import java.util.List;

import com.example.pocJop.Dto.SiteDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GareDtoSelectedGare {
    private Long id;
    private String name;
    private String planDeGare;
    private String planDeGareSvg;
    private List<SiteDto> sites;
    
}
