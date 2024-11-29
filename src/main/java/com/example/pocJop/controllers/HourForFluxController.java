package com.example.pocJop.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocJop.Models.HourForFlux;
import com.example.pocJop.Services.HourForFluxService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")

public class HourForFluxController {

    private final static String HOUR_BASE_PATH = "/hour";
    private final static String ENDPOINT_HOUR_GET_ALL = HOUR_BASE_PATH + "/get/all";
    private final static String ENDPOINT_HOUR_GET_BY_ID = HOUR_BASE_PATH + "/get/{id}";
    private final static String ENDPOINT_HOUR_CREATE = HOUR_BASE_PATH + "/create";
    private final static String ENDPOINT_HOUR_UPDATE = HOUR_BASE_PATH + "/update/{id}";
    private final static String ENDPOINT_HOUR_DELETE = HOUR_BASE_PATH + "/delete/{id}";

    private  final HourForFluxService service;

    @GetMapping(ENDPOINT_HOUR_GET_ALL)
    public ResponseEntity<List<HourForFlux>> getAllHour() {
        return new ResponseEntity<>(service.getAllHour(), HttpStatus.OK);
    }

    // @GetMapping("/get/{id}")
    // public ResponseEntity<DateHourForFlux> getDateById(@PathVariable Long id) {
    //     return new ResponseEntity<>(service.getDateById(id), HttpStatus.OK);
    // }

    // @PostMapping("/create")
    // public ResponseEntity<DateHourForFlux> create(@RequestBody DateHourForFlux dateHourForFlux) {
    //     return new ResponseEntity<>(service.createDate(dateHourForFlux), HttpStatus.CREATED);
    // }

    // @DeleteMapping("/delete/{id}")
    // public ResponseEntity<String> delete(@PathVariable Long id) {
    //     service.deleteDate(id);
    //     return new ResponseEntity<>("La data avec l'Id n°" + id + " a été supprimée", HttpStatus.OK);
    // }
}
