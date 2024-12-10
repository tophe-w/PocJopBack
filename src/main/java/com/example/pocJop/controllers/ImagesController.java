package com.example.pocJop.controllers;


import com.example.pocJop.Services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
@CrossOrigin(origins = "http://localhost:4200")
public class ImagesController {

    private final static String IMAGES_GET_PATH = "/get";

    private final ImageService imageService;

    @GetMapping(value=IMAGES_GET_PATH)
    public ResponseEntity<?> getImages(@RequestParam String file) throws IOException {
        return imageService.getFile(file);
    }
}
