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

import com.example.pocJop.Models.Troncon;
import com.example.pocJop.Services.TronconService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/troncon")
@CrossOrigin(origins = "http://localhost:4200")
public class TronconController {

    private final TronconService tronconService;

    @GetMapping("/get/all")
    public ResponseEntity<List<Troncon>> getAllTroncons() {
        return new ResponseEntity<>(tronconService.getAllTroncons(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Troncon> getTronconById(@PathVariable Long id) {
        return new ResponseEntity<>(tronconService.getTronconById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Troncon> create(@RequestBody Troncon troncon) {
        return new ResponseEntity<>(tronconService.createTroncon(troncon), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Troncon> update(@PathVariable Long id, @RequestBody Troncon troncon) {
        return new ResponseEntity<>(tronconService.updateTroncon(id, troncon), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        tronconService.deleteTroncon(id);
        return new ResponseEntity<>("Le troncon avec l'Id n°" + id + " a été supprimé", HttpStatus.OK);
    }
    
    
}
