package com.example.pocJop.Services;

import java.util.List;

import com.example.pocJop.Dto.regionDtos.RegionDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pocJop.Dto.regionDtos.RegionDto;
import com.example.pocJop.Models.Region;
import com.example.pocJop.Repository.RegionRepository;

import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegionService {

    private final RegionRepository regionRepository;

    private final RegionDtoMapper regionDtoMapper;


    public List<RegionDto> getAll() {
        List<Region> regions = regionRepository.findAll();

        if (regions.isEmpty()) {
            throw new RuntimeException("There is no region");
        }
        return regions.stream().map(region -> {
            return RegionDto.builder()
                    .id(region.getId())
                    .name(region.getName())
                    .nbGares(region.getGares().size())
                    .nbLieux(region.getGares().stream().map(gare -> gare.getSites().size()).reduce(0, Integer::sum))
                    .build();
        }).toList();

    }

    public RegionDto getRegionById(Long id) {
        return regionRepository.findById(id).map(this.regionDtoMapper::from)
                .orElseThrow(() -> new RuntimeException("Region not found with id: " + id));
    }

    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }



}
