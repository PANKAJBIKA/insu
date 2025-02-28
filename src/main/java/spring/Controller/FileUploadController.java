package spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import spring.Helper.*;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            // Validate the file
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }

            if (!file.getContentType().equals("application/pdf")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Only PDF content type is allowed");
            }

            // Upload the file
            boolean isUploaded = fileUploadHelper.uploadFile(file);
            if (isUploaded) {
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/uploads/")
                        .path(file.getOriginalFilename())
                        .toUriString();
                return ResponseEntity.ok(fileDownloadUri);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Try again");
    }
}
