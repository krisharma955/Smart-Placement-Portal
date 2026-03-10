package com.K955.Placement_Portal.Util;

import com.K955.Placement_Portal.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class FileStorageUtil {

    @Value("${app.file.upload-dir}")
    private String uploadDir;

    public String saveFile(MultipartFile file, Long userId) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        Files.createDirectories(uploadPath);

        String uniqueFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        Path targetPath = uploadPath.resolve(uniqueFileName);

        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        return targetPath.toString();
    }

    public Resource loadFile(String filePath) throws MalformedURLException {
        Path path = Paths.get(filePath);

        Resource resource = new UrlResource(path.toUri());

        if(!(resource.exists() && resource.isReadable())) {
            throw new ResourceNotFoundException("Resume", filePath);
        }

        return resource;
    }

    public void deleteFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.deleteIfExists(path);
    }

}
