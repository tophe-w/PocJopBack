package com.example.pocJop.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Dto.LigneDto;
import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Repository.LigneRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LigneService {
    

    @Autowired
    private LigneRepository ligneRepository;

    public List<Ligne> getAllLignes() {
        List<Ligne> lignes = ligneRepository.findAll();
        if (lignes.isEmpty()) {
            throw new RuntimeException("There is no ligne");
        }
        return lignes;
    }

    public List<LigneDto> getAllLignesDtos() {
        List<Ligne> lignes = ligneRepository.findAll();
        List<LigneDto> lignesDtos = new ArrayList<>();
       for (Ligne ligne : lignes) {
            LigneDto ligneDto = new LigneDto();
            ligneDto.setId(ligne.getId());
            ligneDto.setName(ligne.getName());
            ligneDto.setCode(ligne.getCode());
            lignesDtos.add(ligneDto);
        }
        return lignesDtos;
    }

    public Ligne getLigneById(Long id) {
        return ligneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La ligne avec l'Id n°" + id + " is not found"));
    }

    public Ligne createLigne(Ligne ligne) {
        return ligneRepository.save(ligne);
    }
    
    public Ligne updateLigne(Long id, Ligne ligne) {

        System.out.println("Tentative de mise à jour de la ligne avec l'ID : " + id);

        Ligne majLigne = ligneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La ligne avec l'Id n°" + id + " n'est pas trouvée"));

        if (ligne.getName() != null) {
            majLigne.setName(ligne.getName());
            System.out.println("Mise à jour du nom de la ligne : " + ligne.getName());
        }
        if (ligne.getCode() != null) {
            majLigne.setCode(ligne.getCode());
            System.out.println("Mise à jour du code de la ligne : " + ligne.getCode());
        }
        return ligneRepository.save(majLigne);
    }
    
    public void deleteLigne(Long id) {
        ligneRepository.deleteById(id);
    }
        
}
