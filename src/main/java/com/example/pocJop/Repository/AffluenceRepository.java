package com.example.pocJop.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pocJop.Models.Affluence;

public interface AffluenceRepository extends JpaRepository<Affluence, Long> {
    Optional<List<Affluence>> findByDateHourForFlux_Id(Long dateHourForFluxId);
    Optional<List<Affluence>> findByGare_Id(Long gareId);
}
