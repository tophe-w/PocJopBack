package com.example.pocJop.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RequiredArgsConstructor
@Service
public class ImageService {

    public ResponseEntity<?> getFile(String pathFile) throws IOException {

        Path path = Paths.get(pathFile);
        String extension = FilenameUtils.getExtension(pathFile);

        return ResponseEntity.ok()
                .contentType(getMediaType(extension))
                .body(new ByteArrayResource(Files.readAllBytes(path)));
    }

    private MediaType getMediaType(String extension) {

        return switch (extension) {
            case "png" -> MediaType.IMAGE_PNG;
            case "jpg", "jpeg" -> MediaType.IMAGE_JPEG;
            default -> MediaType.APPLICATION_OCTET_STREAM;
        };
    }
}
