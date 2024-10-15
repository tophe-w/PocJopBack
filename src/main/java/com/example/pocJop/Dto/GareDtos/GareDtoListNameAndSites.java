package com.example.pocJop.Dto.GareDtos;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GareDtoListNameAndSites {
    private Long id;
    private String name;
    private List<String> siteName;
    private List<Long> siteId;
    private List<String> siteTown;
    private int nbSites;

}
