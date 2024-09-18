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

import com.example.pocJop.Models.CapaciteArret;
import com.example.pocJop.Services.CapaciteArretService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/capaciteArret")
@CrossOrigin(origins = "http://localhost:4200")
public class CapaciteArretController {

    private final CapaciteArretService capaciteArretService;

    @GetMapping("/get/all")
    public ResponseEntity<List<CapaciteArret>> getAllCapaciteArrets() {
        return new ResponseEntity<>(capaciteArretService.getAllCapaciteArrets(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CapaciteArret> getCapaciteArretById(@PathVariable Long id) {
        return new ResponseEntity<>(capaciteArretService.getCapaciteArretById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CapaciteArret> create(@RequestBody CapaciteArret capaciteArret) {
        return new ResponseEntity<>(capaciteArretService.createCapaciteArret(capaciteArret), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CapaciteArret> update(@PathVariable Long id, @RequestBody CapaciteArret capaciteArret) {
        return new ResponseEntity<>(capaciteArretService.updateCapaciteArret(id, capaciteArret), HttpStatus.OK);
    }
    
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        capaciteArretService.deleteCapaciteArret(id);
        return new ResponseEntity<>("La capaciteArret avec l'Id n°" + id + " a été supprimée", HttpStatus.OK);
    }
}
