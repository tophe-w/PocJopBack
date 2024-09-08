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

import com.example.pocJop.Models.CapaciteDePassage;
import com.example.pocJop.Services.CapaciteDePassageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/capaciteDePassage")
@CrossOrigin(origins = "http://localhost:4200")


public class CapaciteDePassageController {

    private final CapaciteDePassageService capaciteDePassageService;

    @GetMapping("/get/all")
    public ResponseEntity<List<CapaciteDePassage>> getAllCapaciteDePassages() {
        return new ResponseEntity<>(capaciteDePassageService.getAllCapaciteDePassages(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CapaciteDePassage> getCapaciteDePassageById(@PathVariable Long id) {
        return new ResponseEntity<>(capaciteDePassageService.getCapaciteDePassageById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CapaciteDePassage> create(@RequestBody CapaciteDePassage capaciteDePassage) {
        return new ResponseEntity<>(capaciteDePassageService.createCapaciteDePassage(capaciteDePassage), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CapaciteDePassage> update(@PathVariable Long id, @RequestBody CapaciteDePassage capaciteDePassage) {
        return new ResponseEntity<>(capaciteDePassageService.updateCapaciteDePassage(id, capaciteDePassage), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        capaciteDePassageService.deleteCapaciteDePassage(id);
        return new ResponseEntity<>("La capaciteDePassage avec l'Id n°" + id + " a été supprimée", HttpStatus.OK);
    }	

}
