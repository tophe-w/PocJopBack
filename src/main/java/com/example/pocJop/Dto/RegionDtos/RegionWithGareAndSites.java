package com.example.pocJop.Dto.RegionDtos;

import java.util.List;

import com.example.pocJop.Dto.GareDtos.GareDtoListNameAndSites;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RegionWithGareAndSites {
    private Long id;
    private String name;
    private List<GareDtoListNameAndSites> gares;
    
}
