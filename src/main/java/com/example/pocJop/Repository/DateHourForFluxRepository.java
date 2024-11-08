package com.example.pocJop.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pocJop.Models.DateHourForFlux;

public interface DateHourForFluxRepository extends JpaRepository<DateHourForFlux, Long> {

    Optional<DateHourForFlux> findByAffluence_Id(Long affluenceId);

}
