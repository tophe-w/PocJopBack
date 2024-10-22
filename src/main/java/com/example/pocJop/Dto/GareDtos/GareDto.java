package com.example.pocJop.Dto.GareDtos;

import java.util.List;

import com.example.pocJop.Dto.LigneDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GareDto {
    private Long id;
    private String name;
    private List<String> lignes;

    public GareDto(Long id, String name, List<String> lignes) {
        this.id = id;
        this.name = name;
        this.lignes = lignes;
    }
}