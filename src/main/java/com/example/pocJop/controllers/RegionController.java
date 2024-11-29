package com.example.pocJop.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocJop.Dto.regionDtos.RegionDto;
import com.example.pocJop.Models.Region;
import com.example.pocJop.Services.RegionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {
    
    private final static String REGION_BASE_PATH = "/region";
    private final static String ENDPOINT_REGION_GET_ALL = REGION_BASE_PATH + "/get/all";
    private final static String ENDPOINT_REGION_GET_BY_ID = REGION_BASE_PATH + "/get/{id}";
    private final static String ENDPOINT_REGION_CREATE = REGION_BASE_PATH + "/create";
    private final static String ENDPOINT_REGION_UPDATE = REGION_BASE_PATH + "/update/{id}";

    private final RegionService regionService;


    @GetMapping(ENDPOINT_REGION_GET_ALL)
    public ResponseEntity<List<RegionDto>> getAllRegions() {
        return new ResponseEntity<>(regionService.getAll(), HttpStatus.OK);
    }

    @GetMapping(ENDPOINT_REGION_GET_BY_ID)
    public ResponseEntity<RegionDto> getRegionById(@PathVariable Long id) {
        return new ResponseEntity<>(regionService.getRegionById(id), HttpStatus.OK);
    }

    @PostMapping(ENDPOINT_REGION_CREATE)
    public ResponseEntity<Region> create(@RequestBody Region region) {
        return new ResponseEntity<>(regionService.createRegion(region), HttpStatus.CREATED);
    }

    
}
