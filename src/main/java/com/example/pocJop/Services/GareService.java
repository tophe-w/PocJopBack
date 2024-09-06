package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pocJop.Models.Gare;
import com.example.pocJop.Repository.GareRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GareService {

    @Autowired
    private GareRepository gareRepository;

    public List<Gare> getAllGares() {
        List<Gare> gares = gareRepository.findAll();
        if (gares.isEmpty()) {
            throw new RuntimeException("There is no gare");
        }
        return gares;
    }

    public Gare getGareById(Long id) {
        return gareRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + id + " is not found"));
    }

    public Gare createGare(Gare gare) {
        return gareRepository.save(gare);
    }
   
    public Gare updateGare(Long id, Gare gare) {
        // On vérifie si la gare existe en base de données
        Gare majGare = gareRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + id + " n'est pas trouvée"));

        // Mise à jour des champs si les valeurs ne sont pas nulles
        if (gare.getName() != null) {
            majGare.setName(gare.getName());
        }
        if (gare.getCode() != null) {
            majGare.setCode(gare.getCode());
        }
        if (gare.getPlan_de_gare() != null) {
            majGare.setPlan_de_gare(gare.getPlan_de_gare());
        }
        if (gare.getPlan_de_gare_svg() != null) {
            majGare.setPlan_de_gare_svg(gare.getPlan_de_gare_svg());
        }
        if (gare.getAccessibilite() != null) {
            majGare.setAccessibilite(gare.getAccessibilite());
        }

        // Sauvegarde des modifications dans la base de données
        majGare = gareRepository.save(majGare);
        return majGare;
    }
}