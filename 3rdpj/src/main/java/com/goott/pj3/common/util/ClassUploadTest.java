package com.goott.pj3.common.util;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
// 2023.04.10 길영준 
//클래스 업로드 테스트
@Controller
public class ClassUploadTest {
    @Resource(name="upload_path")
    private String uploadDir;

    @GetMapping("/uptest")
    public String index() {
        return "plan/uploadForm";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "파일고르슈");
            return "plan/uploadResult";
        }

        try {                                                   //경로    파일          파일명
            FileUploadUtil fileUploadUtil = new FileUploadUtil(uploadDir, file, "myFile");
            boolean uploaded = fileUploadUtil.newFile();
            if (uploaded) {
                model.addAttribute("message", "업로드 성공: " + fileUploadUtil.getNewFilename());
            } else {
                model.addAttribute("message", "업로드 실패");
            }
        } catch (IOException e) {
            model.addAttribute("message", "터진오류: " + e.getMessage());
        }

        return "/plan/uploadResult";
    }
}
