package com.example.pocJop.controllers;

import java.util.List;

import com.example.pocJop.helper.Messages;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.DeleteMapping; 

import com.example.pocJop.Models.DateHourForFlux;
import com.example.pocJop.Services.DateHourForFluxService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class DateHourForFluxController {
    
    private final static String DATE_BASE_PATH = "/date";
    private final static String ENDPOINT_DATE_GET_ALL = DATE_BASE_PATH + "/get/all";
    private final static String ENDPOINT_DATE_GET_BY_ID = DATE_BASE_PATH + "/get/{id}";
    private final static String ENDPOINT_DATE_CREATE = DATE_BASE_PATH + "/create";
    private final static String ENDPOINT_DATE_UPDATE = DATE_BASE_PATH + "/update/{id}";
    private final static String ENDPOINT_DATE_DELETE = DATE_BASE_PATH + "/delete/{id}";

    private final DateHourForFluxService service;

    @Autowired
    private Messages msg;

    @GetMapping(ENDPOINT_DATE_GET_ALL)
    public ResponseEntity<List<DateHourForFlux>> getAllDate() {
        return new ResponseEntity<>(service.getAllDates(), HttpStatus.OK);
    }

    @GetMapping(ENDPOINT_DATE_GET_BY_ID)
    public ResponseEntity<DateHourForFlux> getDateById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getDateById(id), HttpStatus.OK);
    }

    @PostMapping(ENDPOINT_DATE_CREATE)
    public ResponseEntity<DateHourForFlux> create(@RequestBody DateHourForFlux dateHourForFlux) {
        return new ResponseEntity<>(service.createDate(dateHourForFlux), HttpStatus.CREATED);
    }

    @DeleteMapping(ENDPOINT_DATE_DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteDate(id);
        return new ResponseEntity<>(msg.getMessage("confirm_msg.delete.event", Long.toString(id)), HttpStatus.OK);
    }

    // @PostMapping("/update/{id}")
    // public ResponseEntity<Affluence> update(@PathVariable Long id, @RequestBody Affluence affluence) {
    //     return new ResponseEntity<>(affluenceService.updateAffluence(id, affluence), HttpStatus.OK);
    // }
}
