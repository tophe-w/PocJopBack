package com.example.pocJop.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Slf4j
public class Helpers {

    static public void UpdateObjectFields(Object object, Object objectToUpdate) {
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);

                if (value != null) {
                        field.set(objectToUpdate, value);
                    }


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    static public String pathSavedFile(MultipartFile file, Path uploadPath) {
        String filePath = null;
        try {
            // Save the file to the directory
            filePath = saveImage(file, uploadPath);
        } catch (IOException e) {
            log.error("Error uploading image", e);
            //e.printStackTrace();
        }
        return filePath;
    }

    private static String saveImage(MultipartFile file, Path uploadPath) throws IOException {

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        if (fileName != null) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return filePath.toString();
        }  else {
            throw new IOException("Error uploading image");
        }
    }

}
