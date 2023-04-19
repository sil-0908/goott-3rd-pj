package com.goott.pj3.common.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
//2023.04.12 길영준
// 파일 공통클래스 컨트롤러 사용 예시
@Controller
public class UploadControllerSample {

    @Resource(name = "upload_path")
    private String uploadPath;

    @GetMapping("/uptest")
    public String index() {
        return "plan/uploadForm";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        FileUploadUtil fileUploader = new FileUploadUtil(uploadPath, file, filename); // 파일업로드 공통클래스 인스턴스 생성
        fileUploader.newFile(); // 업로드메소드
        return "redirect:/uptest";
//        try {
//            if (fileUploader.newFile()) {
//                String base64EncodedImage = fileUploader.getBase64EncodedImage();
//                return ResponseEntity.ok(base64EncodedImage);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
