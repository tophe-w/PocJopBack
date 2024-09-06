package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Repository.LigneRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LigneService {
    

    @Autowired
    private LigneRepository ligneRepository;

    public List<Ligne> getAllLignes() {
        List<Ligne> lignes = ligneRepository.findAll();
        if (lignes.isEmpty()) {
            throw new RuntimeException("There is no ligne");
        }
        return lignes;
    }
}
