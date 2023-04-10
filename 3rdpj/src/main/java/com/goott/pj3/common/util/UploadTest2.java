package com.goott.pj3.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class UploadTest2 {

    @Resource(name="upload_path")
    private String uploadPath;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        FileUploadUtil fileUploader = new FileUploadUtil(uploadPath, file, filename);
        try {
            if (fileUploader.newFile()) {
                String base64EncodedImage = fileUploader.getBase64EncodedImage();
                return ResponseEntity.ok(base64EncodedImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
