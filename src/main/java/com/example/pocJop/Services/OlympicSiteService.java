package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Models.OlympicDiscipline;
import com.example.pocJop.Models.OlympicSite;
import com.example.pocJop.Repository.LigneRepository;
import com.example.pocJop.Repository.OlympicDisciplineRepository;
import com.example.pocJop.Repository.OlympicSiteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OlympicSiteService {

    @Autowired
    private OlympicSiteRepository olympicSiteRepository;

    @Autowired
    private OlympicDisciplineRepository olympicDisciplineRepository;

    public List<OlympicSite> getAllOlympicSites() {
        List<OlympicSite> olympicSites = olympicSiteRepository.findAll();
        if (olympicSites.isEmpty()) {
            throw new RuntimeException("There is no olympicSite");
        }
        return olympicSites;
    }

    public OlympicSite getOlympicSiteById(Long id) {
        return olympicSiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Le site olympique avec l'Id n°" + id + " is not found"));
    }

    public OlympicSite createOlympicSite(OlympicSite olympicSite) {
        return olympicSiteRepository.save(olympicSite);
    }

    public OlympicSite addDisciplineByNameToOlympicSite(Long olympicSiteId, List<String> disciplinesNames) {
        OlympicSite olympicSite = olympicSiteRepository.findById(olympicSiteId)
                .orElseThrow(() -> new RuntimeException(
                        "Le site olympique avec l'Id n°" + olympicSiteId + " n'est pas trouvée"));
        List<OlympicDiscipline> disciplines = olympicDisciplineRepository.findByNameIn(disciplinesNames);
        if (disciplines.isEmpty()) {
            throw new RuntimeException("Aucune discipline trouvée avec les noms fournis : " + disciplinesNames);
        }
        olympicSite.getOlympicDisciplines().addAll(disciplines);
        for (OlympicDiscipline discipline : disciplines) {
            if (!discipline.getOlympicSites().contains(olympicSite)) {
                discipline.getOlympicSites().add(olympicSite);
            }
        }
        olympicSiteRepository.save(olympicSite);
        olympicDisciplineRepository.saveAll(disciplines);
        return olympicSite;
    }




    public OlympicSite updateOlympicSite(Long id, OlympicSite olympicSite) {
        System.out.println("Tentative de mise à jour du site olympique avec l'ID : " + id);
        OlympicSite majOlympicSite = olympicSiteRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Le site olympique avec l'Id n°" + id + " n'est pas trouvée"));

        if (olympicSite.getCode() != null) {
            majOlympicSite.setCode(olympicSite.getCode());
            System.out.println("Mise à jour du code du site olympique : " + olympicSite.getCode());

        }
        majOlympicSite.setNavette(olympicSite.isNavette());
        System.out.println("Mise à jour de l'état isEventStart : " + olympicSite.isNavette());

        return majOlympicSite;

    }


    // public OlympicSite addLignesByNameToOlympicSite(Long olympicSiteId, List<String> ligneNames) {
    //     OlympicSite olympicSite = olympicSiteRepository.findById(olympicSiteId)
    //             .orElseThrow(() -> new RuntimeException(
    //                     "Le site olympique avec l'Id n°" + olympicSiteId + " n'est pas trouvée"));
    //     List<Ligne> lignes = ligneRepository.findByNameIn(ligneNames);
    //     if (lignes.isEmpty()) {
    //         throw new RuntimeException("Aucune ligne trouvée avec les noms fournis : " + ligneNames);
    //     }
    //     olympicSite.getLignes().addAll(lignes);
    //     for (Ligne ligne : lignes) {
    //         if (!ligne.getOlympicSites().contains(olympicSite)) {
    //             ligne.getOlympicSites().add(olympicSite);
    //         }
    //     }
    //     olympicSiteRepository.save(olympicSite);
    //     ligneRepository.saveAll(lignes);
    //     return olympicSite;
    // }
    
    public void deleteOlympicSite(Long id) {
        olympicSiteRepository.deleteById(id);
    }

}