package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.CapaciteArret;
import com.example.pocJop.Repository.CapaciteArretRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CapaciteArretService {

    @Autowired
    private CapaciteArretRepository capaciteArretRepository;

    
    public List<CapaciteArret> getAllCapaciteArrets() {
        List<CapaciteArret> capaciteArrets = capaciteArretRepository.findAll();
        if (capaciteArrets.isEmpty()) {
            throw new RuntimeException("There is no capaciteArret");
        }
        return capaciteArrets;
    }

    public CapaciteArret getCapaciteArretById(Long id) {
        return capaciteArretRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La capaciteArret avec l'Id n°" + id + " is not found"));
    }

    public CapaciteArret createCapaciteArret(CapaciteArret capaciteArret) {
        return capaciteArretRepository.save(capaciteArret);
    }

    public CapaciteArret updateCapaciteArret(Long id, CapaciteArret capaciteArret) {

        System.out.println("Tentative de mise à jour de la capaciteArret avec l'ID : " + id);

        CapaciteArret majCapaciteArret = capaciteArretRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La capaciteArret avec l'Id n°" + id + " n'est pas trouvée"));

        if (capaciteArret.getDate() != null) {
            majCapaciteArret.setDate(capaciteArret.getDate());
            System.out.println("Mise à jour de la date de la capaciteArret : " + capaciteArret.getDate());
        }
        if (capaciteArret.getSens() != null) {
            majCapaciteArret.setSens(capaciteArret.getSens());
            System.out.println("Mise à jour du sens de la capaciteArret : " + capaciteArret.getSens());
        }
        if (capaciteArret.getHour() != null) {
            majCapaciteArret.setHour(capaciteArret.getHour());
            System.out.println("Mise à jour de l'heure de la capaciteArret : " + capaciteArret.getHour());
        }
        if (capaciteArret.getPremierTrain() != null) {
            majCapaciteArret.setPremierTrain(capaciteArret.getPremierTrain());
            System.out.println("Mise à jour du premier train de la capaciteArret : " + capaciteArret.getPremierTrain());
        }
        if (capaciteArret.getDernierTrain() != null) {
            majCapaciteArret.setDernierTrain(capaciteArret.getDernierTrain());
            System.out.println("Mise à jour du dernier train de la capaciteArret : " + capaciteArret.getDernierTrain());
        }
        return capaciteArretRepository.save(majCapaciteArret);
    }
    
    public void deleteCapaciteArret(Long id) {
        capaciteArretRepository.deleteById(id);
    }
 }

