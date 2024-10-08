package com.example.pocJop.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SiteDto {
    private Long id;
    private String name;
    private String town;
    private String description;
    private int capacity;
    private String photo;
    private String planDeSite;
    private String address;
}
