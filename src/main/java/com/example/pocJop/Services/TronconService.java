package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.Troncon;
import com.example.pocJop.Repository.TronconRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TronconService {

    @Autowired
    private TronconRepository tronconRepository;

    public List<Troncon> getAllTroncons() {
        List<Troncon> troncons = tronconRepository.findAll();
        if (troncons.isEmpty()) {
            throw new RuntimeException("There is no troncon");
        }
        return troncons;
    }

    public Troncon getTronconById(Long id) {
        return tronconRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Le troncon avec l'Id n°" + id + " is not found"));
    }

    public Troncon createTroncon(Troncon troncon) {
        return tronconRepository.save(troncon);
    }

    public Troncon updateTroncon(Long id, Troncon troncon) {
        System.out.println("Tentative de mise à jour du troncon avec l'ID : " + id);
        Troncon majTroncon = tronconRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Le troncon avec l'Id n°" + id + " n'est pas trouvée"));

        if (troncon.getGareCode() != null) {
            majTroncon.setGareCode(troncon.getGareCode());
            System.out.println("Mise à jour du nom du troncon : " + troncon.getGareCode());
        }
        if (troncon.getLigneCode() != null) {
            majTroncon.setLigneCode(troncon.getLigneCode());
            System.out.println("Mise à jour de la distance du troncon : " + troncon.getLigneCode());
        }
        if (troncon.getSens() != null) {
            majTroncon.setSens(troncon.getSens());
            System.out.println("Mise à jour du temps du troncon : " + troncon.getSens());
        }
        if (troncon.getOrdre() != 0) {
            majTroncon.setOrdre(troncon.getOrdre());
            System.out.println("Mise à jour du départ du troncon : " + troncon.getOrdre());

        }
        majTroncon=tronconRepository.save(majTroncon);
        return majTroncon;
    }

    public void deleteTroncon(Long id) {
        Troncon troncon = tronconRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Le troncon avec l'Id n°" + id + " n'est pas trouvée"));
        tronconRepository.delete(troncon);
    }
}