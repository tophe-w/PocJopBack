package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.OlympicSite;
import com.example.pocJop.Repository.OlympicSiteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OlympicSiteService {

    @Autowired
    private OlympicSiteRepository olympicSiteRepository;

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

    public void deleteOlympicSite(Long id) {
        olympicSiteRepository.deleteById(id);
    }

}