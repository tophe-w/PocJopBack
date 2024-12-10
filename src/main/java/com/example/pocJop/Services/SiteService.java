package com.example.pocJop.Services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.pocJop.Dto.siteDtos.SiteDtoMapper;
import com.example.pocJop.helper.Helpers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.pocJop.Dto.siteDtos.SiteDto;
import com.example.pocJop.Models.Site;
import com.example.pocJop.Repository.SiteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Service
public class SiteService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final String SITE_PLAN_UPLOAD_PATH = "/sites/plans/";
    private final String SITE_PHOTO_UPLOAD_PATH ="/sites/photos/";

    private final SiteRepository siteRepository;

    private final SiteDtoMapper siteDtoMapper;

    public List<SiteDto> getAllSitesEvents() {
        List<Site> sites = siteRepository.findAll();
        if (sites.isEmpty()) {
            throw new RuntimeException("There ara no sites");
        }
        return sites.stream().map(siteDtoMapper::from).toList();
    }

    public Optional<SiteDto> getSiteById(Long id) {

        return siteRepository.findById(id)
                .map(this.siteDtoMapper::from);
    }

    public Site createSite(Site site, List<MultipartFile> photo, MultipartFile plan) {

        Path uploadPathPlan = Paths.get(uploadDir + SITE_PLAN_UPLOAD_PATH +site.getName() + "/");
        Path uploadPathPhoto = Paths.get(uploadDir + SITE_PHOTO_UPLOAD_PATH +site.getName() + "/");
        String filePathPlan = Helpers.pathSavedFile(plan, uploadPathPlan);

        List<String> filePathsPhoto = new ArrayList<>();

        if (filePathPlan != null) {
            for (MultipartFile file : photo) {
                String filePathPhoto = Helpers.pathSavedFile(file, uploadPathPhoto);
                if (filePathPhoto != null) {
                    filePathsPhoto.add(filePathPhoto);
                } else {
                    return null;
            }
                }
            site.setPlanDeSite(filePathPlan);
            site.setPhoto(String.join(" ; ", filePathsPhoto));
        } else {
            return null;
        }

        return siteRepository.save(site);
    }

    public Site updateSite(Long id, Site site) {
        Site siteToUpdate = siteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Le site avec l'Id n°" + id + " n'est pas trouvé"));

        Helpers.UpdateObjectFields(site, siteToUpdate);

        return siteRepository.save(siteToUpdate);
    }

    public void deleteSite(Long id) {
        siteRepository.deleteById(id);
    }
}
