package com.example.pocJop.Dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SiteNameDto {
    private Long id;
    private String name;


    public SiteNameDto(Long id ,String name) {
        this.name = name;
        this.id = id;
    }
}
