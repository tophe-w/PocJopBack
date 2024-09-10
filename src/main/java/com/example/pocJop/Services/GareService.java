package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pocJop.Models.Gare;
import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Models.OlympicEvent;
import com.example.pocJop.Models.OlympicSite;
import com.example.pocJop.Repository.GareRepository;
import com.example.pocJop.Repository.LigneRepository;
import com.example.pocJop.Repository.OlympicEventRepository;
import com.example.pocJop.Repository.OlympicSiteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GareService {

    @Autowired
    private GareRepository gareRepository;

    @Autowired
    private LigneRepository ligneRepository;

    @Autowired
    private OlympicSiteRepository olympicSiteRepository;

    @Autowired
    private OlympicEventRepository olympicEventRepository;

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

    public Gare addLignesByNameToGare(Long gareId, List<String> ligneNames) {
        Gare gare = gareRepository.findById(gareId)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));
        List<Ligne> lignes = ligneRepository.findByNameIn(ligneNames);
        if (lignes.isEmpty()) {
            throw new RuntimeException("Aucune ligne trouvée avec les noms fournis : " + ligneNames);
        }
        gare.getLignes().addAll(lignes);
        for (Ligne ligne : lignes) {
            if (!ligne.getGares().contains(gare)) {
                ligne.getGares().add(gare);
            }
        }
        gareRepository.save(gare);
        ligneRepository.saveAll(lignes);
        return gare;
    }

    public Gare addOlympicSitesByNameToGare(Long gareId, List<String> olympicSiteCodes) {
        Gare gare = gareRepository.findById(gareId)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));
        List<OlympicSite> olympicSites = olympicSiteRepository.findByCodeIn(olympicSiteCodes);
        if (olympicSites.isEmpty()) {
            throw new RuntimeException("Aucun site olympique trouvé avec les noms fournis : " + olympicSiteCodes);
        }
        gare.getOlympicSites().addAll(olympicSites);
        for (OlympicSite olympicSite : olympicSites) {
            if (!olympicSite.getGares().contains(gare)) {
                olympicSite.getGares().add(gare);
            }
        }
        gareRepository.save(gare);
        olympicSiteRepository.saveAll(olympicSites);
        return gare;
    }

    public Gare addOlympicEventsByNameToGare(Long gareId, List<String> olympicEventIds) {
        Gare gare = gareRepository.findById(gareId)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));
        List<OlympicEvent> olympicEvents = olympicEventRepository.findByIdIn(olympicEventIds);
        if (olympicEvents.isEmpty()) {
            throw new RuntimeException("Aucun événement olympique trouvé avec les noms fournis : " + olympicEventIds);
        }
        gare.getOlympicEvents().addAll(olympicEvents);
        for (OlympicEvent olympicEvent : olympicEvents) {
            if (!olympicEvent.getGares().contains(gare)) {
                olympicEvent.getGares().add(gare);
            }
        }
        gareRepository.save(gare);
        olympicEventRepository.saveAll(olympicEvents);
        return gare;


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
        if (gare.getLignes() != null) {
            // Supprimer les anciennes associations
            majGare.getLignes().clear();
            // Ajouter les nouvelles lignes associées
            for (Ligne ligne : gare.getLignes()) {
                // Assurer que chaque ligne est correctement persistée
                Ligne lignePersisted = ligneRepository.findById(ligne.getId())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Ligne avec l'Id n°" + ligne.getId() + " n'est pas trouvée"));
                majGare.getLignes().add(lignePersisted);
                // Mettre à jour l'association bidirectionnelle
                if (!lignePersisted.getGares().contains(majGare)) {
                    lignePersisted.getGares().add(majGare);
                }
            }
            System.out.println("Mise à jour des lignes associées à la gare");
        }

        majGare = gareRepository.save(majGare);
        System.out.println("Gare mise à jour et sauvegardée.");
        return majGare;
    }

    public void deleteGare(Long id) {
        gareRepository.deleteById(id);
    }
}