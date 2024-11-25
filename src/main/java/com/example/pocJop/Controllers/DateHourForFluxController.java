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
import org.springframework.web.bind.annotation.DeleteMapping; 

import com.example.pocJop.Models.DateHourForFlux;
import com.example.pocJop.Services.DateHourForFluxService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/date")
@CrossOrigin(origins = "http://localhost:4200")
public class DateHourForFluxController {
    
    private final DateHourForFluxService service;

    @GetMapping("/get/all")
    public ResponseEntity<List<DateHourForFlux>> getAllDate() {
        return new ResponseEntity<>(service.getAllDates(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DateHourForFlux> getDateById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getDateById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<DateHourForFlux> create(@RequestBody DateHourForFlux dateHourForFlux) {
        return new ResponseEntity<>(service.createDate(dateHourForFlux), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteDate(id);
        return new ResponseEntity<>("La data avec l'Id n°" + id + " a été supprimée", HttpStatus.OK);
    }

    // @PostMapping("/update/{id}")
    // public ResponseEntity<Affluence> update(@PathVariable Long id, @RequestBody Affluence affluence) {
    //     return new ResponseEntity<>(affluenceService.updateAffluence(id, affluence), HttpStatus.OK);
    // }
}
