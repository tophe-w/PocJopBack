package com.example.pocJop.Services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.example.pocJop.Dto.gareDtos.*;
import com.example.pocJop.helper.Helpers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import com.example.pocJop.Models.Gare;
import com.example.pocJop.Repository.GareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
@Service
public class GareService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final GareRepository gareRepository;

    private final GareDtoMapper gareDtoMapper;

    private final String GARE_PLAN_UPLOAD_PATH = "/gares/plans/";
    private final String GARE_PHOTO_UPLOAD_PATH = "/gares/photos/";

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

    public GareDto createGare(Gare gare, MultipartFile file) {
        System.out.println("PATH: " + GARE_PLAN_UPLOAD_PATH);
        Path uploadPath = Paths.get(uploadDir + GARE_PLAN_UPLOAD_PATH +gare.getCode() + "/");
        String filePath = Helpers.pathSavedFile(file, uploadPath);//pathSavedFile(file, gare);
        if (filePath != null) {

            gare.setPlanDeGare(filePath);
            gare.setPlanDeGareSvg(filePath);
            Gare createdGare = gareRepository.save(gare);

            if (createdGare.getId() != null) {
                return gareDtoMapper.from(gare);
            }
        }
        return null;
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