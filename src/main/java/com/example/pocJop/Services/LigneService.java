package com.example.pocJop.Services;

import java.util.List;
import java.util.Optional;

import com.example.pocJop.helper.Helpers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.pocJop.Dto.ligneDtos.LigneDto;
import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Repository.LigneRepository;

import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Service
public class LigneService {
    

    private final LigneRepository ligneRepository;


    public List<LigneDto> getAll() {
        List<Ligne> lignes = ligneRepository.findAll();
        if (lignes.isEmpty()) {
            throw new RuntimeException("There is no ligne");
        }

        return lignes.stream().map(ligne ->
            LigneDto.builder()
                    .id(ligne.getId())
                    .name(ligne.getName())
                    .build()).toList();
    }

    public Optional<LigneDto> getById(Long id) {
        return ligneRepository.findById(id).map(ligne -> LigneDto.builder()
                .id(ligne.getId())
                .name(ligne.getName())
                .build());
    }

    public Ligne createLigne(Ligne ligne) {
        return ligneRepository.save(ligne);
    }
    
    public Ligne updateLigne(Long id, Ligne ligne) {

        System.out.println("Tentative de mise à jour de la ligne avec l'ID : " + id);

        Ligne ligneToUpdate = ligneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La ligne avec l'Id n°" + id + " n'est pas trouvée"));

        Helpers.UpdateObjectFields(ligne, ligneToUpdate);

        return ligneRepository.save(ligneToUpdate);
    }
    
    public void deleteLigne(Long id) {
        ligneRepository.deleteById(id);
    }
        
}
