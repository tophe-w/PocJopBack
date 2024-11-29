package com.example.pocJop.controllers;

import java.util.List;
import java.util.Optional;

import com.example.pocJop.exceptions.customException.ResourceNotFoundException;
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

import com.example.pocJop.Dto.ligneDtos.LigneDto;
import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Services.LigneService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class LigneController {

    private final static String LIGNE_BASE_PATH = "/ligne";
    private final static String ENDPOINT_LIGNE_GET_ALL = LIGNE_BASE_PATH + "/get/all";
    private final static String ENDPOINT_LIGNE_GET_BY_ID = LIGNE_BASE_PATH + "/get/{id}";
    private final static String ENDPOINT_LIGNE_CREATE = LIGNE_BASE_PATH + "/create";
    private final static String ENDPOINT_LIGNE_UPDATE = LIGNE_BASE_PATH + "/update/{id}";
    private final static String ENDPOINT_LIGNE_DELETE = LIGNE_BASE_PATH + "/delete/{id}";

    private final LigneService ligneService;

    @Autowired
    private Messages msg;

    @GetMapping(ENDPOINT_LIGNE_GET_ALL)
    public ResponseEntity<List<LigneDto>> getAll() {
        return new ResponseEntity<>(ligneService.getAll(), HttpStatus.OK);
    }

    @GetMapping(ENDPOINT_LIGNE_GET_BY_ID)
    public ResponseEntity<LigneDto> getById(@PathVariable Long id) {
        Optional<LigneDto> ligneDto = ligneService.getById(id);
        return ligneDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseThrow(() -> new ResourceNotFoundException(msg.getMessage("error_msg.ligne_not_found", Long.toString(id))));
    }

    @PostMapping(ENDPOINT_LIGNE_CREATE)
    public ResponseEntity<Ligne> create(@RequestBody Ligne ligne) {
        return new ResponseEntity<>(ligneService.createLigne(ligne), HttpStatus.CREATED);
    }

    @PostMapping(ENDPOINT_LIGNE_UPDATE)
    public ResponseEntity<Ligne> update(@PathVariable Long id, @RequestBody Ligne ligne) {
        return new ResponseEntity<>(ligneService.updateLigne(id, ligne), HttpStatus.OK);
    }

    @DeleteMapping(ENDPOINT_LIGNE_DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ligneService.deleteLigne(id);
        return new ResponseEntity<>(msg.getMessage("confirm_msg.delete.ligne", Long.toString(id)), HttpStatus.OK);
    }
    
}
