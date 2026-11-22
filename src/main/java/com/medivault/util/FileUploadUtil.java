package com.medivault.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

    /**
     * Saves the multipart file to the given upload directory. Returns the saved file path.
     * The method ensures the upload directory exists.
     */
    public static String saveFile(String uploadDir, MultipartFile multipartFile) throws IOException {
        if (multipartFile == null || multipartFile.isEmpty()) {
            throw new IOException("File is empty");
        }

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String original = multipartFile.getOriginalFilename();
        String filename = System.currentTimeMillis() + "_" + (original != null ? original.replaceAll("\\s+", "_") : "file");
        Path filePath = uploadPath.resolve(filename);
        multipartFile.transferTo(filePath.toFile());

        return filePath.toString();
    }

    /**
     * Deletes file if present. Returns true if deleted.
     */
    public static boolean deleteFile(String path) {
        try {
            File f = new File(path);
            return f.exists() && f.delete();
        } catch (Exception ex) {
            return false;
        }
    }
}
