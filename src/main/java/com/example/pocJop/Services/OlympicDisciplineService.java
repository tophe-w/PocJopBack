package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.OlympicDiscipline;
import com.example.pocJop.Models.OlympicSite;
import com.example.pocJop.Repository.OlympicDisciplineRepository;
import com.example.pocJop.Repository.OlympicSiteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OlympicDisciplineService {

    @Autowired
    private OlympicDisciplineRepository olympicDisciplineRepository;

    @Autowired
    private OlympicSiteRepository olympicSiteRepository;

    public List<OlympicDiscipline> getAllOlympicDisciplines() {
        List<OlympicDiscipline> olympicDisciplines = olympicDisciplineRepository.findAll();
        if (olympicDisciplines.isEmpty()) {
            throw new RuntimeException("There is no olympicDiscipline");
        }
        return olympicDisciplines;
    }

    public OlympicDiscipline getOlympicDisciplineById(Long id) {
        return olympicDisciplineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La discipline olympique avec l'Id n°" + id + " is not found"));
    }

    public OlympicDiscipline createOlympicDiscipline(OlympicDiscipline olympicDiscipline) {
        return olympicDisciplineRepository.save(olympicDiscipline);
    }

    public OlympicDiscipline updateOlympicDiscipline(Long id, OlympicDiscipline olympicDiscipline) {
        System.out.println("Tentative de mise à jour de la discipline olympique avec l'ID : " + id);
        OlympicDiscipline majOlympicDiscipline = olympicDisciplineRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("La discipline olympique avec l'Id n°" + id + " n'est pas trouvée"));
        if (olympicDiscipline.getName() != null) {
            majOlympicDiscipline.setName(olympicDiscipline.getName());
            System.out.println("Mise à jour du nom de la discipline olympique : " + olympicDiscipline.getName());
        }
        if (olympicDiscipline.getCode() != null) {
            majOlympicDiscipline.setCode(olympicDiscipline.getCode());
            System.out.println("Mise à jour du code de la discipline olympique : " + olympicDiscipline.getCode());
        }
        return olympicDisciplineRepository.save(majOlympicDiscipline);

    }

    // public OlympicDiscipline addOlympicSitesByIdToOlympicDiscipline(Long id, Long idOlympicSite) {
    //     OlympicDiscipline olympicDiscipline = olympicDisciplineRepository.findById(id)
    //             .orElseThrow(
    //                     () -> new RuntimeException("La discipline olympique avec l'Id n°" + id + " n'est pas trouvée"));
    //     OlympicSite olympicSite = olympicSiteRepository.findById(idOlympicSite)
    //             .orElseThrow(() -> new RuntimeException(
    //                     "Le site olympique avec l'Id n°" + idOlympicSite + " n'est pas trouvée"));
    //     olympicDiscipline.getOlympicSites().add(olympicSite);
    //     for (OlympicSite olympicSite1 : olympicDiscipline.getOlympicSites()) {
    //         System.out
    //                 .println("Le site olympique " + olympicSite1.getCode() + " a été ajouté à la discipline olympique "
    //                         + olympicDiscipline.getName());
    //     }
    //     olympicDisciplineRepository.save(olympicDiscipline);
    //     olympicSiteRepository.save(olympicSite);
    //     return olympicDiscipline;
    // }

    public void deleteOlympicDiscipline(Long id) {
        olympicDisciplineRepository.deleteById(id);
    }
}
