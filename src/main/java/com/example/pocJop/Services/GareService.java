package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        
        System.out.println("Tentative de mise à jour de la gare avec l'ID : " + id);
       
        Gare majGare = gareRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + id + " n'est pas trouvée"));

        if (gare.getName() != null) {
            majGare.setName(gare.getName());
            System.out.println("Mise à jour du nom de la gare : " + gare.getName());
        }
        if (gare.getCode() != null) {
            majGare.setCode(gare.getCode());
            System.out.println("Mise à jour du code de la gare : " + gare.getCode());
        }
        if (gare.getPlan_de_gare() != null) {
            majGare.setPlan_de_gare(gare.getPlan_de_gare());
            System.out.println("Mise à jour du plan de gare");
        }
        if (gare.getPlan_de_gare_svg() != null) {
            majGare.setPlan_de_gare_svg(gare.getPlan_de_gare_svg());
            System.out.println("Mise à jour du plan SVG de gare");
        }
        if (gare.getAccessibilite() != null) {
            majGare.setAccessibilite(gare.getAccessibilite());
            System.out.println("Mise à jour de l'accessibilité : " + gare.getAccessibilite());
    }
        

   
        majGare=gareRepository.save(majGare);
        System.out.println("Gare mise à jour et sauvegardée.");
        return majGare;
    }

    public void deleteGare(Long id) {
        gareRepository.deleteById(id);
    }
}