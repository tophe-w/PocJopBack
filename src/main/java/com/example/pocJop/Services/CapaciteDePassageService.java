package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.CapaciteDePassage;
import com.example.pocJop.Repository.CapaciteDePassageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CapaciteDePassageService {
    

    @Autowired
    private CapaciteDePassageRepository capaciteDePassageRepository;


    public List<CapaciteDePassage> getAllCapaciteDePassages() {
        List<CapaciteDePassage> capaciteDePassages = capaciteDePassageRepository.findAll();
        if (capaciteDePassages.isEmpty()) {
            throw new RuntimeException("There is no capaciteDePassage");
        }
        return capaciteDePassages;
    }

    public CapaciteDePassage getCapaciteDePassageById(Long id) {
        return capaciteDePassageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La capaciteDePassage avec l'Id n°" + id + " is not found"));
    }

    public CapaciteDePassage createCapaciteDePassage(CapaciteDePassage capaciteDePassage) {
        return capaciteDePassageRepository.save(capaciteDePassage);
    }

    public CapaciteDePassage updateCapaciteDePassage(Long id, CapaciteDePassage capaciteDePassage) {

        System.out.println("Tentative de mise à jour de la capaciteDePassage avec l'ID : " + id);

        CapaciteDePassage majCapaciteDePassage = capaciteDePassageRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("La capaciteDePassage avec l'Id n°" + id + " n'est pas trouvée"));

        if (capaciteDePassage.getSens() != null) {
            majCapaciteDePassage.setSens(capaciteDePassage.getSens());
            System.out.println("Mise à jour du sens de la capaciteDePassage : " + capaciteDePassage.getSens());
        }
        if (capaciteDePassage.getDate() != null) {
            majCapaciteDePassage.setDate(capaciteDePassage.getDate());
            System.out.println("Mise à jour de la date de la capaciteDePassage : " + capaciteDePassage.getDate());
        }
        if (capaciteDePassage.getHour() != null) {
            majCapaciteDePassage.setHour(capaciteDePassage.getHour());
            System.out.println("Mise à jour de l'heure de la capaciteDePassage : " + capaciteDePassage.getHour());
        }
        if (capaciteDePassage.getTrainsByHourCount() != 0) {
            majCapaciteDePassage.setTrainsByHourCount(capaciteDePassage.getTrainsByHourCount());
            System.out.println("Mise à jour du nombre de trains par heure de la capaciteDePassage : "
                    + capaciteDePassage.getTrainsByHourCount());
        }
        return capaciteDePassageRepository.save(majCapaciteDePassage);
    }
    
    public void deleteCapaciteDePassage(Long id) {
        capaciteDePassageRepository.deleteById(id);
    }
}
