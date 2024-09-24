package com.example.pocJop.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GareDto {
    private Long id;
    private String name;
    private String code;
    private String idGareIdfm;
    private String planDeGare;
    private String planDeGareSvg;
    private String accessibilite;
    
}
