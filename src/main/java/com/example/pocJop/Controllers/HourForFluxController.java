package com.example.pocJop.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping; 

import com.example.pocJop.Models.HourForFlux;
import com.example.pocJop.Services.HourForFluxService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hour")
@CrossOrigin(origins = "http://localhost:4200")

public class HourForFluxController {
    
    private  final HourForFluxService service;

     @GetMapping("/get/all")
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
