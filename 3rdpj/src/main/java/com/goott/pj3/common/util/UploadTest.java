package com.goott.pj3.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
// 2023.04.09 길영준
// 업로드 테스트용
@Controller
public class UploadTest {

        @Resource(name="upload_path")
        private String uploadDir;

        @GetMapping("/uptest")
        public String index() {
            return "plan/uploadForm";
        }

        @PostMapping("/upload")
        public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
            try {
                String fileName = FileUpload.saveFile(uploadDir, file);
                model.addAttribute("fileName", fileName);
                return "uploadSuccess";
            } catch (IOException e) {
                model.addAttribute("error", "Error uploading file: " + e.getMessage());
                return "plan/uploadForm";
            }
        }
}
