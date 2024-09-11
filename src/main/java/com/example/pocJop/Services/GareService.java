package com.example.pocJop.Services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.Affluence;
import com.example.pocJop.Models.CapaciteArret;
import com.example.pocJop.Models.CapaciteDePassage;
import com.example.pocJop.Models.Gare;
import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Models.OlympicSite;
import com.example.pocJop.Models.Troncon;
import com.example.pocJop.Repository.AffluenceRepository;
import com.example.pocJop.Repository.CapaciteArretRepository;
import com.example.pocJop.Repository.CapaciteDePassageRepository;
import com.example.pocJop.Repository.GareRepository;
import com.example.pocJop.Repository.LigneRepository;
import com.example.pocJop.Repository.OlympicSiteRepository;
import com.example.pocJop.Repository.TronconRepository;

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
    private TronconRepository tronconRepository;

    @Autowired
    private AffluenceRepository affluenceRepository;

    @Autowired
    private CapaciteArretRepository capaciteArretRepository;

    @Autowired
    private CapaciteDePassageRepository capaciteDePassageRepository;

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

    public Gare addOlympicSitesByIdToGare(Long gareId, List<Long> olympicSiteIds) {
        Gare gare = gareRepository.findById(gareId)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));

        // Récupérer les sites olympiques via leurs IDs
        List<OlympicSite> olympicSites = olympicSiteRepository.findByIdIn(olympicSiteIds);

        if (olympicSites.isEmpty()) {
            throw new RuntimeException("Aucun site olympique trouvé avec les IDs fournis : " + olympicSiteIds);
        }

        // Ajouter les sites olympiques à la gare
        gare.getOlympicSites().addAll(olympicSites);

        // Ajouter la gare à chaque site olympique si elle n'est pas déjà présente
        for (OlympicSite olympicSite : olympicSites) {
            if (!olympicSite.getGares().contains(gare)) {
                olympicSite.getGares().add(gare);
            }
        }

        // Sauvegarder les changements
        gareRepository.save(gare);
        olympicSiteRepository.saveAll(olympicSites);

        return gare;
    }

    public Gare addAffluenceByIdToGare(Long gareId, Long affluenceId) {
        Gare gare = gareRepository.findById(gareId)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));
        Affluence affluence = affluenceRepository.findById(affluenceId)
                .orElseThrow(
                        () -> new RuntimeException("L'affluence avec l'Id n°" + affluenceId + " n'est pas trouvée"));
        gare.setAffluence(affluence);
        affluence.setGares(gare);

        gareRepository.save(gare);
        affluenceRepository.save(affluence);
        return gare;

    }

    public Gare addCapaciteDePassageByIdToGare(Long gareId, Long capaciteDePassageId) {
        Gare gare = gareRepository.findById(gareId)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));
        List<CapaciteDePassage> capaciteDePassages = capaciteDePassageRepository
                .findAllById(Collections.singletonList(capaciteDePassageId));
        if (capaciteDePassages.isEmpty()) {
            throw new RuntimeException(
                    "Aucune capacité de passage trouvée avec les IDs fournis : " + capaciteDePassageId);
        }
        for (CapaciteDePassage capaciteDePassage : capaciteDePassages) {
            if (capaciteDePassage.getGare() != null && !capaciteDePassage.getGare().equals(gare)) {
                capaciteDePassage.getGare().getCapaciteDePassages().remove(capaciteDePassage);
            }
            capaciteDePassage.setGare(gare);
        }
        gare.getCapaciteDePassages().addAll(capaciteDePassages);
        capaciteDePassageRepository.saveAll(capaciteDePassages);
        gareRepository.save(gare);

        return gare;
    }
    
    public Gare addCapaciteArretByIdToGare(Long gareId, Long capaciteArretId) {
        Gare gare = gareRepository.findById(gareId)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));
        List<CapaciteArret> capaciteArrets = capaciteArretRepository
                .findAllById(Collections.singletonList(capaciteArretId));
        if (capaciteArrets.isEmpty()) {
            throw new RuntimeException(
                    "Aucune capacité de passage trouvée avec les IDs fournis : " + capaciteArretId);
        }
        for (CapaciteArret capaciteArret : capaciteArrets) {
            if (capaciteArret.getGare() != null && !capaciteArret.getGare().equals(gare)) {
                capaciteArret.getGare().getCapaciteDePassages().remove(capaciteArret);
            }
            capaciteArret.setGare(gare);
        }
        gare.getCapaciteArrets().addAll(capaciteArrets);
        capaciteArretRepository.saveAll(capaciteArrets);
        gareRepository.save(gare);

        return gare;
    }


    public Gare addTronconByIdToGare(Long gareId, Long tronconId) {
        Gare gare = gareRepository.findById(gareId)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));
        List<Troncon> troncons = tronconRepository
                .findAllById(Collections.singletonList(tronconId));
        if (troncons.isEmpty()) {
            throw new RuntimeException(
                    "Aucune capacité de passage trouvée avec les IDs fournis : " + tronconId);
        }
        for (Troncon troncon : troncons) {
            if (troncon.getGare() != null && !troncon.getGare().equals(gare)) {
                troncon.getGare().getCapaciteDePassages().remove(troncon);
            }
            troncon.setGare(gare);
        }
        gare.getTroncons().addAll(troncons);
        tronconRepository.saveAll(troncons);
        gareRepository.save(gare);

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
        if (gare.getPlanDeGare() != null) {
            majGare.setPlanDeGare(gare.getPlanDeGare());
            System.out.println("Mise à jour du plan de gare");
        }
        if (gare.getPlanDeGareSvg() != null) {
            majGare.setPlanDeGareSvg(gare.getPlanDeGareSvg());
            System.out.println("Mise à jour du plan SVG de gare");
        }
        if (gare.getAccessibilite() != null) {
            majGare.setAccessibilite(gare.getAccessibilite());
            System.out.println("Mise à jour de l'accessibilité : " + gare.getAccessibilite());
        }
        if (gare.getLignes() != null) {
            majGare.getLignes().clear();
            for (Ligne ligne : gare.getLignes()) {
              
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