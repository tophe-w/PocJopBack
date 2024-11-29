package com.example.pocJop.Services;

import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.Affluence;
import com.example.pocJop.Repository.AffluenceRepository;

import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Service
public class AffluenceService {

    @Autowired
    private AffluenceRepository affluenceRepository;

    public List<Affluence> getAll() {

        List<Affluence> affluences = affluenceRepository.findAll();
        if (affluences.isEmpty()) {
            throw new RuntimeException("There is no affluence");
        }
        return affluences;
    }

    public Affluence getById(Long id) {
        return affluenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'affluence avec l'Id n°" + id + " is not found"));
    }

    public Affluence create(Affluence affluence) {
        return affluenceRepository.save(affluence);
    }

    

    public Affluence update(Long id, Affluence affluence) {
        System.out.println("Tentative de mise à jour de l'affluence avec l'ID : " + id);
        Affluence majAffluence = affluenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'affluence avec l'Id n°" + id + " n'est pas trouvée"));
       
        if (!Objects.equals(affluence.getEstimationUp(), null)) {
            majAffluence.setEstimationUp(affluence.getEstimationUp());
            System.out.println("Mise à jour du nombre de voyageurs : " + affluence.getEstimationUp());
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
