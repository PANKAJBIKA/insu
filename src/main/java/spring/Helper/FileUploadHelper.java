package spring.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    private final String UPLOAD_DIR = Paths.get("src/main/resources/static/uploads").toAbsolutePath().toString();

    public FileUploadHelper() {
        // Ensure the upload directory exists
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean isUploaded = false;

        try {
            Path targetLocation = Paths.get(UPLOAD_DIR).resolve(multipartFile.getOriginalFilename());
            Files.copy(multipartFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            isUploaded = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isUploaded;
    }
}
