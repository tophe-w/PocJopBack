package com.example.pocJop.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocJop.Models.Gare;

public interface GareRepository extends JpaRepository<Gare, Long> {

    List<Gare> findByIdIn(List<Long> gareIds);
   
}
