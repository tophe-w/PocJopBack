package com.example.pocJop.Services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.Affluence;
import com.example.pocJop.Repository.AffluenceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AffluenceService {

    @Autowired
    private AffluenceRepository affluenceRepository;

    public List<Affluence> getAllAffluences() {
        List<Affluence> affluences = affluenceRepository.findAll();
        if (affluences.isEmpty()) {
            throw new RuntimeException("There is no affluence");
        }
        return affluences;
    }

    public Affluence getAffluenceById(Long id) {
        return affluenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'affluence avec l'Id n°" + id + " is not found"));
    }

    public Affluence createAffluence(Affluence affluence) {
        return affluenceRepository.save(affluence);
    }

    public Affluence updateAffluence(Long id, Affluence affluence) {

        System.out.println("Tentative de mise à jour de l'affluence avec l'ID : " + id);

        Affluence majAffluence = affluenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'affluence avec l'Id n°" + id + " n'est pas trouvée"));

        if (affluence.getDate() != null) {
            majAffluence.setDate(affluence.getDate());
            System.out.println("Mise à jour de l'affluence : " + affluence.getDate());
        }
        if (affluence.getHourOfDay() != null) {
            majAffluence.setHourOfDay(affluence.getHourOfDay());
            System.out.println("Mise à jour de la gare : " + affluence.getHourOfDay());
        }

        if (!Objects.equals(affluence.getEstimationParisUp(), null)) {
            majAffluence.setEstimationParisUp(affluence.getEstimationParisUp());
            System.out.println("Mise à jour du nombre de voyageurs : " + affluence.getEstimationParisUp());
        }

        if (!Objects.equals(affluence.getAffluenceHabituelleUp(), null)) {
            majAffluence.setAffluenceHabituelleUp(affluence.getAffluenceHabituelleUp());
            System.out.println("Mise à jour du nombre de voyageurs : " + affluence.getAffluenceHabituelleUp());
        }
        return affluenceRepository.save(majAffluence);
    }

    public void deleteAffluence(Long id) {
        affluenceRepository.deleteById(id);
    }

}
