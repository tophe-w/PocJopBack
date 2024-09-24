package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.pocJop.Models.Region;
import com.example.pocJop.Repository.RegionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;



    public List<Region> getAllRegions() {
        List<Region> regions = regionRepository.findAll();
        if (regions.isEmpty()) {
            throw new RuntimeException("There is no region");
        }
        return regions;
    }

    public Region getRegionById(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Region not found with id: " + id));
    }

    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }

    
    

}
