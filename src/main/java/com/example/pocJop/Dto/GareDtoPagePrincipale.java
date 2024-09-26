package com.example.pocJop.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GareDtoPagePrincipale {
    private Long id;
    private String name;
    private String code;
    private String region;
    private int nbLieux;

    
}
