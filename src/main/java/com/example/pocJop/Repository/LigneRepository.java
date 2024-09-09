package com.example.pocJop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocJop.Models.Ligne;

public interface LigneRepository extends JpaRepository<Ligne, Long> {
    List<Ligne> findByNameIn(List<String> names);
}
