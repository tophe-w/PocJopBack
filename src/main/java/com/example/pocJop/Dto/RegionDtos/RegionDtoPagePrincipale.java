package com.example.pocJop.Dto.RegionDtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RegionDtoPagePrincipale {
    private Long id;
    private String name;
    private int nbGares;
    private int nbLieux;
    
}
