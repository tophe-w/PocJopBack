package com.example.pocJop.Services;

import java.util.List;
import com.example.pocJop.Dto.gareDtos.*;
import com.example.pocJop.helper.Helpers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import com.example.pocJop.Models.Gare;
import com.example.pocJop.Repository.GareRepository;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Service
public class GareService {

    @Autowired
    private GareRepository gareRepository;

    private final GareDtoMapper gareDtoMapper;

    public List<GareDto> getAllGares() {

        return gareRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream()
                .map(this.gareDtoMapper::from)
                .collect(Collectors.toList());
    }

    public Optional<GareDto> getGareById(Long id) {

        return gareRepository.findById(id)
                .map(this.gareDtoMapper::from);

    }

    public Gare createGare(Gare gare) {
        return gareRepository.save(gare);
    }


    public GareDto updateGare(Long id, Gare gare) {

        Gare gareToUpdate = gareRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + id + " n'est pas trouvée"));

        Helpers.UpdateObjectFields(gare, gareToUpdate);

        gareRepository.save(gareToUpdate);
        return gareDtoMapper.from(gareToUpdate);

    }

    public void deleteGare(Long id) {
        gareRepository.deleteById(id);
    }

}