package com.example.pocJop.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocJop.Dto.RegionDtos.RegionDtoPagePrincipale;
import com.example.pocJop.Dto.RegionDtos.RegionWithGareAndSites;
import com.example.pocJop.Models.Region;
import com.example.pocJop.Services.RegionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/region")
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {
    
    private final RegionService regionService;


    @GetMapping("/get/all")
    public ResponseEntity<List<Region>> getAllRegions() {
        return new ResponseEntity<>(regionService.getAllRegions(), HttpStatus.OK);
    }
    @GetMapping("/get/allRegions")
    public ResponseEntity<List<RegionDtoPagePrincipale>> getAllRegionsDtos() {
        return new ResponseEntity<>(regionService.getAllRegionsDtos(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RegionWithGareAndSites> getRegionByIdGaresListAndNbLieux(@PathVariable Long id) {
        return new ResponseEntity<RegionWithGareAndSites>(regionService.getRegionByIdGaresListAndNbLieux(id), HttpStatus.OK);
    }
   
   


    @PostMapping("/create")
    public ResponseEntity<Region> create(@RequestBody Region region) {
        return new ResponseEntity<>(regionService.createRegion(region), HttpStatus.CREATED);
    }

    
}
